package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.MyGdxGame;

public class DesktopLauncher
{
    public static void main(String[] arg)
    {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
<<<<<<< HEAD
        config.title = "Test";
        config.height = 600;
        config.width = 800;
=======
        config.title = "Salt Simulator";
        config.width = 800;
        config.height = 600;
        config.resizable = false;
>>>>>>> work
        new LwjglApplication(new MyGdxGame(), config);
    }
}
