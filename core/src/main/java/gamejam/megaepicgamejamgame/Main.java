package gamejam.megaepicgamejamgame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends ApplicationAdapter {
    private SpriteBatch batch;
    private Texture image;
    private ButtonGame game;

    @Override
    public void create() {
        // init assets
        AssetLibrary.getInstance();
        game = new ButtonGame();
        game.create();

    }

    float f = 0f;
    //BitmapFont font = new BitmapFont();

    @Override
    public void render() {
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);
        batch.begin();
        f += 0.01f;
        //f %= 2;
        batch.draw(image, 140 * (float)Math.sin(f - 1f), 210);
        //font.draw(batch, "Hello, World!", 140, 210);
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        image.dispose();
    }
}
