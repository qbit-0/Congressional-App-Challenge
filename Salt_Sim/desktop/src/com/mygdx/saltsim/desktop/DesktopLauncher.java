package com.mygdx.saltsim.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.saltsim.SaltSim;

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
        config.width = 1920;
        config.height = 1080;
        config.resizable = false;
<<<<<<< HEAD:test/desktop/src/com/mygdx/game/desktop/DesktopLauncher.java
>>>>>>> work
        new LwjglApplication(new MyGdxGame(), config);
=======
        config.vSyncEnabled = true;
        new LwjglApplication(new SaltSim(), config);
>>>>>>> work:Salt_Sim/desktop/src/com/mygdx/saltsim/desktop/DesktopLauncher.java
    }
}
