package com.mygdx.saltsim.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.saltsim.SaltSim;

public class DesktopLauncher
{
    public static void main(String[] arg)
    {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.title = "Salt Simulator";
        config.width = 1920;
        config.height = 1080;
        config.resizable = false;
        config.vSyncEnabled = true;
        new LwjglApplication(new SaltSim(), config);
    }
}
