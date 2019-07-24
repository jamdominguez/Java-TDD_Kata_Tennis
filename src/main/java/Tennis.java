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
        // Init players points
        this.players = new PlayerPoints[PLAYERS];
        this.players[0] = new PlayerPoints(); // Player 0
        this.players[1] = new PlayerPoints(); // Player 1
    }

    public int getPoints(int player) {
        return this.players[player].getPoints();
    }

    public void setPointAndMessage(int player, int points) throws Exception {
        // Error control
        if (!POINTS.contains(points)) throw new Exception("Invalid points: " + points);
        // Setting points
        this.players[player].setPoints(points);
        this.players[player].setMessagePoints(MESSAGES.get(points));
    }

    public void winPoint(int player) throws Exception {
        int points = getPoints(player);
        boolean pointsUpdated = deucePointsControl(player, points);



        int index = POINTS.indexOf(points);
        int newPoints = POINTS.get(index + 1);
        setPointAndMessage(player, points);
        // Control when equals and advantages
        this.players[player].setWins(this.players[player].getWins() + 1);
        //System.out.println("Player0W["+this.players[0].getWins()+"] Player1W["+this.players[1].getWins()+"]");
    }

    private boolean deucePointsControl(int player, int points) throws Exception {
        System.out.println("deucePointsControl player["+player+"] points["+points+"]");
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
            if (otherPlayerPoints == 45) setPointAndMessage(otherPlayer, 40);
            System.out.println("player["+player+"] points["+points+"] otherPlayer["+otherPlayer+"] otherPlayerPoints["+otherPlayerPoints+"]");
            System.out.println("Player0["+this.players[0].getPoints()+"] Player1["+this.players[1].getPoints()+"]");
            return true;
        }
        return false;
    }

    public String score() {
        //System.out.println("Player0_p["+this.players[0].getPoints()+"] Player0_m["+this.players[0].getMessagePoints()+"]");
        //System.out.println("Player1_p["+this.players[1].getPoints()+"] Player1_m["+this.players[1].getMessagePoints()+"]");
        // Win control
        if (this.players[0].getWins() > this.players[1].getWins() + 1) return "player 0 wins!";
        if (this.players[1].getWins() > this.players[0].getWins() + 1) return "player 1 wins!";
        // Special cases
        if (getPoints(0) == getPoints(1) && getPoints(0) == 40) return "deuce";
        if (getPoints(0) == 45 && getPoints(1) == 40) return "advantage for player 0";
        if (getPoints(0) == 40 && getPoints(1) == 45) return "advantage for player 1";
        // Other case
        String finalMessage = this.players[0].getMessagePoints() + " to " + this.players[1].getMessagePoints();

        return finalMessage.toString();
    }
}
