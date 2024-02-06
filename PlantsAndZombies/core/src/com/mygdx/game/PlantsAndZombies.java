package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Screens.MainScreen;
import com.sun.javafx.scene.SceneHelper;
import com.sun.javafx.stage.ScreenHelper;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.mygdx.game.Screens.Level1;
import com.mygdx.game.Screens.Level2;
import com.mygdx.game.Screens.MenuScreen;
import com.mygdx.game.Screens.WinningScreen;
public class PlantsAndZombies extends Game {
       public static AssetManager manager;

    
	public SpriteBatch batch;
        public static int width=1000;
        public static int height=750;
	@Override
	public void create () {
		batch = new SpriteBatch();
                manager=new AssetManager();
                manager.load("sounds/IntroTheme.mp3", Music.class);
                manager.load("sounds/Grasswalk.mp3", Music.class);
                manager.load("sounds/lawnmower.wav", Music.class);
                manager.load("sounds/plant1.ogg", Music.class);
                manager.load("sounds/chomp.wav", Music.class);
                manager.load("sounds/Points.ogg", Music.class);
                manager.load("sounds/zombies_are_coming.wav", Music.class);
                
                        
                manager.finishLoading();
		this.setScreen(new MenuScreen(this));
	}

	@Override
	public void render () {
		super.render();
	}
        @Override
        public void dispose () {
		batch.dispose();
	}
        
}
