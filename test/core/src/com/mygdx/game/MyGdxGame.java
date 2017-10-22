package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyGdxGame extends ApplicationAdapter
{
    public static int WIDTH = 800;
    public static int HEIGHT = 600;

    public static SpriteBatch batch;

    public static Pixmap pixelPixmap;
    public static Texture pixelTexure;

    public PixelSim pixelSim;

    public MyGdxGame()
    {
        super();
    }

    @Override
    public void create()
    {
        batch = new SpriteBatch();

        pixelPixmap = new Pixmap(1, 1, Pixmap.Format.RGBA8888);
        pixelPixmap.setColor(Color.WHITE);
        pixelPixmap.fill();
        pixelTexure = new Texture(pixelPixmap);

        pixelSim = new PixelSim();
    }

    @Override
    public void render()
    {
        Gdx.gl.glClearColor(.1f, .1f, .1f, 1);
        Gdx.gl.glClear(Gdx.gl.GL_COLOR_BUFFER_BIT);

        batch.begin();
        pixelSim.step();
        batch.end();
    }

    @Override
    public void dispose()
    {
        batch.dispose();
        pixelPixmap.dispose();
        pixelTexure.dispose();
    }
}
