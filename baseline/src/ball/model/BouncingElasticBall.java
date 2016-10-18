package ball.model;

import java.util.List;

/**
 * Created by jbealle on 10/18/16.
 */
public class BouncingElasticBall extends BallImpl{
    private  List<Behavior> behaviors;

    public BouncingElasticBall(int x, int y, int radius, List<Behavior> behaviors) {
        super(x,y,radius);
        this.behaviors = behaviors;

    }

    @Override
    public void update() {
        for (Behavior behavior: behaviors
             ) {
            behavior.update(this);
        }
    }
}
