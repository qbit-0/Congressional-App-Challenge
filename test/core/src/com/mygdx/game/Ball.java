package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

import static com.badlogic.gdx.math.MathUtils.random;

public class Ball extends Sprite
{
    public static Texture texture;

    private Vector2 vel;
    private Vector2 accel;

    public Ball(float x, float y)
    {
        if (texture == null)
            texture = new Texture("circle.png");

        setX(x);
        setY(y);
        vel = new Vector2(random(-5, 5), random(-5, 5));
        accel = new Vector2();
    }

    public void update()
    {
        accel.add(random(-1, 1) * .001f, random(-1, 1) * .001f);
        accel.add(0, World.GRAVITY);
        vel.add(accel);

        for (Ball ball : World.balls)
        {
            if (ball != this)
            {
                if (getX() + vel.x > ball.getX() - Ball.texture.getWidth() && getX() + vel.x < ball.getX() + Ball.texture.getWidth() &&
                        getY() > ball.getY() - Ball.texture.getHeight() && getY() < ball.getY() + Ball.texture.getHeight())
                {
                    accel.x = accel.x * -0.01f;
                    vel.x = vel.x * -.1f;
                }
                if (getY() + vel.y > ball.getY() - Ball.texture.getHeight() && getY() + vel.y < ball.getY() + Ball.texture.getHeight() &&
                        getX() > ball.getX() - Ball.texture.getWidth() && getX() < ball.getX() + Ball.texture.getWidth())
                {
                    accel.y = accel.y * -0.01f;
                    vel.y = vel.y * -.1f;
                }
            }
        }

        if (getX() - texture.getWidth() / 2 < 0 || getX() + texture.getWidth() / 2 > Gdx.graphics.getWidth())
        {
            accel.x = 0;
            vel.x = vel.x * -0.5f;
        }
        if (getY() - texture.getHeight() / 2 < 0 || getY() + texture.getHeight() / 2 > Gdx.graphics.getHeight())
        {
            accel.y = 0;
            vel.y = vel.y * -0.5f;
        }

        Vector2 drag = new Vector2(accel.x * -0.001f, accel.y * -0.001f);
        accel.add(drag);

        setX(getX() + vel.x);
        setY(getY() + vel.y);
    }

    @Override
    public void draw(Batch batch)
    {
//        super.draw(batch);
        batch.draw(texture, getX() - texture.getWidth() / 2, getY() - texture.getHeight() / 2);
    }
}
