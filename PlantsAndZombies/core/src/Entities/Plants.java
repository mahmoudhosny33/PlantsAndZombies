/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import Tools.Collision;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

/**
 *
 * @author MangestOoo
 */
//abstract class
public abstract class Plants {
    private int health;
     int positionX;
      int positionY;
      boolean die;
     protected float stateTime = 0;
     boolean removed ;
     Collision rect;
     
    public Plants(int positionX, int positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
        removed=false;
        die = false;
        health = 1000;
        this.rect = new Collision(positionX, positionY, 60, 100);
    }
    
    public void update()
    { 
           health -= (int) health*Gdx.graphics.getDeltaTime();
           if(health == 0)
           {
               removed = true;
           }
           rect.move(positionX, positionY);
    }
    
    public Collision getCollisionRect () {
		return rect;
	}
         
 public boolean isRemove() {
        return removed;
    }
    
    public int getHealth() {
        return health;
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }
    public abstract void render(SpriteBatch batch);

    public boolean isDie() {
        return die;
    }

    public void setDie(boolean die) {
        this.die = die;
    }

    
    
}
