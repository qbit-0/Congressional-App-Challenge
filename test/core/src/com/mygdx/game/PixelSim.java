package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;
import java.util.Iterator;

import static com.badlogic.gdx.math.MathUtils.random;

public class PixelSim
{
    public float gravity = .025f;
    public Vector2 wind;
    public ArrayList<Pixel> pixels;

    public ArrayList<Integer> occupiedX;
    public ArrayList<Integer> occupiedY;

    public PixelSim()
    {
        wind = new Vector2();
        pixels = new ArrayList<Pixel>();
        occupiedX = new ArrayList<Integer>();
        occupiedY = new ArrayList<Integer>();
    }

    public void step()
    {
        occupiedX.clear();
        occupiedY.clear();
        if (Gdx.input.isButtonPressed(Input.Buttons.LEFT))
        {
            for (int i = 0; i <= 50; i++)
            {
                int plannedX = Gdx.input.getX() + random(-10, 10);
                int plannedY = MyGdxGame.HEIGHT - Gdx.input.getY() + random(-10, 10);

                boolean available = true;
                for (int blockedX : occupiedX)
                    if (plannedX == blockedX)
                        available = false;
                for (int blockedY : occupiedY)
                    if (plannedY == blockedY)
                        available = false;

                if (available)
                    pixels.add(new Pixel(this, plannedX, plannedY));
            }
        }

        wind.set(random(-1, 1) * .025f, (random(-1, 1) * .025f));

        ArrayList<Pixel> removablePixels = new ArrayList<Pixel>();
        Iterator<Pixel> iterator = pixels.iterator();
        while (iterator.hasNext()) {
            Pixel pixel = iterator.next();

            pixel.step();
            occupiedX.add((int) pixel.getX());
            occupiedY.add((int) pixel.getY());
            pixel.draw(MyGdxGame.batch);

            if (pixel.life < 0)
            {
                removablePixels.add(pixel);
                iterator.remove();
            }
        }

        for (Pixel pixel : removablePixels)
        {
            pixels.remove(pixel);
        }
    }
}
