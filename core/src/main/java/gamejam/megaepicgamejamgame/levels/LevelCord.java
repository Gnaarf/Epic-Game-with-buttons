package gamejam.megaepicgamejamgame.levels;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;
import gamejam.megaepicgamejamgame.*;

public class LevelCord extends LevelScreen {

    final ButtonGame game;
    Button button;
    float time;
    boolean buttonIsLidded;

    public LevelCord(final ButtonGame game) {
        this.game = game;
        this.button = new Button(100, 100);
        this.time = 0f;
        this.buttonIsLidded = true;
    }

    @Override
    public void render(float v) {
        super.render(v);
        ScreenUtils.clear(Color.BLACK);

        time += Gdx.graphics.getDeltaTime();

        Rectangle safetyLidRect = new Rectangle(250,100, 200, 200);
        button.position.x = safetyLidRect.x + 50;
        button.position.y = safetyLidRect.y + 50;

        Rectangle safetyLidLeverRect = new Rectangle(394,140, 46, 50);

        game.batch.begin();

        game.batch.draw(AssetLibrary.getInstance().safety_lid, safetyLidRect.x, safetyLidRect.y, safetyLidRect.width, safetyLidRect.height);
        button.Render(game.batch);
        game.batch.draw(AssetLibrary.getInstance().safety_lid_transparent, safetyLidRect.x, safetyLidRect.y, safetyLidRect.width, safetyLidRect.height);

        game.font.draw(game.batch, "test", 100, 500f);

        game.batch.end();

        if (Gdx.input.isKeyJustPressed(Input.Keys.A)) {
            game.setScreen(new Level02(game));
        }
        else if (Gdx.input.isKeyJustPressed(Input.Keys.ANY_KEY)) {
            game.setScreen(new FailScreen(game, this, new LevelCord(game)));
        }

    }
}
