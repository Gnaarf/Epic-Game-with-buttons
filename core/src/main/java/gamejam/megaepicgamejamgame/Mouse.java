package gamejam.megaepicgamejamgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;

public class Mouse {
    public static Vector2 GetPosition(){
        Vector2 position = new Vector2(Gdx.input.getX(), Gdx.input.getY());

        return new Vector2(Gdx.input.getX(), Gdx.graphics.getHeight() - Gdx.input.getY());
    }

    public static boolean IsLeftPressed(){
        return Gdx.input.isButtonPressed(Input.Buttons.LEFT);
    }

    public static boolean IsRightPressed(){
        return Gdx.input.isButtonPressed(Input.Buttons.RIGHT);
    }
}
