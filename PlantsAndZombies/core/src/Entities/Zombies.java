
package Entities;

import Tools.Collision;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.mygdx.game.PlantsAndZombies;
import java.util.Random;
//abstract class
public abstract class Zombies 
{
 /*private Texture img;
 private TextureRegion[] TR;*/
 

   protected float stateTime = 0;
   float x, y;
   boolean remove;
   float speed;
   int health;
    static int elapsed=0;
    static int wave=0;
    public Zombies(float max, float min)
    {
        remove = false;
        Random random = new Random();
         x = PlantsAndZombies.width+200;
        
        y = (int)(Math.random() * ((max - min) + 1)) + min;
//        if(!(y<210 && y >200) || !(y<240 && y > 230) || !(y < 475 && y > 465))
//            y = (int)(Math.random() * ((max - min) + 1)) + min;

        speed = (float) random.nextInt((int) ((18-5f)+1))+5;
        
        health = 250;
        
      /*   img = new Texture(Gdx.files.internal("spritesheet.png"));
        TR = new TextureRegion[60];
        int index = 0;
        TextureRegion[][] tmp = TextureRegion.split(img,370/10,372/6);
        for(int i =0; i <10; i++)
            for(int j =0; j < 6; j++)
            {
                TR[index++] = tmp[i][j];
            }
        animation = new Animation(stateTime, TR);*/
    }
    
    public abstract void update();
    public abstract void render(SpriteBatch batch);
    public abstract Collision getCollisionRect1();
    public abstract Collision getCollisionRect2();
    public abstract int getWidth();
    public abstract int getHeight();
           
    public boolean isRemove() {
        return remove;
    }
    
        public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }
    
    public void healthUpdate()
    {
        health-=50;
    }
    
}
