package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
<<<<<<< HEAD
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
=======
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
>>>>>>> work
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyGdxGame extends ApplicationAdapter
{
<<<<<<< HEAD
    private SpriteBatch batch;
    private Texture texture;
    private Sprite sprite;
=======
    public static int WIDTH = 800;
    public static int HEIGHT = 600;

    public static SpriteBatch batch;

    public static Pixmap pixelPixmap;
    public static Texture pixelTexure;

    public PixelSim pixelSim;
>>>>>>> work

    public MyGdxGame()
    {
        super();
    }

    @Override
    public void create()
    {
        batch = new SpriteBatch();
<<<<<<< HEAD
        texture = new Texture(Gdx.files.internal("image.png"));
        sprite = new Sprite(texture);
    }

    @Override
    public void resize(int width, int height)
    {
        super.resize(width, height);
=======

        pixelPixmap = new Pixmap(1, 1, Pixmap.Format.RGBA8888);
        pixelPixmap.setColor(Color.WHITE);
        pixelPixmap.fill();
        pixelTexure = new Texture(pixelPixmap);

        pixelSim = new PixelSim();
>>>>>>> work
    }

    @Override
    public void render()
    {
<<<<<<< HEAD
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        sprite.draw(batch);
=======
        Gdx.gl.glClearColor(.1f, .1f, .1f, 1);
        Gdx.gl.glClear(Gdx.gl.GL_COLOR_BUFFER_BIT);

        batch.begin();
        pixelSim.step();
>>>>>>> work
        batch.end();
    }

    @Override
<<<<<<< HEAD
    public void pause()
    {
        super.pause();
    }

    @Override
    public void resume()
    {
        super.resume();
    }

    @Override
    public void dispose()
    {
        batch.dispose();
        texture.dispose();
=======
    public void dispose()
    {
        batch.dispose();
        pixelPixmap.dispose();
        pixelTexure.dispose();
>>>>>>> work
    }
}
