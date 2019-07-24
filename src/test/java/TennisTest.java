import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class TennisTest {

    @Test
    public void validPlayerPoints_0() throws Exception {
        Tennis game = new Tennis();
        game.setPoint(0, 0);
        Assert.assertEquals(0, game.getPoints(0));
    }

    @Test
    public void validPlayerPoints_15() throws Exception {
        Tennis game = new Tennis();
        game.setPoint(0, 15);
        Assert.assertEquals(15, game.getPoints(0));
    }

    @Test
    public void validPlayerPoints_30() throws Exception {
        Tennis game = new Tennis();
        game.setPoint(0, 30);
        Assert.assertEquals(30, game.getPoints(0));
    }

    @Test
    public void validPlayerPoints_45() throws Exception {
        Tennis game = new Tennis();
        game.setPoint(0, 45);
        Assert.assertEquals(45, game.getPoints(0));
    }

    @Test(expected = Exception.class)
    public void pointsDifferentesTo_0_15_30_45_produceException() throws Exception {
        Tennis game = new Tennis();
        for (int i = 0; i < 100; i++) {
            if (!Tennis.VALID_POINTS.contains(i)) {
                game.setPoint(0, i);
                Assert.assertEquals(i, game.getPoints(0));
            }
        }
    }
}
