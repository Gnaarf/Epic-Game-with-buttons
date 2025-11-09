package gamejam.megaepicgamejamgame.levels;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;
import gamejam.megaepicgamejamgame.*;

public class LevelMoveFinger extends LevelScreen {

    Button button;
    float buttonStartY;
    float progress = 0f;

    boolean hasSwooshed = false;

    public LevelMoveFinger(final ButtonGame game) {
        super(game);
        buttonStartY = 80;
        button = new Button(new Vector2(225, buttonStartY));
    }

    @Override
    public void render(float v) {

        super.render(v);
        ScreenUtils.clear(Color.BLACK);

        game.batch.begin();
        button.position.y = Math.min(button.position.y, buttonStartY - Math.min(Math.max(0f, (progress - 0.6f)), 0.02f) * 5100f); // magic numbers. don't touch.
        button.up = progress < 0.98f;
        button.Render(game.batch);

        if (!hasSwooshed && progress > 0.6f) {
            hasSwooshed = true;
            AssetLibrary.getInstance().swooshSound.play();
        }

        Texture fingerTexture = AssetLibrary.getInstance().pointing_index_finger;
        float width = 130f;
        game.batch.draw(fingerTexture, 200, 400 - 380f * progress, width, fingerTexture.getHeight() * width /fingerTexture.getWidth() );
        game.font.setColor(Color.WHITE);
        game.font.draw(game.batch, "D", 320f, 470 - 380f * progress);


        game.batch.end();

        float progressStep = 0.1f * Gdx.graphics.getDeltaTime();
        if(!Gdx.input.isKeyPressed(Input.Keys.ANY_KEY)){
            progress -= progressStep * 25f;
            progress = Math.max(progress, 0f);
        }
        else if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            progress += progressStep;
            if(progress >= 1f){
                initSuccess();
            }
        }
        else if (Gdx.input.isKeyJustPressed(Input.Keys.ANY_KEY)) {
            initFail(new LevelMoveFinger(game));
        }
    }
}
