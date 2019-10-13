package com.rivide.rpg.states;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class State {

    public abstract void update(float dt);
    public abstract void render(SpriteBatch sb);
}
