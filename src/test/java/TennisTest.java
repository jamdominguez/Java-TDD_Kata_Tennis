import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class TennisTest {

    @Test(expected = Exception.class)
    public void pointsDifferentesTo_0_15_30_40_produceException() throws Exception {
        Tennis game = new Tennis();
        for (int i = 0; i < 100; i++) {
            if (!Tennis.VALID_POINTS.contains(i)) {
                game.setPoint(0, i);
                Assert.assertEquals(i, game.getPoints(0));
            }
        }
    }

    @Test
    public void validPoints0_15_30_40() throws Exception {
        Tennis game = new Tennis();
        for (Integer points : Tennis.VALID_POINTS) {
            game.setPoint(0, points.intValue());
            Assert.assertEquals(points.intValue(), game.getPoints(0));
        }
    }

    @Test
    public void toStartTheGameThePlayersHave0Points() {
        Tennis game = new Tennis();
        Assert.assertEquals(0, game.getPoints(0));
        Assert.assertEquals(0, game.getPoints(1));
    }

    @Test
    public void ifWinApointIncreaseTheCorretValue() throws Exception {
        Tennis game = new Tennis();
        Assert.assertEquals(0, game.getPoints(0));
        game.winPoint(0);
        Assert.assertEquals(15, game.getPoints(0));
        game.winPoint(0);
        Assert.assertEquals(30, game.getPoints(0));
        game.winPoint(0);
        Assert.assertEquals(40, game.getPoints(0));
    }

    @Test
    public void scoreReturnsMessageAccordingPlayersPoints() throws Exception {
        Tennis game = new Tennis();
        Assert.assertEquals("love to love", game.score());
    }


}
