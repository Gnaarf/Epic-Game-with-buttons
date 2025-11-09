package gamejam.megaepicgamejamgame.levels;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;
import gamejam.megaepicgamejamgame.*;

import java.util.Random;

public class LevelConveyor extends LevelScreen {

    Button[] buttons;
    char[] buttonLabels;
    float conveyorSpeed;
    float fingerStartTime;
    float time;
    boolean fingerIsMovingUp;

    public LevelConveyor(final ButtonGame game) {
        super(game);
        int count = 5;
        conveyorSpeed = 50f;

        Random rand = new Random();
        this.buttons = new Button[count];
        char[] buttonLabels = new char[count];
        for (int i = 0; i < count; i++) {
            buttonLabels[i] = (char)((int)'A' + rand.nextInt(26));
            buttons[i] = new Button(50 - i*150, 50, "" + buttonLabels[i]);
        }
        fingerStartTime = -10f;
        fingerIsMovingUp = true;
        this.time = 0f;
    }

    @Override
    public void render(float v) {
        super.render(v);
        ScreenUtils.clear(Color.BLACK);

        time += Gdx.graphics.getDeltaTime();

        for (int i = 0; i < buttons.length; i++) {
            buttons[i].position.x += conveyorSpeed * Gdx.graphics.getDeltaTime();
        }

        if(InputHelper.anythingWasClickedOrPressed()) {
            boolean fail = true;
            AssetLibrary.getInstance().swooshSoundNoDelay.play();
            for (Button b : buttons) {
                if (300 < b.position.x && b.position.x < 400 && Gdx.input.isKeyPressed((int) (Input.Keys.A + (b.text.charAt(0) - 'A')))) {
                    fail = false;
                    b.up = false;
                }
            }
            if (fail) {
                initFail(new LevelConveyor(game));
            }
        }

        boolean hasWon = true;
        for (Button b : buttons) {
            if (b.up) {hasWon = false; break;}
        }
        if (hasWon) {initSuccess();}

        game.batch.begin();

        for (int i = 0; i < buttons.length; i++) {
            buttons[i].Render(game.batch);
        }

        //game.font.draw(game.batch, "test", 100, 500f);

        float fingerY = InputHelper.anythingWasClickedOrPressed() ? 100 : 350;
        float textureWidth = 130f;
        Texture fingerTexture = AssetLibrary.getInstance().pointing_index_finger;
        game.batch.draw(fingerTexture, 350, fingerY, textureWidth, fingerTexture.getHeight() * textureWidth / fingerTexture.getWidth());

        game.batch.end();
    }
}
