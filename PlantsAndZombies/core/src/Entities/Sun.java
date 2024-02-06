
package Entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.game.PlantsAndZombies;
import java.util.Random;

public class Sun 
{
   private int x, y, width, height;
   private boolean removeWithTouch, remove;
   private float speed;
   private Texture img;
   int time;
   Random random;
   private Music music;
   public Sun()
   {
       img = new Texture("sun.png");
       removeWithTouch = false;
       remove = false;
       music=PlantsAndZombies.manager.get("sounds/Points.ogg", Music.class);
        random = new Random();
        x = random.nextInt((Gdx.graphics.getWidth()-200 - 100) + 1) + 100;
        y = PlantsAndZombies.height;
        speed = (float) random.nextInt((int) ((60-50)+1))+50;
        width = 80;
        height = 80;
        time = 700;
   }

    Sun(int x, int y) 
    {
       img = new Texture("sun.png");
       removeWithTouch = false;
       remove = false;
       
        this.x = x;
        this.y = y;
        speed = 50;
        width = 80;
        height = 80;
        time = 1000;
    }
   
     public void update(int stayPlace)
    { 
       y -= (int) (speed)*Gdx.graphics.getDeltaTime();
       if(y <= stayPlace)
       {
           y = stayPlace;
           time -= (int) time*Gdx.graphics.getDeltaTime();
           if(time == 0)
           {
               remove = true;
           }
       }

       
      if(Gdx.input.getX()>x&&Gdx.input.getX()<x+width&&PlantsAndZombies.height - Gdx.input.getY() < y + height && PlantsAndZombies.height - Gdx.input.getY() > y)
       
        if(Gdx.input.justTouched())  {    
                removeWithTouch = true;
                music.play();
                
        }
    }
            
       public void updateRemove()
       {
           
           time -= (int) time*Gdx.graphics.getDeltaTime();
           if(time == 0)
           {
               remove = true;
           }
           
         if(Gdx.input.getX()>x&&Gdx.input.getX()<x+width&&PlantsAndZombies.height - Gdx.input.getY() < y + height && PlantsAndZombies.height - Gdx.input.getY() > y)
        if(Gdx.input.justTouched())     { 
            // music.play();
                removeWithTouch = true; 
               
        }
       }
       
    public void render(SpriteBatch batch)
    {
       batch.begin();
       batch.draw(img, x, y, width, height); 
       batch.end();
    }

    public boolean isRemovedWithTouch() {
        
        return removeWithTouch;
    }
    public boolean isRemoved() {
        return remove;
    }
   
}
