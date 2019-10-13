package com.rivide.rpg.utils;

import com.badlogic.gdx.math.Vector2;

import java.util.List;

public class Tilemap {

    private int cols;
    private int rows;
    private int tileSize;

    private Tile[] tileMatrix;
    private int originX;
    private int originY;

    public Tilemap(int cols, int rows, Tile[] tileMatrix, int originX, int originY) {
        this.cols = cols;
        this.rows = rows;
        this.tileSize = 32;
        this.tileMatrix = tileMatrix;
        this.originX = originX;
        this.originY = originY;
    }
    public int getTileSize() {
        return tileSize;
    }
    public Tile getTile(int x, int y) {
        int index = (rows - 1 - (originY + y)) * (originX + x);
        if (index < 0 || index >= tileMatrix.length || x < -originX || x >= cols - originX ||
            y < -originY || y >= rows - originY) {
            return null;
        }
        return tileMatrix[(rows - 1 - (originY + y)) * (originX + x)];
    }
}
