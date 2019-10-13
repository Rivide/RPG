package com.rivide.rpg.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Touchpad;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.rivide.rpg.Game;
import com.rivide.rpg.objects.Player;
import com.rivide.rpg.utils.Renderer;
import com.rivide.rpg.utils.Tile;
import com.rivide.rpg.utils.Tilemap;

public class PlayState extends State {

    private OrthographicCamera cam;
    private Player player;
    private Tilemap tilemap;
    private Renderer renderer;
    private Stage stage;
    private Touchpad touchpad;

    public PlayState() {
        cam = new OrthographicCamera();
        cam.setToOrtho(false, Game.WIDTH, Game.HEIGHT);
        player = new Player(0, 0);
        tilemap = new Tilemap(3, 2, new Tile[]{
                Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS, Tile.GRASS
        }, 1, 0);
        renderer = new Renderer(cam);

        touchpad = new Touchpad(20,
                new Skin(Gdx.files.internal("data/uiskin.json")));
        touchpad.setBounds(15, 15, 100, 100);
        stage = new Stage();
        stage.addActor(touchpad);
    }

    @Override
    public void update(float dt) {
        cam.position.set(player.getPosition());
        cam.update();
        stage.act();
        if (touchpad.isTouched()) {
            System.out.println("Touch");

        }
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);
        sb.begin();
        renderer.renderTilemap(sb, tilemap);
        renderer.render(sb, player);
        sb.end();

        sb.setProjectionMatrix(stage.getCamera().combined);
        stage.draw();

    }
}
