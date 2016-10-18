package ball.model;

import ball.Ball;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static ball.BallTestHarness.assertCenterYCoordinateIs;
import static ball.BallTestHarness.oneStepDownFrom;
import static org.junit.Assert.assertEquals;

/**
 * Created by jbealle on 10/18/16.
 */
public class BouncingBehaviorTest {
    @Test
    public void shouldGoDown() throws Exception {
        BouncingBehavior bouncingBehavior = new BouncingBehavior(BouncingBehavior.DOWN);
        List<Behavior> behaviors = new ArrayList<Behavior>();
        behaviors.add(bouncingBehavior);

        Ball bouncingElasticBall = new BouncingElasticBall(0, 100, 4, behaviors);
        bouncingElasticBall.update();
//        bouncingBehavior.update(bouncingElasticBall);

        assertCenterYCoordinateIs(oneStepDownFrom(100), bouncingElasticBall);

    }

}

