package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

public class Ball extends Sprite
{
    public static Texture texture;

    private Vector2 vel;
    private Vector2 accel;

    public Ball(float x, float y)
    {
        if (texture == null)
            new Texture("purple.png");

        setX(x);
        setY(y);
        vel = new Vector2(30,20);
        accel = new Vector2();
    }

    public void update()
    {
        accel.add(0, World.GRAVITY);
        vel.add(accel);
        setX(getX() + vel.x);
        setY(getY() + vel.y);
    }

    @Override
    public void draw(Batch batch)
    {
//        super.draw(batch);
        batch.draw(texture, getX(), getY());
    }
}
