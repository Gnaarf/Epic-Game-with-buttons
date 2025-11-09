package gamejam.megaepicgamejamgame.levels;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.Timer;
import gamejam.megaepicgamejamgame.Button;
import gamejam.megaepicgamejamgame.ButtonGame;
import gamejam.megaepicgamejamgame.LevelScreen;

public class LevelSimpleButton extends LevelScreen {

    Button button;

    public LevelSimpleButton(final ButtonGame game) {
        super(game);

        button = new Button(50, 50, "A");
    }

    @Override
    public void render(float v) {
        super.render(v);
        ScreenUtils.clear(Color.BLACK);

        game.batch.begin();

        game.font.draw(game.batch, "Press the Button\nto Start the Game", 100, 300f);
        button.Render(game.batch);


        game.batch.end();

        if (Gdx.input.isKeyJustPressed(Input.Keys.A)) {
            button.up = false;
            initSuccess();
        }
        else if (!Gdx.input.isKeyPressed(Input.Keys.A)) {
            button.up = true;
        }
        else if (Gdx.input.isKeyJustPressed(Input.Keys.ANY_KEY)) {
            initFail(new LevelSimpleButton(game));
        }

    }
}
