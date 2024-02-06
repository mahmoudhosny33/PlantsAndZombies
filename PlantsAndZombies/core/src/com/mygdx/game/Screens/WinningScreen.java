
package com.mygdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.PlantsAndZombies;

/**
 *
 * @author Family
 */
public class WinningScreen implements Screen {
    Texture win, next;
    PlantsAndZombies game;
    public WinningScreen(PlantsAndZombies game)
    {
    win = new Texture ("win.png");
    next = new Texture ("next.png");
    this.game = game;
    }
@Override
    public void show() {
       
    }

    @Override
    public void render(float delta) {
    game.batch.begin();
    game.batch.draw(win, 0, 0,PlantsAndZombies.width,PlantsAndZombies.height);
 
     game.batch.draw(next, 0, 100);

    game.batch.end();
    
    if(Gdx.input.justTouched()){
           game.setScreen(new Level2(game));
    }
    }

    @Override
    public void resize(int width, int height) {
      
    }

    @Override
    public void pause() {
        
    }

    @Override
    public void resume() {
       
    }

    @Override
    public void hide() {
       
    }

    @Override
    public void dispose() {
       
    }
}
