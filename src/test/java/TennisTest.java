import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TennisTest {

    Tennis game;

    @Before
    public void before() {
        game = new Tennis();
    }

    @Test(expected = Exception.class)
    public void pointsDifferentesTo_0_15_30_40_produceException() throws Exception {
        Tennis game = new Tennis();
        for (int i = 0; i < 100; i++) {
            if (!Tennis.POINTS.contains(i)) {
                game.setPoint(0, i);
                Assert.assertEquals(i, game.getPoints(0));
            }
        }
    }

    @Test
    public void validPoints0_15_30_40() throws Exception {
        for (Integer points : Tennis.POINTS) {
            game.setPoint(0, points.intValue());
            Assert.assertEquals(points.intValue(), game.getPoints(0));
        }
    }

    @Test
    public void toStartTheGameThePlayersHave0Points() {
        Assert.assertEquals(0, game.getPoints(0));
        Assert.assertEquals(0, game.getPoints(1));
    }

    @Test
    public void ifWinApointIncreaseTheCorretValue() throws Exception {
        Assert.assertEquals(0, game.getPoints(0));
        game.winPoint(0);
        Assert.assertEquals(15, game.getPoints(0));
        game.winPoint(0);
        Assert.assertEquals(30, game.getPoints(0));
        game.winPoint(0);
        Assert.assertEquals(40, game.getPoints(0));
    }

    @Test
    public void ifPlayerHas40AndWinMusControlNoException() throws Exception {
        game.setPoint(0, 40);
        game.winPoint(0);
        Assert.assertEquals(45, game.getPoints(0));
    }

    @Test
    public void scoreReturnsMessageAccordingPlayersPoints() throws Exception {
        Assert.assertEquals("love to love", game.score());
        game.winPoint(0);
        Assert.assertEquals("fifteen to love", game.score());
        game.winPoint(1);
        Assert.assertEquals("fifteen to fifteen", game.score());
        game.winPoint(1);
        Assert.assertEquals("fifteen to thirty", game.score());
        game.winPoint(0);
        Assert.assertEquals("thirty to thirty", game.score());
        game.winPoint(0);
        Assert.assertEquals("forty to thirty", game.score());
        game.winPoint(1);
    }

    @Test
    public void scoreReturnMessageWhenSpecialPoints() throws Exception {
        game.setPoint(0,40);
        game.setPoint(1,40);
        Assert.assertEquals("deuce", game.score());
        game.winPoint(1);
        Assert.assertEquals("advantage for player 1", game.score());
        game.winPoint(0);
        // equals again
        Assert.assertEquals("deuce", game.score());
        game.winPoint(0);
        Assert.assertEquals("advantage for player 0", game.score());
        game.winPoint(0);
        // the game finish and reset the points, player 0 wins the game
        Assert.assertEquals("player 0 wins!", game.score());
    }
}
