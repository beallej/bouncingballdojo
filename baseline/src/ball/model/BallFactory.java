package ball.model;

import ball.Ball;

import java.util.ArrayList;
import java.util.List;

public class BallFactory {

    public static Ball[] all() {
        return new Ball[]{
                bouncingBall(75, 50, BouncingBall.DOWN),
                elasticBall(250, 100, Ball.DEFAULT_RADIUS, ElasticBall.SHRINK),
                bouncingElasticBall(300, 100, Ball.DEFAULT_RADIUS)
        };
    }

    private static Ball bouncingElasticBall(int centerX, int centerY, int radius) {
        Behavior bouncingBehavior = new BouncingBehavior(BouncingBehavior.DOWN);
        Behavior elasticBehavior = new ElasticBehavior(ElasticBehavior.SHRINK);
        List<Behavior> behaviors = new ArrayList<Behavior>();
        behaviors.add(bouncingBehavior);
        behaviors.add(elasticBehavior);
        return new BouncingElasticBall(centerX, centerY, radius, behaviors);
    }

    public static Ball bouncingBall(int centerX, int centerY, int direction) {
        return new BouncingBall(centerX, centerY, direction);
    }

    public static Ball elasticBall(int centerX, int centerY, int radius, int direction) {
        return new ElasticBall(centerX, centerY, radius, direction);
    }
}
