import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class TennisTest {

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

    @Test
    public void validPoints0_15_30_45() throws Exception {
        Tennis game = new Tennis();
        for (Integer points : Tennis.VALID_POINTS) {
            game.setPoint(0, points.intValue());
            Assert.assertEquals(points.intValue(), game.getPoints(0));
        }
    }
}
