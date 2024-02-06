/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import Tools.Collision;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.Random;

/**
 *
 * @author Family
 */
public class Tractor 
{
    float x,y;
    private boolean remove, move;
    private Texture img;
    float speed;
    Collision rect;
    
    public Tractor(int x, int y)
    {
        this.x = x;
        this. y = y;
        remove = false;
        move = false;
        img = new Texture("lawnmowerIdle.png");
        speed = 400;
        this.rect = new Collision(x, y, 120, 120);
    }
        public void update()
    {
           
          x += (int) (speed)* Gdx.graphics.getDeltaTime();
           
           
           if(x == Gdx.graphics.getWidth())
           remove = true;   
           
           rect.move(x, y);
    }
    
        public void render(SpriteBatch batch)
    {
       batch.begin();
       batch.draw(img, x, y, 120, 120); 
       batch.end();
    }
        
     public Collision getCollisionRect () {
		return rect;
	}
        
     public boolean isRemove() 
     {
        return remove;
     }
     
     public boolean isMove() 
     {
        return move;
     }

    public void setMove(boolean move) 
    {
        this.move = move;
    }
     
     
}

