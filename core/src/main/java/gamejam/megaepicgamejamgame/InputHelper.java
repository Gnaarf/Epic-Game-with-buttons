package gamejam.megaepicgamejamgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

import java.util.Random;

public class InputHelper {
    public static boolean anythingWasClickedOrPressed() {
        return Gdx.input.isKeyJustPressed(Input.Keys.ANY_KEY)
            || Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)
            || Gdx.input.isButtonJustPressed(Input.Buttons.RIGHT)
            || Gdx.input.isButtonJustPressed(Input.Buttons.MIDDLE);
    }

    public static float Lerp(float start, float end, float t) {
        return t * (end - start) + start;
    }

    /// generates a random Key from A to Z
    /// Use Input.Keys.valueOf(keyString) to get the correct keyCode
    public static String generateRandomKeyString() {
        Random rand = new Random();
        return Character.toString((char)rand.nextInt((int)'A', (int)'Z' ));
    }
}
