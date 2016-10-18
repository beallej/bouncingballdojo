package ball.model;

import ball.Ball;

import java.awt.*;
import java.util.*;
import java.util.List;

public abstract class BallImpl implements Ball {
    protected int x;
    protected int y;
    protected int radius;

    protected BallImpl(int x, int y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    protected BallImpl(int x, int y) {
        this(x, y, DEFAULT_RADIUS);
    }

    // DO NOT CHANGE
    @Override
    public int radius() {
        return radius;
    }

    // DO NOT CHANGE
    @Override
    public Point center() {
        return new Point(x, y);
    }

    @Override
    public abstract void update();

    @Override
    public int y(){return y;}

    @Override
    public void setY(int y){ this.y = y;}

    @Override
    public void setRadius(int radius) {
        this.radius = radius;
    }
}
