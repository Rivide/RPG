package com.rivide.rpg;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.rivide.rpg.states.GameStateManager;
import com.rivide.rpg.states.PlayState;

public class Game extends ApplicationAdapter {

	public static final int WIDTH = 800;
	public static final int HEIGHT = 480;

	public static final String TITLE = "RPG";

	private SpriteBatch batch;

	private GameStateManager gsm;

	@Override
	public void create () {
		batch = new SpriteBatch();
		gsm = new GameStateManager();
		gsm.pushState(new PlayState());
	}

	@Override
	public void render () {
		gsm.updateState(Gdx.graphics.getDeltaTime());
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		gsm.renderState(batch);
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
