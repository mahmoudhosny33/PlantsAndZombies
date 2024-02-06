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

/**
 *
 * @author Family
 */
public class DeadZombie {
    public static final int offset = 8; 
    float x, y;
    int width, height;
    boolean remove;
    protected float stateTime;
    private TextureAtlas TA;
    private Animation animation;
    
    public DeadZombie (float x, float y, int width, int height)
    {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        remove = true;
        stateTime = 0;
        TA = new TextureAtlas(Gdx.files.internal("deadZombie.pack"));
        animation = new Animation(3f/20f,TA.getRegions());
    }
    
    public boolean isRemove() {
        return remove;
    }
    
    public void update()
    {
       stateTime =+ Gdx.graphics.getDeltaTime();
       if(animation.isAnimationFinished(stateTime))
           remove = true;
    }

    public void render(SpriteBatch batch) 
    {        
       stateTime += Gdx.graphics.getDeltaTime();
       batch.begin();
       batch.draw((TextureRegion) animation.getKeyFrame(stateTime, true), x, y, width, height);
       batch.end();  
    }
}
