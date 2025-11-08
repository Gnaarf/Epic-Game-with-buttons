package gamejam.megaepicgamejamgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.ScreenUtils;
import gamejam.megaepicgamejamgame.levels.Level01;

public class FailScreen implements Screen {

    final ButtonGame game;
    LevelScreen failedLevel;
    LevelScreen nextLevel;

    public FailScreen(final ButtonGame game, LevelScreen failedLevel, LevelScreen nextLevel) {
        this.game = game;
        this.failedLevel = failedLevel;
        this.nextLevel = nextLevel;
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float v) {
        ScreenUtils.clear(Color.RED);

        game.batch.begin();

        game.font.draw(game.batch, "You Failed!", 150, 400);
        game.font.draw(game.batch, "Press the Button to try again!", 100, 300f);
        game.font.draw(game.batch, "N", 200f, 250f);


        game.batch.end();

        if (Gdx.input.isKeyJustPressed(Input.Keys.N)) {
            game.setScreen(nextLevel);
            dispose();
        }
    }

    @Override
    public void resize(int width, int height) {

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
