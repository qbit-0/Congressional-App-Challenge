package com.mygdx.saltsim;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

import static com.badlogic.gdx.math.MathUtils.random;

public class Salt extends Sprite
{
    private static Pixmap pixmap;
    private static Texture texture;

    private Vector2 vel = new Vector2();
    private Vector2 accel = new Vector2();

    public Salt(float x, float y, float velX, float velY)
    {
        if (pixmap == null && texture == null)
        {
            pixmap = new Pixmap(1, 1, Pixmap.Format.RGB888);
            pixmap.setColor(1, 1, 1, 0.1f);
            pixmap.fill();
            texture = new Texture(pixmap);
        }

        setX(x);
        setY(y);
        vel.set(velX * 0.1f, velY * 0.1f);
    }

    public void step()
    {
        accel.add(random(-1, 1) * 0.01f, random(-1, 1) * 0.01f);
        accel.add(SaltWorld.wind);
        accel.add(0, -SaltWorld.GRAVITY);

        Salt target = SaltWorld.salts.get(random(SaltWorld.salts.size() - 1));
        accel.add(Math.signum(target.getX() - getX()) * 0.01f, Math.signum(target.getY() - getY()) * 0.01f);

        accel.add(accel.x * -0.1f, accel.y * -0.1f);
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
