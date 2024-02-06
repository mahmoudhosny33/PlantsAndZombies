package com.mygdx.game.desktop;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.PlantsAndZombies;

public class DesktopLauncher {

    public static void main(String[] arg) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.width = PlantsAndZombies.width;
        config.height = PlantsAndZombies.height;
        config.resizable = false;
        new LwjglApplication(new PlantsAndZombies() {
        }, config);
    }
}
