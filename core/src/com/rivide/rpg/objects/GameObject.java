package com.rivide.rpg.objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Vector3;
import com.rivide.rpg.Game;
import com.rivide.rpg.utils.VecOps;

public abstract class GameObject {

    protected Vector3 position;
    protected Texture texture;
    protected Polygon bounds;
    protected Vector3 dimensions;

    public GameObject(float x, float y, Texture texture) {
        position = new Vector3(x, y, 0);
        dimensions = new Vector3(texture.getWidth(), texture.getHeight(), 0);
        this.texture = texture;
        bounds = new Polygon(new float[]{
                0, 0,
                dimensions.x, 0,
                dimensions.x, dimensions.y,
                0, dimensions.y
        });
        bounds.setPosition(x, y);
        bounds.setOrigin(dimensions.x / 2f, dimensions.y / 2f);
    }
    public Vector3 getPosition() {
        return position;
    }
    public Vector3 getDimensions() {
        return dimensions;
    }
    public Texture getTexture() {
        return texture;
    }
}
