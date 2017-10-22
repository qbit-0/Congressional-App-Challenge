package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;

public class World
{
    public static final float GRAVITY = -0.01f;

    public static ArrayList<Ball> balls = new ArrayList<Ball>();
    ;

    public World()
    {
        balls.add(new Ball(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2));
    }

    public void update(SpriteBatch batch)
    {
        if (Gdx.input.isButtonPressed(Input.Buttons.LEFT))
        {
            float x = Gdx.input.getX();
            float y = Gdx.graphics.getHeight() - Gdx.input.getY();

            boolean drawable = true;
            for (Ball ball : balls)
            {
                if (x > ball.getX() - Ball.texture.getWidth() && x < ball.getX() + Ball.texture.getWidth() && y > ball.getY() - Ball.texture.getHeight() && y < ball.getY() + Ball.texture.getHeight())
                    drawable = false;
            }

            if (drawable)
                balls.add(new Ball(x, y));
        }

        for (Ball ball : balls)
        {
            ball.update();
            ball.draw(batch);
        }
    }
}
