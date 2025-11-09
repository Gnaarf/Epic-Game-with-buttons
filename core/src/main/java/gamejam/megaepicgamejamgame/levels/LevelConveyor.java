package gamejam.megaepicgamejamgame.levels;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;
import gamejam.megaepicgamejamgame.*;
import org.w3c.dom.Text;

import java.util.Random;

public class LevelConveyor extends LevelScreen {

    Button[] buttons;
    char[] buttonLabels;
    float conveyorSpeed;
    float fingerStartTime;
    float time;
    float fingerTimer;

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
        fingerTimer = 3f;
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
            fingerTimer = 0f;
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

        float conveyorTextureWidth = 1000f;
        Texture conveyorTexture = (int)(6*time % 2) == 0 ? AssetLibrary.getInstance().conveyorBelt1 : AssetLibrary.getInstance().conveyorBelt2;
        game.batch.draw(conveyorTexture, -350,-120, conveyorTextureWidth, conveyorTexture.getHeight() * conveyorTextureWidth / conveyorTexture.getWidth());

        for (int i = 0; i < buttons.length; i++) {
            buttons[i].Render(game.batch);
        }

        //game.font.draw(game.batch, "test", 100, 500f);

        fingerTimer += Gdx.graphics.getDeltaTime();
        float fingerY = fingerTimer < 0.3f ? InputHelper.Lerp(350, 100, Math.min(fingerTimer/0.15f, 1f)) : 350;
        float fingerTextureWidth = 130f;
        Texture fingerTexture = AssetLibrary.getInstance().pointing_index_finger;
        game.batch.draw(fingerTexture, 350, fingerY, fingerTextureWidth, fingerTexture.getHeight() * fingerTextureWidth / fingerTexture.getWidth());

        game.batch.end();
    }
}
