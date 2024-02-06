
package Entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Family
 */
public class sunFlower extends Plants {
    
   private TextureAtlas TA;
   private Animation animation;
   public ArrayList<Sun> suns;
   float sunTimer;
   Random random;
   
   public sunFlower(int positionX, int positionY)
   {
       super(positionX, positionY);
       random = new Random();
       suns = new ArrayList<Sun>();
       sunTimer = random.nextFloat()*(12f - 8f) + 8f;
       TA = new TextureAtlas(Gdx.files.internal("sunflower.pack"));
       animation = new Animation(1f/20f,TA.getRegions());
   }
   
    public void render(SpriteBatch batch) 
    {
       sunTimer -= Gdx.graphics.getDeltaTime();
       if(sunTimer <= 0)
       {
           if(suns.isEmpty())
           {
            sunTimer = random.nextFloat()*(12f - 8f) + 8f;
            suns.add(new Sun(positionX-30, positionY-20));
           }
       }

       stateTime += Gdx.graphics.getDeltaTime();
       batch.begin();
       batch.draw((TextureRegion) animation.getKeyFrame(stateTime, true), positionX, positionY, 60, 100);
       batch.end(); 
    }

    public ArrayList<Sun> getSuns() 
    {
        return suns;
    }
    
    
    
}
