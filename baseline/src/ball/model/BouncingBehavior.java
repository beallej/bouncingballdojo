package ball.model;

import ball.Ball;
import ball.ui.BallWorld;

/**
 * Created by jbealle on 10/18/16.
 */
public class BouncingBehavior implements Behavior {
    public static final int MOVEMENT_SPEED = 12;

    static final int DOWN = 1;
    static final int UP = -1;

    private int direction;
    private int y;
    private Ball ball;
    private int radius;


    @Override
    public void update(Ball ball) {
        y = ball.y();
        radius = ball.radius();
        direction = reverseDirectionIfNecessary();
        y = move();
        ball.setY(y);
    }

    /***********************************************************************************
     *
     * Do not change Bouncing ALGORITHM below.
     *
     ***********************************************************************************/

    private int reverseDirectionIfNecessary() {
        if (movingTooHigh() || movingTooLow()) {
            return switchDirection();
        }

        return this.direction;
    }

    private boolean movingTooLow() {
        return y + radius >= BallWorld.BOX_HEIGHT && movingDown();
    }

    private boolean movingTooHigh() {
        return y - radius <= 0 && movingUp();
    }

    private int switchDirection() {
        return movingDown() ? UP : DOWN;
    }

    private int move() {
        return y + (MOVEMENT_SPEED * direction);
    }

    private boolean movingDown() {
        return direction == DOWN;
    }

    private boolean movingUp() {
        return direction == UP;
    }

    public BouncingBehavior(int down) {
        this.direction = down;
    }

    public BouncingBehavior(Ball ball, int down) {
        this.ball = ball;
        this.y = ball.y();
        this.radius = ball.radius();
    }

}
