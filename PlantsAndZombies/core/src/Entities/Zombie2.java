
package Entities;

import Tools.Collision;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

//inheritance
public class Zombie2 extends Zombies
{
   private TextureAtlas TA;
   private Animation animation;
   Collision rect1, rect2;
   final int width, height;
   
    public Zombie2(float max, float min)
   {
       super(max, min);
       TA = new TextureAtlas(Gdx.files.internal("Zombie2.atlas"));
       animation = new Animation(1f/20f,TA.getRegions());
       rect1 = new Collision(x, y-75, 140, 70);
       rect2 = new Collision(x, (y-75+140)/2, 140, 200);
       width = 140;
       height = 270; }
    
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
       batch.draw((TextureRegion) animation.getKeyFrame(stateTime, true), x, y-75, 140, 240);
        batch.end();  
    }
        public Collision getCollisionRect1()
        {
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
