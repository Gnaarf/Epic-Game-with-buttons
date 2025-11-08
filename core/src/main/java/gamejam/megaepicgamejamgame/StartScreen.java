package gamejam.megaepicgamejamgame;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.ScreenUtils;
import gamejam.megaepicgamejamgame.levels.Level01;

import java.awt.*;

public class StartScreen implements Screen {

    final ButtonGame game;

    public StartScreen(final ButtonGame game) {
        this.game = game;
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float v) {
        ScreenUtils.clear(Color.CLEAR_WHITE);

        game.batch.begin();

        game.font.getData().setScale(5);

        game.font.draw(game.batch, "Press the Button to Start the Game", 50, 250f);
        game.font.draw(game.batch, "A", 200f, 120f);

        Gdx.app.log("TEST", "Should show stuff");

        game.batch.end();

        if (Gdx.input.isKeyJustPressed(Input.Keys.A)) {
            game.setScreen(new Level01(game));
            dispose();
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.ANY_KEY)) {

        }

    }

    @Override
    public void resize(int i, int i1) {

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
