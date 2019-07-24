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
    public static final Map<Integer, String> MESSAGES;
    private PlayerPoints[] players;
    private boolean gameIsOver;


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
        this.players[0] = new PlayerPoints(0, 0, MESSAGES.get(0)); // Player 0
        this.players[1] = new PlayerPoints(0, 0, MESSAGES.get(0)); // Player 1
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
        checkIfGameIsOver();
        int points = getPoints(player);

        //If points 45, +1 win but points are 45 yet
        if (points == 45) {
            this.players[player].setWins(this.players[player].getWins() + 1);
            return; // go out the function
        }
        //If points 40, check if the other player has 45, reduce it to 40
        if (points == 40) {
            int otherPlayer = 0;
            if (player == 0) otherPlayer = 1;
            if (getPoints(otherPlayer) == 45) {
                setPointAndMessage(otherPlayer, 40);
                return; // go out function
            }
        }

        // Update points and increase wins
        int index = POINTS.indexOf(points);
        int newPoints = POINTS.get(index + 1);
        setPointAndMessage(player, newPoints);
        this.players[player].setWins(this.players[player].getWins() + 1);
    }

    public String score() {
        // Win control
        boolean someCanWin = getPoints(0) == 45 || getPoints(1) == 45;
        if (someCanWin) {
            boolean player0Wins = this.players[0].getWins() > this.players[1].getWins() + 1;
            boolean player1Wins = this.players[1].getWins() > this.players[0].getWins() + 1;
            String message = "";
            if (player0Wins) {
                message = "player 0 wins!";
            } else if (player1Wins) {
                message = "player 1 wins!";
            }
            if (player0Wins || player1Wins) {
                this.gameIsOver = true;
                return message;
            }
        }
        // Special cases
        if (getPoints(0) == getPoints(1) && getPoints(0) == 40) return "deuce";
        if (getPoints(0) == 45 && getPoints(1) == 40) return "advantage for player 0";
        if (getPoints(0) == 40 && getPoints(1) == 45) return "advantage for player 1";
        // Other case
        String finalMessage = this.players[0].getMessagePoints() + " to " + this.players[1].getMessagePoints();

        return finalMessage;
    }

    private void checkIfGameIsOver() throws Exception {
        score(); // To update gameIsOver is necessary check game state
        if (this.gameIsOver) throw new Exception("The game is Over");
    }
}