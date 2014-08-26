package com.ld.banana.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.ld.banana.BananaGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		
		config.title = "Banana Game";
		config.width = 800;
		config.height = 600;
		
		new LwjglApplication(new BananaGame(), config);
	}
}
