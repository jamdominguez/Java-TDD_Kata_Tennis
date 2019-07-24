import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Tennis {
    public static final int PLAYERS = 2;
    public static final List<Integer> POINTS;
    public static final Map<Integer,String> MESSAGES;
    private int[] players; //store players points

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
        this.players = new int[PLAYERS];
    }

    public int getPoints(int player) {
        return this.players[player];
    }

    public void setPoint(int player, int points) throws Exception {
        if (!POINTS.contains(points)) throw new Exception("Invalid points: " + points);
        this.players[player] = points;
    }

    public void winPoint(int player) throws Exception {
        int points = getPoints(player);
        deuceControl(player, points);
        int index = POINTS.indexOf(points);
        int newPoints = POINTS.get(index + 1);
        setPoint(player, newPoints);
    }

    private void deuceControl(int player, int points) throws Exception {
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

        if ("forty to forty".equals(finalMessage.toString())) return "deuce";
        if ("forty to win".equals(finalMessage.toString())) return "player 1 wins!";
        if ("win to forty".equals(finalMessage.toString())) return "player 0 wins!";

        return finalMessage.toString();
    }
}
