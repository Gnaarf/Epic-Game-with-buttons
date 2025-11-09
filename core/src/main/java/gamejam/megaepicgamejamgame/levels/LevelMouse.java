package gamejam.megaepicgamejamgame.levels;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;
import gamejam.megaepicgamejamgame.*;

import java.util.Random;

public class LevelMouse extends LevelScreen {

    String message;

    Sprite mouseSprite;
    boolean wasAlreadyOver;

    public LevelMouse(final ButtonGame game) {
        super(game);
        message = "Click the Mouse!";
    }

    @Override
    public void show() {
        super.show();


        Random rand = new Random();
        mouseSprite = new Sprite(AssetLibrary.getInstance().mouse);
        Vector2 randomPosition = new Vector2(rand.nextFloat(120, 420), rand.nextFloat(30, 200));
        mouseSprite.setBounds(randomPosition.x, randomPosition.y, 100, 110);
        mouseSprite.setOrigin(0, 0);
        mouseSprite.flip(rand.nextBoolean(), false);
    }

    @Override
    public void render(float v) {
        super.render(v);
        ScreenUtils.clear(Color.BLACK);

        game.batch.begin();

        mouseSprite.draw(game.batch);
        game.font.draw(game.batch, message, 150, 350f);

        game.batch.end();

        Vector2 mouseCenter = new Vector2(mouseSprite.getX() + mouseSprite.getHeight() / 2, mouseSprite.getY() + mouseSprite.getHeight() / 2);
        boolean mouseIsOverMouse = (Mouse.GetPosition().dst(mouseCenter) < 50);
        if (mouseIsOverMouse) {
            message = "Don't click the Mouse!";
            if (!wasAlreadyOver) {
                wasAlreadyOver = true;
                AssetLibrary.getInstance().mousePeep.play();
            }
        }
        else {
            message = "Click the Mouse!";
            wasAlreadyOver = false;
        }

        if (!mouseIsOverMouse && Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)) {
            initSuccess(new LevelMouse(game));
        }
        else if (InputHelper.anythingWasClickedOrPressed()) {
            initFail(new LevelMouse(game));
        }
    }
}
