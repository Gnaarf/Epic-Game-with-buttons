package gamejam.megaepicgamejamgame.levels;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.ScreenUtils;
import gamejam.megaepicgamejamgame.ButtonGame;
import gamejam.megaepicgamejamgame.FailScreen;
import gamejam.megaepicgamejamgame.LevelScreen;

public class Level01 extends LevelScreen {

    public Level01(final ButtonGame game) {
        super(game);
    }

    @Override
    public void render(float v) {
        super.render(v);
        ScreenUtils.clear(Color.BLACK);

        game.batch.begin();

        game.font.draw(game.batch, "Press the Button to Start the Game", 100, 300f);
        game.font.draw(game.batch, "A", 250f, 200);


        game.batch.end();

        if (Gdx.input.isKeyJustPressed(Input.Keys.A)) {
            initSuccess();
        }
        else if (Gdx.input.isKeyJustPressed(Input.Keys.ANY_KEY)) {
            initFail(new Level01(game));
        }

    }
}
