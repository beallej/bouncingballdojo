package ball.model;

import ball.Ball;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static ball.BallTestHarness.assertRadiusIs;
import static ball.BallTestHarness.oneStepInwardsFrom;

/**
 * Created by jbealle on 10/18/16.
 */
public class ElasticBehaviorTest {
    @Test
    public void shouldDecreaseRadius() {
        List<Behavior> behaviors = new ArrayList<Behavior>();

        ElasticBehavior behavior = new ElasticBehavior(ElasticBehavior.SHRINK);
        behaviors.add(behavior);
        Ball bouncingElasticBall = new BouncingElasticBall(0, 0, 20, behaviors);

        bouncingElasticBall.update();

        assertRadiusIs(oneStepInwardsFrom(20), bouncingElasticBall);
    }
}
