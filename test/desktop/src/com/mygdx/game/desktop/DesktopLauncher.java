package com.mygdx.game.desktop;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.MyGdxGame;

public class DesktopLauncher
{
    public static void main(String[] arg)
    {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.title = "Buggy Crappy Programming";
        config.height = 600;
        config.width = 800;
        config.vSyncEnabled = true;
        config.resizable = false;
        new LwjglApplication(new MyGdxGame(), config);

    }
}
