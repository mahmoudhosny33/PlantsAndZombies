/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game.Screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.PlantsAndZombies;

/**
 *
 * @author MangestOoo
 */
public class MainScreen implements Screen{
    public static void main(String[] args) {
        
    }
     PlantsAndZombies game;
    Texture mainscreen,startbutton;
    public static int S_width=300;
    public static int S_height=150;
    public static int startx=PlantsAndZombies.width/2-S_width/2;
    public static int starty=25;
    private Music music;
    
            
  
    public MainScreen(PlantsAndZombies game) {
        this.game = game;
        music=PlantsAndZombies.manager.get("sounds/SoundMain.ogg", Music.class);
        
    }
    

    @Override
    public void show() {
        mainscreen=new Texture("mainmenu-01.png");
        startbutton=new Texture("startgame.png");
    }
    @Override
    public void render(float delta) {
       Gdx.gl.glClearColor(0,0,0,0);
       Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
       if(Gdx.input.getX()>startx&&Gdx.input.getX()<startx+S_width&&PlantsAndZombies.height - Gdx.input.getY() < starty + S_height && PlantsAndZombies.height - Gdx.input.getY() > starty)
       {
       if(Gdx.input.isTouched()){
           game.setScreen(new MenuScreen(game));
       }
       }  
       
       music.setLooping(true);
       music.play();
       game.batch.begin();
       game.batch.draw(mainscreen, 0,0,PlantsAndZombies.width,PlantsAndZombies.height);
       game.batch.draw(startbutton, startx,starty,S_width,S_height);
       game.batch.end();
       
    
       
    }
    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }
    @Override
    public void hide() {
    }

    @Override
    public void dispose() {
    }
}
