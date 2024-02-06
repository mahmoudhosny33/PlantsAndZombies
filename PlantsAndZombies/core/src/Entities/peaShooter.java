

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.PlantsAndZombies;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author MangestOoo
 */
//inheritance 
public class peaShooter extends Plants{
    
   private TextureAtlas TA;
   private Animation animation;
   public ArrayList<Bullet> bullets;
   float bulletTimer;
   Random random;
    public peaShooter(int positionX, int positionY) {
        
        super(positionX, positionY);
        random = new Random();
        bullets=new ArrayList<Bullet>();
        
        bulletTimer = random.nextFloat()*(5f - 3f) + 3f;
       
        TA = new TextureAtlas(Gdx.files.internal("pong.pack"));
        animation = new Animation(1f/20f,TA.getRegions());
    }

     public void render(SpriteBatch batch) 
    {
       bulletTimer -= Gdx.graphics.getDeltaTime();
       if(bulletTimer <= 0)
       {
           if(bullets.isEmpty())
           {
            bulletTimer = random.nextFloat()*(5f - 3f) + 3f;
            bullets.add(new Bullet(positionX+18, positionY+60));
           }
       }
       
        ArrayList<Bullet> bulletToRemove=new ArrayList<Bullet>();
           for(Bullet bullet : bullets)
       {
           bullet.update();
           if(bullet.remove)
           {
            bulletToRemove.add(bullet); 
           } 
       }  
           bullets.removeAll(bulletToRemove);
           for(Bullet bullet : bullets)
       {    
           bullet.render(batch);    
       }
       stateTime += Gdx.graphics.getDeltaTime();
       batch.begin();
       batch.draw((TextureRegion) animation.getKeyFrame(stateTime, true), positionX, positionY, 60, 100);
       batch.end();       
    }  

    public ArrayList<Bullet> getBullets() 
    {
        return bullets;
    }
     
     
     
}
