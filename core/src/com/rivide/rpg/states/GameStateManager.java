package com.rivide.rpg.states;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Stack;

public class GameStateManager {
    private Stack<State> states;

    public GameStateManager() {
        states = new Stack<>();
    }
    public void pushState(State state) {
        states.push(state);
    }
    public void updateState(float dt) {
        states.peek().update(dt);
    }
    public void renderState(SpriteBatch sb) {
        states.peek().render(sb);
    }
}
