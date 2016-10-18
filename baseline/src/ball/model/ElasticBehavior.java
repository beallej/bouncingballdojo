package ball.model;

import ball.Ball;

/**
 * Created by jbealle on 10/18/16.
 */
public class ElasticBehavior implements Behavior{
    public static final int GROWTH_RATE = 2;

    static final int GROW = 1;
    static final int SHRINK = -1;

    private int growthDirection;
    private int radius;

    public ElasticBehavior(int growthDirection){
        this.growthDirection = growthDirection;

    }

    @Override
    public void update(Ball ball) {
        radius = ball.radius();
        growthDirection = reverseGrowthDirectionIfNecessary();
        radius = next();
        ball.setRadius(radius);
    }

    /***********************************************************************************
     *
     * Do not change Elastic ALGORITHM below.
     *
     ***********************************************************************************/

    private int reverseGrowthDirectionIfNecessary() {
        if (growingTooBig() || shrinkingTooSmall()) {
            return switchDirection();
        }

        return this.growthDirection;
    }

    private boolean shrinkingTooSmall() {
        return radius <= 0 && shrinking();
    }

    private boolean growingTooBig() {
        return radius >= Ball.DEFAULT_RADIUS && growing();
    }

    private int switchDirection() {
        return growing() ? SHRINK : GROW;
    }

    private int next() {
        return radius + (GROWTH_RATE * growthDirection);
    }

    private boolean shrinking() {
        return growthDirection == SHRINK;
    }

    private boolean growing() {
        return growthDirection == GROW;
    }
}
