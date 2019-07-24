import java.util.LinkedList;
import java.util.List;

public class Tennis {
    public static final List<Integer> VALID_POINTS;
    private int points;

static {
    VALID_POINTS = new LinkedList<Integer>();
    VALID_POINTS.add(0);
    VALID_POINTS.add(15);
    VALID_POINTS.add(30);
    VALID_POINTS.add(40);
}

    public int getPoints(int player) {
        return this.points;
    }

    public void setPoint(int player, int points) throws Exception {
        if (!VALID_POINTS.contains(points)) throw new Exception("Invalid points: " + points);
        this.points = points;
    }

    public void winPoint(int player) throws Exception {
        int points = getPoints(player);
        int index = VALID_POINTS.indexOf(points);
        int newPoints = VALID_POINTS.get(index + 1);
        //System.out.println("points["+points+"] index["+index+"] newPoints["+newPoints+"]");
        setPoint(player, newPoints);
    }
}
