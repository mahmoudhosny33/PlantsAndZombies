/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.PlantsAndZombies;
import com.mygdx.game.Screens.MenuScreen;
import static com.mygdx.game.Screens.MainScreen.S_height;
import static com.mygdx.game.Screens.MainScreen.S_width;
import static com.mygdx.game.Screens.MainScreen.startx;
import static com.mygdx.game.Screens.MainScreen.starty;

/**
 *
 * @author MangestOoo
 */
public class homepage implements Screen {
  PlantsAndZombies game;
    Texture homePage,button;
    public static int S_width=300;
    public static int S_height=150;
    public static int startx=PlantsAndZombies.width/2-S_width/2;
    public static int starty=25;
    homepage(PlantsAndZombies game) {
       this.game = game;
    }

    @Override
    public void show() {
       homePage = new Texture("helpPage1.png");
        button=new Texture("activeButton1.png");
    }

    @Override
    public void render(float delta) {
    Gdx.gl.glClearColor(0,0,0,0);
       Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
       game.batch.begin();
       game.batch.draw(homePage, 0,0,0,0,PlantsAndZombies.width,PlantsAndZombies.height);
      if(Gdx.input.getX()>startx&&Gdx.input.getX()<startx+S_width&&PlantsAndZombies.height - Gdx.input.getY() < starty + S_height-100 && PlantsAndZombies.height - Gdx.input.getY() > starty)
       {
            game.batch.draw(button, 0,0,0,0,PlantsAndZombies.width,PlantsAndZombies.height);
       if(Gdx.input.isTouched()){
           game.setScreen(new MenuScreen(game));
       }
       }  
            
  
     
      
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
