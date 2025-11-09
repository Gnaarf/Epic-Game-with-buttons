package gamejam.megaepicgamejamgame.levels;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.utils.ScreenUtils;
import gamejam.megaepicgamejamgame.*;

import java.security.Key;

public class LevelHouseEnter extends LevelScreen {

    Texture houseOpen;
    Texture houseClosed;

    Sprite person;

    WalkState state = WalkState.WALKING_RIGHT;
    float totalWalkTime = 0f;
    float maxWalkTime = 5f;

    String text;

    enum WalkState {
        WALKING_RIGHT,
        SHOULD_STOP_WALKING,
        SHOULD_RETURN,
        SHOULD_ENTER,
    }

    public LevelHouseEnter(final ButtonGame game) {
        super(game);

        houseOpen = AssetLibrary.getInstance().houseOpen;
        houseClosed = AssetLibrary.getInstance().houseClosed;
        person = new Sprite(AssetLibrary.getInstance().playMobilMan);
    }

    @Override
    public void render(float v) {
        super.render(v);
        ScreenUtils.clear(Color.BLACK);

        game.batch.begin();

        game.font.draw(game.batch, "Press the Button", 100, 300f);
        if (state != WalkState.SHOULD_ENTER) {
        }
        else {

        }
        game.batch.draw();
        game.boldFont.draw(game.batch,  "+", 450, 200f);

        game.batch.end();

        switch (state) {
            case WALKING_RIGHT:
                if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
                    totalWalkTime += v;
                    if (totalWalkTime >= maxWalkTime) {
                        state = WalkState.SHOULD_STOP_WALKING;
                        text = "Please Return!";
                    }
                } else if (InputHelper.anythingWasClickedOrPressed()) {
                    initFail(this);
                }
                break;
            case SHOULD_STOP_WALKING:
                if (!Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
                    state = WalkState.SHOULD_RETURN;
                } else if (InputHelper.anythingWasClickedOrPressed()) {
                    initFail(this);
                }
                break;
            case SHOULD_RETURN:
                if (Gdx.input.isKeyJustPressed(Input.Keys.ENTER) || Gdx.input.isKeyJustPressed(Input.Keys.NUMPAD_ENTER)) {
                    state = WalkState.SHOULD_ENTER;
                } else if (InputHelper.anythingWasClickedOrPressed()) {
                    initFail(this);
                }
                break;
            case SHOULD_ENTER:
                if (Gdx.input.isKeyJustPressed(Input.Keys.ENTER) || Gdx.input.isKeyJustPressed(Input.Keys.NUMPAD_ENTER)) {
                    initSuccess();
                } else if (InputHelper.anythingWasClickedOrPressed()) {
                    initFail(this);
                }
                break;
        }
    }
}
