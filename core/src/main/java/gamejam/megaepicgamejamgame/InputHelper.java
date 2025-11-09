package gamejam.megaepicgamejamgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

public class InputHelper {
    public static boolean anythingWasClickedOrPressed() {
        return Gdx.input.isKeyJustPressed(Input.Keys.ANY_KEY)
            || Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)
            || Gdx.input.isButtonJustPressed(Input.Buttons.RIGHT)
            || Gdx.input.isButtonJustPressed(Input.Buttons.MIDDLE);
    }
}
