import org.junit.Assert;
import org.junit.Test;

public class TennisTest {

    @Test
    public void validPlayerPoints_0() {
        Tennis game= new Tennis();
        game.setPoint(0,0);
        Assert.assertEquals(0, game.getPoints(0));
    }

    @Test
    public void validPlayerPoints_15() {
        Tennis game= new Tennis();
        game.setPoint(0,15);
        Assert.assertEquals(15, game.getPoints(0));
    }
}
