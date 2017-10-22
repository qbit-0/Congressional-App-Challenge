package com.mygdx.saltsim;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;
import java.util.Iterator;

import static com.badlogic.gdx.math.MathUtils.random;

public class SaltWorld
{
    public static final float GRAVITY = 0.005f;
    public static Vector2 wind;

    public static ArrayList<Salt> salts;
    private Vector2 prevMouse;

    public SaltWorld()
    {
        wind = new Vector2();
        salts = new ArrayList<Salt>();
        prevMouse = new Vector2(Gdx.input.getX(), Gdx.input.getY());
    }

    public void step()
    {
        wind.set(random(-1, 1) * 0.025f, random(-1, 1) * 0.025f);

        if (Gdx.input.isButtonPressed(Input.Buttons.LEFT))
        {
            for (int i = 0; i <= 100; i++)
            {
                salts.add(new Salt(Gdx.input.getX() + random(-10, 10),
                        Gdx.graphics.getHeight() - Gdx.input.getY() + random(-10, 10),
                        Gdx.input.getX() - prevMouse.x,
                        Gdx.graphics.getHeight() - Gdx.input.getY() - prevMouse.y));
            }
        }
        prevMouse.set(Gdx.input.getX(), Gdx.graphics.getHeight() - Gdx.input.getY());

        Iterator<Salt> iterator = salts.iterator();
        while (iterator.hasNext())
        {
            Salt salt = iterator.next();
            salt.step();
            salt.draw(SaltSim.batch);
            if (salt.getX() < 0 || salt.getX() > Gdx.graphics.getWidth() || salt.getY() < 0 || salt.getY() > Gdx.graphics.getHeight())
                iterator.remove();
        }
    }
}
