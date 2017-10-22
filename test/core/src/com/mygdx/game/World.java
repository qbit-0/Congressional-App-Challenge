package com.mygdx.game;

import java.util.ArrayList;

public class World
{
    public static final float GRAVITY = -0.01f;

    private ArrayList<Ball> balls;

    public World()
    {
    }

    public void update()
    {
        for (Ball ball : balls)
            ball.update();
    }
}
