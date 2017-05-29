package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.states.GameStateManager;
import com.mygdx.game.states.MainMenu;

public class GeomGame extends Game {
	public SpriteBatch batch;
	private GameStateManager gsm;

	@Override
	public void create () {
        Gdx.gl.glClearColor(128/255f, 222/255f, 234/255f, 1);
		batch = new SpriteBatch();
		gsm = new GameStateManager();
		gsm.push(new MainMenu(gsm));
	}

	@Override
	public void render () {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        gsm.update(Gdx.graphics.getDeltaTime());
		gsm.render(batch);
    }

    @Override
	public void dispose(){
		batch.dispose();
	}
}
