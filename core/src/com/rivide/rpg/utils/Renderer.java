package com.rivide.rpg.utils;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.Map;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ArrayMap;
import com.rivide.rpg.Game;
import com.rivide.rpg.objects.GameObject;

public class Renderer {

    private OrthographicCamera cam;
    private Vector3 camOffset;
    private ArrayMap<Tile, Texture> tileTextures;

    public Renderer(OrthographicCamera cam) {
        this.cam = cam;
        camOffset = new Vector3();
        tileTextures = new ArrayMap<>();
    }
    public void render(SpriteBatch sb, GameObject gameObject) {
        camOffset.set(gameObject.getPosition())/*.sub(cam.position)*/;
        //sb.draw(gameObject.getTexture(), camOffset.x, camOffset.y, 64, 256);
        Vector3 position = gameObject.getPosition();
        Vector3 dimensions = gameObject.getDimensions();
        sb.draw(
                gameObject.getTexture(),
                position.x - dimensions.x / 2,
                position.y - dimensions.y / 2,
                0,
                0,
                32,
                64,
                1,
                1,
                0,
                0,
                0,
                32,
                64,
                false,
                false
        );
    }
    public void renderTilemap(SpriteBatch sb, Tilemap tilemap) {
        int tileSize = tilemap.getTileSize();
        for (int row = (int) Math.floor((cam.position.y - cam.viewportHeight / 2) / tileSize); row <=
            Math.floor((cam.position.y + cam.viewportHeight / 2) / tileSize); row++) {
            for (int col = (int) Math.floor((cam.position.x - cam.viewportWidth / 2) / tileSize); col <=
                    Math.floor((cam.position.x + cam.viewportWidth / 2) / tileSize); col++) {
                Tile tile = tilemap.getTile(col, row);
                if (tile != null) {
                    renderTile(sb, tile, col * tileSize, row * tileSize);
                    //System.out.println("(" + col + ", " + row + "): " + tilemap.getTile(col, row).toString());

                }
            }
        }
    }
    private void renderTile(SpriteBatch sb, Tile tile, float x, float y) {
        Texture texture = tileTextures.get(tile);
        if (texture == null) {
            texture = new Texture(tile.toString().toLowerCase() + ".png");
            tileTextures.put(tile, texture);
        }
        sb.draw(texture, x, y);
    }
    private float left() {
        return cam.position.x - Game.WIDTH / 2;
    }
}
