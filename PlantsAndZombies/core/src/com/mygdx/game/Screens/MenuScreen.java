/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game.Screens;

/**
 *
 * @author MangestOoo
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.mygdx.game.PlantsAndZombies;
import static com.mygdx.game.Screens.MainScreen.S_width;
import static com.mygdx.game.Screens.MainScreen.startx;
import static jdk.nashorn.internal.codegen.ObjectClassGenerator.pack;

/**
 *
 * @author MangestOoo
 */
public class MenuScreen implements Screen{
    private PlantsAndZombies game;
    Skin skin;
    Stage stage;
    Texture MenuScreens;
    Texture active1, active2,inactive,active3,active4,active5,active6,active7, active8,active9,active10;
    TextButton tf;
    
    private TextureAtlas ta;
    private TextureRegion texture;
    private Animation an;
    private float time = 0;
     private Music music1,music2;
    public MenuScreen(PlantsAndZombies game) {
        this.game = game;
         music1=PlantsAndZombies.manager.get("sounds/IntroTheme.mp3", Music.class);
         music2=PlantsAndZombies.manager.get("sounds/Grasswalk.mp3", Music.class);
         
    }
    
    public void create ()
    {

    }

    @Override
    public void show() {



        inactive = new Texture("inactive.png");
        active1 = new Texture("active1.png");
        active2 = new Texture("active2.png");
        active3 = new Texture("active3.png");
        active4 = new Texture("active4.png");
        active5 = new Texture("active5.png");
        active6 = new Texture("active6.png");
        active7 = new Texture("active7.png");
        active8 = new Texture("active8.png");
        active9 = new Texture("active9.png");
        active10 = new Texture("active10.png");
        
    }
    @Override
    public void render(float delta) {
       Gdx.gl.glClearColor(0,0,0,0);
       Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
      music1.setLooping(true);
      music2.setLooping(true);
       music1.play();
    
 game.batch.begin();
 /*time += Gdx.graphics.getDeltaTime();
 game.batch.draw((TextureRegion) an.getKeyFrame(time, true),300,100); */
         
 
        if(Gdx.input.getX() > 505 && Gdx.input.getX() < PlantsAndZombies.width/2+407 && PlantsAndZombies.height - Gdx.input.getY() < 670 && PlantsAndZombies.height - Gdx.input.getY() > 530)   
        {
           game.batch.draw(active1, 0, 0,PlantsAndZombies.width, PlantsAndZombies.height);
          if(Gdx.input.isTouched()){
              music1.stop();
              music2.play();
            game.setScreen(new Level1(game));
          }
        }
        
      else if(Gdx.input.getX() > 502 && Gdx.input.getX() < PlantsAndZombies.width/2+398 && PlantsAndZombies.height - Gdx.input.getY() < 570 && PlantsAndZombies.height - Gdx.input.getY() > 410)           
             game.batch.draw(active2, 0, 0,PlantsAndZombies.width, PlantsAndZombies.height);
       
      else if(Gdx.input.getX() > 515 && Gdx.input.getX() < PlantsAndZombies.width/2+368 && PlantsAndZombies.height - Gdx.input.getY() < 435 && PlantsAndZombies.height - Gdx.input.getY() > 310)           
             game.batch.draw(active3, 0, 0,PlantsAndZombies.width, PlantsAndZombies.height);
        
      else if(Gdx.input.getX() > 515 && Gdx.input.getX() < PlantsAndZombies.width/2+350 && PlantsAndZombies.height - Gdx.input.getY() < 335 && PlantsAndZombies.height - Gdx.input.getY() > 230)           
             game.batch.draw(active4, 0, 0,PlantsAndZombies.width, PlantsAndZombies.height);
        
      else if(Gdx.input.getX() > 708 && Gdx.input.getX() < PlantsAndZombies.width/2+308 && PlantsAndZombies.height - Gdx.input.getY() < 140 && PlantsAndZombies.height - Gdx.input.getY() > 105)           
             game.batch.draw(active5, 0, 0,PlantsAndZombies.width, PlantsAndZombies.height);
      
      else if(Gdx.input.getX() > 812 && Gdx.input.getX() < PlantsAndZombies.width/2+365 && PlantsAndZombies.height - Gdx.input.getY() < 85 && PlantsAndZombies.height - Gdx.input.getY() > 64)    {       
             game.batch.draw(active6, 0, 0,PlantsAndZombies.width, PlantsAndZombies.height);
        if(Gdx.input.isTouched())
            game.setScreen(new homepage(game));}
      else if(Gdx.input.getX() > 902 && Gdx.input.getX() < PlantsAndZombies.width/2+456 && PlantsAndZombies.height - Gdx.input.getY() < 104 && PlantsAndZombies.height - Gdx.input.getY() > 74)  
      {
             game.batch.draw(active7, 0, 0,PlantsAndZombies.width, PlantsAndZombies.height);
             if(Gdx.input.isTouched())
             Gdx.app.exit();;
      }  
      
      else if(Gdx.input.getX() > 70 && Gdx.input.getX() < 360 && PlantsAndZombies.height - Gdx.input.getY() < 570 && PlantsAndZombies.height - Gdx.input.getY() > 550)           
             game.batch.draw(active8, 0, 0,PlantsAndZombies.width, PlantsAndZombies.height);
      
      else if(Gdx.input.getX() > 20 && Gdx.input.getX() < 192 && PlantsAndZombies.height - Gdx.input.getY() < 240 && PlantsAndZombies.height - Gdx.input.getY() > 45)           
             game.batch.draw(active9, 0, 0,PlantsAndZombies.width, PlantsAndZombies.height);
      
      else if(Gdx.input.getX() > 250 && Gdx.input.getX() < 360 && PlantsAndZombies.height - Gdx.input.getY() < 510 && PlantsAndZombies.height - Gdx.input.getY() > 468)       
      {
             game.batch.draw(active10, 0, 0,PlantsAndZombies.width, PlantsAndZombies.height);            
      }     
        else
          game.batch.draw(inactive, 0, 0,PlantsAndZombies.width, PlantsAndZombies.height);
        
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
        ta.dispose();
    }
}
