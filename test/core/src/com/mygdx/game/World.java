package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;

public class World
{
    public static final float GRAVITY = -0.01f;

    private ArrayList<Ball> balls = new ArrayList<Ball>();;

    public World()
    {
        balls.add(new Ball(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2));
    }

    public void update(SpriteBatch batch)
    {
        for (Ball ball : balls)
        {
            ball.update();
            ball.draw(batch);
        }
    }
}
