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

    public Ball()
    {
        if (texture == null)
            new Texture("purple.png");

        vel = new Vector2();
        accel = new Vector2();

    }

    public void update()
    {
        accel.add(0, World.GRAVITY);
    }

    @Override
    public void draw(Batch batch)
    {
//        super.draw(batch);
        batch.draw(texture, getX(), getY());
    }
}
