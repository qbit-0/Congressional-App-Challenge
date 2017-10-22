package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

import static com.badlogic.gdx.math.MathUtils.random;

public class Pixel extends Sprite
{
    public int life = 100;

    private PixelSim sim;
    private Vector2 vel;
    private Vector2 accel;

    public Pixel(PixelSim sim, float posX, float posY)
    {
        this.sim = sim;

        setX(posX);
        setY(posY);

        vel = new Vector2();
        accel = new Vector2();
    }

    public void step()
    {
        life -= 1;
        accel.add(random(-1, 1) * .0025f, random(-1, 1) * .0025f);
        accel.add(sim.wind);
        accel.add(0, -sim.gravity);

        vel.add(accel);

        int newX = (int) (getX() + vel.x);
        int newY = (int) (getX() + vel.x);

        if ((int) getX() != newX && random() < 0.01)
        {
            for (int blockedX : sim.occupiedX)
                if (newX == blockedX)
                {
                    accel.x *= 0.5;
                    vel.x *= 0.5;
                }
        }

        if ((int) getY() != newY)
        {
            for (int blockedY : sim.occupiedY)
                if (newY == blockedY && random() < 0.01)
                {
                    accel.y *= 0.5;
                    vel.y *= 0.5;
                }
        }

        if ((int) getX() < 0 || (int) getX() > MyGdxGame.WIDTH)
        {
            accel.x = 0;
            vel.x = -vel.x * .1f;
        }
        if ((int) getY() < 0 || (int) getY() > MyGdxGame.HEIGHT)
        {
            accel.y = 0;
            vel.y = -vel.y * .1f;
        }

        setX(getX() + vel.x);
        setY(getY() + vel.y);
    }

    @Override
    public void draw(Batch batch)
    {
//        super.draw(batch);
        batch.draw(MyGdxGame.pixelTexure, getX(), getY());
    }
}
