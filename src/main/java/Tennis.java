import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Tennis for 2 player (requirements)
 */
public class Tennis {
    public static final int PLAYERS = 2;
    public static final List<Integer> POINTS;
    public static final Map<Integer,String> MESSAGES;
    private PlayerPoints[] players;

    static {
        POINTS = new LinkedList<Integer>();
        POINTS.add(0);
        POINTS.add(15);
        POINTS.add(30);
        POINTS.add(40);
        POINTS.add(45);
        MESSAGES = new HashMap<Integer, String>();
        MESSAGES.put(0, "love");
        MESSAGES.put(15, "fifteen");
        MESSAGES.put(30, "thirty");
        MESSAGES.put(40, "forty");
        MESSAGES.put(45, "win");
    }

    public Tennis() {
        this.players = new PlayerPoints[PLAYERS];
        this.players[0] = new PlayerPoints(); // Player 0
        this.players[1] = new PlayerPoints(); // Player 1
    }

    public int getPoints(int player) {
        return this.players[player].getPoints();
    }

    public void setPoint(int player, int points) throws Exception {
        if (!POINTS.contains(points)) throw new Exception("Invalid points: " + points);
        this.players[player].setPoints(points);
    }

    public void winPoint(int player) throws Exception {
        int points = this.players[player].getPoints();
        deucePointsControl(player, points);
        int index = POINTS.indexOf(points);
        int newPoints = POINTS.get(index + 1);
        this.players[player].setPoints(newPoints);
        this.players[player].setWins(this.players[player].getWins() + 1);
    }

    private void deucePointsControl(int player, int points) throws Exception {
        if (points == 40) {
            int otherPlayer;
            int otherPlayerPoints;
            if(player == 0) {
                otherPlayer = 1;
                otherPlayerPoints = getPoints(otherPlayer);
            } else {
                otherPlayer = 0;
                otherPlayerPoints = getPoints(otherPlayer);
            }
            if (otherPlayerPoints == 45) setPoint(otherPlayer, 40);
        }
    }

    public String score() {
        // Get points like message
        String[] messages = new String[PLAYERS];
        for (int i = 0; i < this.players.length; i++) {
            if (MESSAGES.containsKey(getPoints(i))) {
                messages[i] = MESSAGES.get(getPoints(i));
            }
        }
        // Build returned message
        StringBuilder finalMessage = new StringBuilder();
        for (int i= 0; i < messages.length - 1; i++) {
            finalMessage.append(messages[i]).append(" to ");
        }
        finalMessage.append(messages[messages.length - 1]);
        // Special cases
        if (this.players[0].getWins() > this.players[1].getWins() + 1) return "player 0 wins!";
        if (this.players[1].getWins() > this.players[0].getWins() + 1) return "player 1 wins!";
        if ("forty to forty".equals(finalMessage.toString())) return "deuce";
        if ("win to forty".equals(finalMessage.toString())) return "advantage for player 0";
        if ("forty to win".equals(finalMessage.toString())) return "advantage for player 1";

        return finalMessage.toString();
    }
}
