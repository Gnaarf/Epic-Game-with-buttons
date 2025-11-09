package gamejam.megaepicgamejamgame.levels;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.ScreenUtils;
import gamejam.megaepicgamejamgame.*;

public class LevelUnpressTheButton extends LevelScreen {

    Button button;
    LevelState state;

    enum LevelState {
        START,
        LEFT_MOUSE_DOWN,
        RELEASE_AND_WIN,
    }

    public LevelUnpressTheButton(final ButtonGame game) {
        super(game);
        this.button = new Button(300, 150);
        this.button.up = false;
        this.state = LevelState.START;
    }

    @Override
    public void render(float v) {
        super.render(v);
        ScreenUtils.clear(Color.BLACK);

        switch(state) {
            case START:
                if(Gdx.input.isKeyJustPressed(Input.Keys.LEFT) && !button.IsMouseOver()) {
                    state = LevelState.LEFT_MOUSE_DOWN;
                }
                else if (InputHelper.anythingWasClickedOrPressed()){
                    initFail(new LevelUnpressTheButton(game));
                }
                break;
            case  LEFT_MOUSE_DOWN:
                if(button.IsMouseOver() && !Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
                    state = LevelState.RELEASE_AND_WIN;
                    initSuccess();
                }
                else if (InputHelper.anythingWasClickedOrPressed() || !Gdx.input.isKeyPressed(Input.Keys.LEFT)){
                    initFail(new LevelUnpressTheButton(game));
                }
                break;

            default:
                break;
        }

        game.batch.begin();

        button.Render(game.batch);

        game.font.draw(game.batch, "Unpress the button", 100, 400f);

        game.batch.end();
    }
}
