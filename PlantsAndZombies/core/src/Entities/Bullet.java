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

/**
 *
 * @author MangestOoo
 */
public class Bullet {
    public static final int Speed=350;
    float x,y;
    public boolean remove=false;
    private static Texture texture;
    Collision rect;

    public Bullet(float x, float y) {
        this.x = x;
        this.y = y;
        texture=new Texture("pea.png");
        rect = new Collision(x, y, 25, 25);
    }
    public void update (){
        x+=Speed*Gdx.graphics.getDeltaTime();
        if(x>950)
            remove=true;
        
        rect.move(x, y);
    }
     public void render (SpriteBatch batch){
         batch.begin();
        batch.draw(texture, x, y,25 ,25);
        batch.end();
    }
     
        public Collision getCollisionRect()
        {
            return rect;
        }
}
