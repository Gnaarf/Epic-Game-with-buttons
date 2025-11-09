package gamejam.megaepicgamejamgame.levels;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.ScreenUtils;
import gamejam.megaepicgamejamgame.*;

import java.util.Random;

public class LevelZoomButton extends LevelScreen {

    Button button;
    float currentZoomLevel;
    String keyString;
    int key;

    public LevelZoomButton(final ButtonGame game) {
        super(game);

        this.keyString = InputHelper.generateRandomKeyString();

        this.key = Input.Keys.valueOf(this.keyString);

        button = new Button(50, 50, this.keyString);
        currentZoomLevel = 0.1f;
        button.setScale(currentZoomLevel);
    }

    private void setButtonToZoomLevel(float zoomLevel) {
        button.setScale(0.1f);
        button.currentFont = AssetLibrary.generateFont(false, (int) (50 * currentZoomLevel));
    }

    @Override
    public void render(float v) {
        super.render(v);
        ScreenUtils.clear(Color.BLACK);

        game.batch.begin();

        game.font.draw(game.batch, "Press the Button", 100, 300f);
        game.batch.draw(AssetLibrary.getInstance().zoom_icon, 430, 135, 80, 80);
        game.boldFont.draw(game.batch,  "+", 450, 200f);
        button.Render(game.batch);

        game.batch.end();

        if (Gdx.input.isKeyJustPressed(this.key)) {
            button.up = false;
            initSuccess();
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.NUMPAD_ADD) || Gdx.input.isKeyJustPressed(Input.Keys.PLUS)) {
            Gdx.app.log("TEST", "Should start zooming");
            currentZoomLevel += 0.1f;
            button.setScale(currentZoomLevel);
        }
        else if (Gdx.input.isKeyJustPressed(Input.Keys.ANY_KEY)) {
            initFail(new LevelSimpleButton(game));
        } else if (!Gdx.input.isKeyPressed(this.key)) {
            button.up = true;
        }


    }
}
