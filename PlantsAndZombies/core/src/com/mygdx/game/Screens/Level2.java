/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game.Screens;

import Entities.Bullet;
import Entities.DeadZombie;
import Entities.Plants;
import Entities.Sun;
import Entities.Tractor;
import Entities.Zombie1;
import Entities.Zombie2;
import Entities.Zombies;
import Entities.peaShooter;
import Entities.sunFlower;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.game.PlantsAndZombies;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Family
 */
public class Level2 implements Screen 
{
    public static final float MIN_SUN_TIME = 10f;
    public static final float MAX_SUN_TIME = 12f;
    public static final float Ship_width = 50;
    public static final float Ship_height = 90;
     private  float elapsed,wave,waveNum;
    
    ArrayList<Zombies> zombies1;
    ArrayList<Sun> suns;
    ArrayList<Tractor> tractors;
    ArrayList<Plants> plants;
    ArrayList<DeadZombie> deadZombies;
     
    PlantsAndZombies game;
    float sunTimer;
    Texture background;
    Texture activeSunflower, notActiveSunflower, activePlant, notActivePlant;
    Texture lost, win;

    Random random;
    float x,y;
    boolean chooseSun, choosePea;
    BitmapFont scoreFont;
    int score;
    int arr[];
    private Music music1,music2,music3,music4,music5;
    public Level2(PlantsAndZombies game)
    {
        random = new Random();
        sunTimer = random.nextFloat()*(MAX_SUN_TIME - MIN_SUN_TIME) + MIN_SUN_TIME;
        chooseSun = false;
        choosePea = false;
      arr=new int[5];
        arr[0]=80;
        arr[1]=205;
        arr[2]=310;
        arr[3]=445;
        arr[4]=550;
        elapsed=0;
        wave=1;
        waveNum=2;
        music1=PlantsAndZombies.manager.get("sounds/plant1.ogg", Music.class);
         music2=PlantsAndZombies.manager.get("sounds/lawnmower.wav", Music.class);
         music3=PlantsAndZombies.manager.get("sounds/chomp.wav", Music.class);
         music4=PlantsAndZombies.manager.get("sounds/Points.ogg", Music.class);
         music5=PlantsAndZombies.manager.get("sounds/zombies_are_coming.wav", Music.class);
        suns = new ArrayList<Sun> ();
        zombies1 = new ArrayList<Zombies> ();
        tractors = new ArrayList<Tractor> ();
        deadZombies = new ArrayList<DeadZombie>();
        this.game = game;
         plants=new ArrayList<Plants>();
        activeSunflower = new Texture("sunfloweractive.png");
        notActiveSunflower = new Texture("sunflowernot.png");
        activePlant = new Texture("plantactive.png");
        notActivePlant = new Texture("plantnot.png");
        lost = new Texture ("lost.png");
         win = new Texture("LevelWin.png");
                
        tractors.add(new Tractor(-20, 155));
        tractors.add(new Tractor(-20, 272));
        tractors.add(new Tractor(-20, 405));
        tractors.add(new Tractor(-20, 30));
        tractors.add(new Tractor(-20, 520));
        
        zombies1.add(new Zombie1(85,80));
//        zombies1.add(new Zombie1(85,80));
//        zombies1.add(new Zombie2(210,205));
//        zombies1.add(new Zombie2(210,205));
//        zombies1.add(new Zombie1(305,310));
//        zombies1.add(new Zombie1(305,310));
//        zombies1.add(new Zombie1(450,445));
//        zombies1.add(new Zombie2(210,205));
//        zombies1.add(new Zombie1(560,550));
        //plants.add(new peaShooter(50,200,200));
        scoreFont = new BitmapFont(Gdx.files.internal("score.fnt"));
        score = 50;
    }

    @Override
    public void show() {
        background = new Texture("bg2.png");
    }

    @Override
    public void render(float delta) 
    {
       Gdx.gl.glClearColor(0,0,0,0);
       Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
       
       game.batch.begin();
        elapsed+=delta;
       if(wave<=5){
       if(elapsed>=wave*20){
           wave++;
           if(wave==5){
               music5.play();
           }
           for(int i=0;i<waveNum;i++){
               int rand=new Random().nextInt(2);
               Zombies newZombie;
               if(rand==0){
                   newZombie=new Zombie1(305, arr[new Random().nextInt(5)]);
                   zombies1.add(newZombie);
               }
               else if(rand==1){
                   newZombie=new Zombie2(305, arr[new Random().nextInt(5)]);
                   zombies1.add(newZombie);
               }
               
           }
           waveNum+=1;
       }
       }   
//       if(Gdx.input.getX() > 33 && Gdx.input.getX() < 976 &&PlantsAndZombies.height - Gdx.input.getY() < 670 && PlantsAndZombies.height - Gdx.input.getY() >35)   
//       {
//         if(Gdx.input.isTouched())
//           game.setScreen(new Level1(game));
//       }
      
       game.batch.draw(background, 0,0,PlantsAndZombies.width,PlantsAndZombies.height); 
      
       if(score >= 50 && score < 100)
       {
        game.batch.draw(activeSunflower, 192, 650,60,90);
        game.batch.draw(notActivePlant, 120, 650,60,90);
       }
       else if(score >= 100)
       {
        game.batch.draw(activeSunflower, 192, 650,60,90);
        game.batch.draw(activePlant, 120, 650,60,90);
       }
       else
       {
        game.batch.draw(notActiveSunflower, 192, 650,60,90);
        game.batch.draw(notActivePlant, 120, 650,60,90);
       }
       
       if(Gdx.input.getX()>192 && Gdx.input.getX()<252 && PlantsAndZombies.height - Gdx.input.getY() < 740 && PlantsAndZombies.height - Gdx.input.getY() > 650 )
       if(Gdx.input.justTouched() && score >= 50)  
       {
           score-=50;
           chooseSun = true;
       }
          
        
       if(Gdx.input.getX()>120 && Gdx.input.getX()<180 && PlantsAndZombies.height - Gdx.input.getY() < 740 && PlantsAndZombies.height - Gdx.input.getY() > 650)
       if(Gdx.input.justTouched() && score >= 100)    
       {     
           score-=100; 
           choosePea = true;
           
       }
       
       GlyphLayout scoreLO = new GlyphLayout(scoreFont, ""+score); 
       
       scoreFont.draw(game.batch, scoreLO, 30, 675);
       game.batch.end();
       
       ArrayList<Zombies> removedZombie = new ArrayList<Zombies>();
       ArrayList<Sun> removedSun = new ArrayList<Sun>();
       ArrayList<Tractor> removedTractor =  new ArrayList<Tractor>();
       ArrayList<Plants> removedplant =  new ArrayList<Plants>();
       ArrayList<DeadZombie> removedDeadZombies = new ArrayList<DeadZombie>();
       
       if(choosePea)
       {
            if(Gdx.input.getX()> 110 && Gdx.input.getX()<950 && PlantsAndZombies.height - Gdx.input.getY() < 650 && PlantsAndZombies.height - Gdx.input.getY() > 50)
            {
                  if(Gdx.input.isTouched())
                  {
                   plants.add(new peaShooter(Gdx.input.getX(),PlantsAndZombies.height - Gdx.input.getY()));
                   music1.play();
                   choosePea = false;
                  }
            }
       }
       
       if(chooseSun)
       {
            if(Gdx.input.getX()> 110 && Gdx.input.getX()<950 && PlantsAndZombies.height - Gdx.input.getY() < 650 && PlantsAndZombies.height - Gdx.input.getY() > 50)
            {
                  if(Gdx.input.isTouched())
                  {
                   plants.add(new sunFlower(Gdx.input.getX(),PlantsAndZombies.height - Gdx.input.getY()));
                    music1.play();
                   chooseSun = false;
                  }
            }
       }
       
       sunTimer -= Gdx.graphics.getDeltaTime();
       if(sunTimer <= 0)
       {
           if(suns.isEmpty())
           {
            sunTimer = random.nextFloat()*(MAX_SUN_TIME - MIN_SUN_TIME) + MIN_SUN_TIME;
            suns.add(new Sun());
           }
       }
          
       for(Zombies zombie : zombies1)
       {
           zombie.update();
           if(zombie.isRemove())
           {
            removedZombie.add(zombie); 
            deadZombies.add(new DeadZombie(zombie.getX(), zombie.getY(), zombie.getWidth(), zombie.getHeight()));
           } 
       }  
       
       for(DeadZombie zombie : deadZombies)
       {
           zombie.update();
           if(zombie.isRemove())
           {
            removedDeadZombies.add(zombie); 
           } 
       }         
       deadZombies.removeAll(removedDeadZombies);
              for(Tractor tractor : tractors)
       {
           if(tractor.isMove())
           {
            tractor.update();
            if(tractor.isRemove())
            {
                removedTractor.add(tractor);
            }
           } 
       }  
              
       ArrayList<Bullet> removedBullets = new ArrayList<Bullet>();                 
                      
      for(Plants plant : plants)
      {
          if(plant instanceof peaShooter)
          {
      for (Bullet bullet : ((peaShooter)plant).getBullets())  
       {
	    for (Zombies zombie : zombies1) 
            {
		if (bullet.getCollisionRect().collidesWith(zombie.getCollisionRect2())) 
                {
		    zombie.healthUpdate();
                    removedBullets.add(bullet);
		}
	    }
        }
        ((peaShooter)plant).getBullets().removeAll(removedBullets);
          }
       }
          
       for (Plants plant : plants)  
       {
	    for (Zombies zombie : zombies1) 
            {
		if (plant.getCollisionRect().collidesWith(zombie.getCollisionRect1())) 
                {
                    music3.play();
		    plant.setDie(true);
		}
	    }
	}      
       
       for (Plants plant : plants)  
       {
           if(plant.isDie())
               plant.update();
           if(plant.isRemove())
               removedplant.add(plant);
       }
       plants.removeAll(removedplant);
       
       for (Tractor tractor : tractors)  
       {
	    for (Zombies zombie : zombies1) 
            {
		if (tractor.getCollisionRect().collidesWith(zombie.getCollisionRect1())) 
                {
		    tractor.setMove(true);
                    music2.play();
		    removedZombie.add(zombie);
                    deadZombies.add(new DeadZombie(zombie.getX(), zombie.getY(), zombie.getWidth(), zombie.getHeight()));
		}
	    }
	}
       tractors.removeAll(removedTractor);
       zombies1.removeAll(removedZombie); 
                            
       for(Sun sun : suns)
       {
           sun.update(25);
           if(sun.isRemovedWithTouch())
           {
                music4.play();
            removedSun.add(sun);
            score+=25;
           }
           
           if(sun.isRemoved())
           {
               music4.play();
                removedSun.add(sun);
           }
       }
       suns.removeAll(removedSun);              
       
        for(Plants plant : plants)
        {
          if(plant instanceof sunFlower)
          {
            for(Sun sun : ((sunFlower)plant).getSuns())
            {
               sun.updateRemove();
               if(sun.isRemovedWithTouch())
               {
                   music4.play();
                removedSun.add(sun);
                score+=25;
               }
           
               if(sun.isRemoved())
               {
                removedSun.add(sun);
               }
            }   
            ((sunFlower)plant).getSuns().removeAll(removedSun);
          }          
       }

        for(Plants p : plants)
       {
            p.render(game.batch);
       }
        
        for(DeadZombie zombie : deadZombies)
       {
           zombie.render(game.batch);
       }  
               
        for(Zombies zombie : zombies1)
       {    
           zombie.render(game.batch);    
       }
               
       for (Tractor tractor : tractors)
       {
           tractor.render(game.batch);
       }
       
        for(Sun sun : suns)
       {
           sun.render(game.batch);
        
       }
        
         for(Plants plant : plants)
        {
          if(plant instanceof sunFlower)
          {
              for(Sun sun : ((sunFlower)plant).getSuns())
              {
                  sun.render(game.batch);
              }          
          }
       }
for(Zombies zombie : zombies1)
{
 if(zombie.getX()<=0)
 {
             game.batch.begin();
             game.batch.draw(lost, 240, 150);
             game.batch.end();
             if(Gdx.input.justTouched())
             game.setScreen(new Level2(game));
    }
}
         if(zombies1.isEmpty())
         {
             game.batch.begin();
             game.batch.draw(win, 200, 70,600,600);
             game.batch.end();
             if(Gdx.input.justTouched())
             game.setScreen(new MenuScreen(game));
         }
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
