package gamejam.megaepicgamejamgame.levels;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;
import gamejam.megaepicgamejamgame.*;

public class LevelOpenLid extends LevelScreen {

    Button button;
    float time;
    boolean buttonIsLidded;
    float lidOpenTime;
    Sprite lidSprite;
    Sprite lidTransparentSprite;

    public LevelOpenLid(final ButtonGame game) {
        super(game);
        this.button = new Button(300, 150);
        this.time = 0f;
        this.buttonIsLidded = true;
        this.lidOpenTime = 0f;

        Rectangle lidStartRect = new Rectangle(250,100, 200, 200);
        Vector2 lidOrigin = new Vector2(20, 20);
        lidSprite = new Sprite(AssetLibrary.getInstance().safety_lid);
        lidSprite.setBounds(lidStartRect.x, lidStartRect.y, lidStartRect.width, lidStartRect.height);
        lidSprite.setOrigin(lidOrigin.x, lidOrigin.y);
        lidTransparentSprite = new Sprite(AssetLibrary.getInstance().safety_lid_transparent);
        lidTransparentSprite.setBounds(lidStartRect.x, lidStartRect.y, lidStartRect.width, lidStartRect.height);
        lidTransparentSprite.setOrigin(lidOrigin.x, lidOrigin.y);
    }

    @Override
    public void render(float v) {
        super.render(v);
        ScreenUtils.clear(Color.BLACK);

        time += Gdx.graphics.getDeltaTime();

        if(!buttonIsLidded && lidSprite.getRotation()<60){
            float rotationSpeed = 150f;
            lidSprite.rotate(rotationSpeed * Gdx.graphics.getDeltaTime());
            lidTransparentSprite.rotate(rotationSpeed * Gdx.graphics.getDeltaTime());
        }

        Rectangle safetyLidLeverRect = new Rectangle(394,140, 46, 50);


        game.batch.begin();

        lidSprite.draw(game.batch);
        button.Render(game.batch);
        lidTransparentSprite.draw(game.batch);

        game.font.draw(game.batch, buttonIsLidded ? "Open the Lid" : "Press the Button", 150, 350f);

        game.batch.end();

        if (buttonIsLidded && Gdx.input.isButtonJustPressed(Input.Buttons.LEFT) && safetyLidLeverRect.contains(Mouse.GetPosition())) {
            lidOpenTime = time;
            buttonIsLidded = false;
        }
        else if (!buttonIsLidded && Gdx.input.isButtonJustPressed(Input.Buttons.LEFT) && button.IsMouseOver()) {
            button.up = false;
            initSuccess();
        }
        else if (Gdx.input.isKeyJustPressed(Input.Keys.ANY_KEY) || Gdx.input.isButtonJustPressed(Input.Buttons.LEFT) || Gdx.input.isButtonJustPressed(Input.Buttons.RIGHT)) {
            initFail(new LevelOpenLid(game));
        }

    }
}
