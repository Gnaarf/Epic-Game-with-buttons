package gamejam.megaepicgamejamgame;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.ScreenUtils;
import gamejam.megaepicgamejamgame.levels.LevelSimpleButton;

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
        ScreenUtils.clear(Color.GREEN);

        game.batch.begin();

        game.font.draw(game.batch, "Start Screen \nPress the Button \nA", 50, 400f);

        Gdx.app.log("TEST", "Should show stuff");

        game.batch.end();

        if (Gdx.input.isKeyJustPressed(Input.Keys.A)) {
            game.setScreen(new LevelSimpleButton(game));
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
