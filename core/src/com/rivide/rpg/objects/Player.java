package com.rivide.rpg.objects;

import com.badlogic.gdx.graphics.Texture;

public class Player extends GameObject {

    public Player(float x, float y) {
        super(x, y, new Texture("player.png"));
    }
}
