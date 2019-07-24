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
        for (int i = 0; i < 100; i++) {
            if (!Tennis.POINTS.contains(i)) {
                game.setPointAndMessage(0, i);
            }
        }
    }

    @Test
    public void validPoints0_15_30_40() throws Exception {
        for (Integer points : Tennis.POINTS) {
            game.setPointAndMessage(0, points.intValue());
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
    public void ifPlayerHas40AndWinMustControlNoException() throws Exception {
        game.setPointAndMessage(0, 40);
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
        game.setPointAndMessage(0,30);
        game.setPointAndMessage(1,40);
        game.winPoint(0);
        Assert.assertEquals("deuce", game.score());
        game.winPoint(1);
        Assert.assertEquals("advantage for player 1", game.score());
        game.winPoint(0);
        // equals again
        Assert.assertEquals("deuce", game.score());
        game.winPoint(0);
        Assert.assertEquals("advantage for player 0", game.score());
        game.winPoint(0);
        // player 0 wins the game
        Assert.assertEquals("player 0 wins!", game.score());
    }

    @Test
    public void simulatePlayer0WinBy45TO0() throws Exception {
        Assert.assertEquals("love to love", game.score());
        game.winPoint(0);
        Assert.assertEquals("fifteen to love", game.score());
        game.winPoint(0);
        Assert.assertEquals("thirty to love", game.score());
        game.winPoint(0);
        Assert.assertEquals("forty to love", game.score());
        game.winPoint(0);
        Assert.assertEquals("player 0 wins!", game.score());
    }

    @Test
    public void simulatePlayer1WinBy45TO0() throws Exception {
        Assert.assertEquals("love to love", game.score());
        game.winPoint(1);
        Assert.assertEquals("love to fifteen", game.score());
        game.winPoint(1);
        Assert.assertEquals("love to thirty", game.score());
        game.winPoint(1);
        Assert.assertEquals("love to forty", game.score());
        game.winPoint(1);
        Assert.assertEquals("player 1 wins!", game.score());
    }

    @Test(expected = Exception.class)
    public void ifSomeOneWinsTheGameFinishAndProduceExceptionIfTryPlay() throws Exception {
        game.winPoint(1); // 15
        game.winPoint(1); // 30
        game.winPoint(1); // 40
        game.winPoint(1); // 45, Win!
        game.winPoint(1); // must produces a exception
        game.winPoint(0); // must produce a exception
    }

    @Test
    public void checkToString_Lombok() {
        PlayerPoints p1 = new PlayerPoints(0 , 0 , "love");
        String out1 = p1.toString();
        PlayerPoints p2 = new PlayerPoints(1 , 15 , "fifteen");
        String out2 = p2.toString();
        System.out.println(out1);
        System.out.println(out2);
        Assert.assertEquals(true, out1 instanceof String);
        Assert.assertEquals(true, out1.length() > 0);
        Assert.assertEquals(true, out2 instanceof String);
        Assert.assertEquals(true, out2.length() > 0);
    }
}