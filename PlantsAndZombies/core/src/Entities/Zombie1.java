/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import Tools.Collision;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 *
 * @author Family
 */
//inheritance 
public class Zombie1 extends Zombies
{
   private TextureAtlas TA;
   private Animation animation;
   Collision rect1 , rect2;
   final int width, height;
   public Zombie1(float max, float min)
   {
       super(max, min);
       TA = new TextureAtlas(Gdx.files.internal("Zombie3.atlas"));
       animation = new Animation(1.1f/20f,TA.getRegions());
       rect1 = new Collision(x, y, 80, 35);
       rect2 = new Collision(x, (y+80)/2, 80, 130);
       width = 80;
       height = 130;
   }

    public void update()
    {
       x-= (int) (speed)*Gdx.graphics.getDeltaTime();    
       if(x == 0)
           remove = true;
       
       if(health==0)
           remove = true;
       
       rect1.move(x, y);
       rect2.move(x, y);
    }
    
    @Override
    public void render(SpriteBatch batch) 
    {
       stateTime += Gdx.graphics.getDeltaTime();
       batch.begin();
       batch.draw((TextureRegion) animation.getKeyFrame(stateTime, true), x, y, width, height);
    // batch.draw((TextureRegion) animation.getKeyFrame(stateTime, true), x, y, 70, 120);
        batch.end();  
    }
    
    public Collision getCollisionRect1 () {
		return rect1;
	}
    
            public Collision getCollisionRect2()
        {
            return rect2;
        }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }



    
}
