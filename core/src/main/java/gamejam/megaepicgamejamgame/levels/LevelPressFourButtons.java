package gamejam.megaepicgamejamgame.levels;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;
import gamejam.megaepicgamejamgame.*;

public class LevelPressFourButtons extends LevelScreen {

    Button button;
    boolean isButtonPressed;
    int buttonPressCounter;
    String message;
    boolean failStatePossible = true;


    public LevelPressFourButtons(final ButtonGame game) {
        super(game);
        button = new Button(new Vector2(50,50));
        isButtonPressed = false;
        buttonPressCounter = 0;
        message = "Press the Button";
    }

    @Override
    public void render(float v) {
        super.render(v);
        ScreenUtils.clear(Color.BLACK);

        boolean isButtonPressedPrevious = isButtonPressed;
        isButtonPressed = (button.IsMouseOver() && Mouse.IsLeftPressed());
        button.up = !isButtonPressed;

        game.batch.begin();

        button.Render(game.batch);

        game.font.draw(game.batch, message, 100, 300f);

        game.batch.end();

        if(!isButtonPressedPrevious && isButtonPressed){
            buttonPressCounter++;
            //failStatePossible = false;
            switch (buttonPressCounter) {
                case 1:
                    message = "Press the Button \nagain";
                    break;
                case 2:
                    message = "Press the Button \nagain again";
                    button.position.add(400, 230);
                    break;
                case 3:
                    message = "Press the Button \nagain again again";
                    button.position.add(-350, 120);
                    break;
                case 4:
                    initSuccess(); //todo go to next level
                    break;
                default:
                    break;
            }
        }
        else if (Gdx.input.isKeyJustPressed(Input.Keys.ANY_KEY) || Gdx.input.isButtonJustPressed(Input.Buttons.LEFT) || Gdx.input.isButtonJustPressed(Input.Buttons.RIGHT)) {
            initFail(new LevelPressFourButtons(game));
        }
    }
}
