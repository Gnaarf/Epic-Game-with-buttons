package gamejam.megaepicgamejamgame;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

public class ButtonGame extends Game {

    public SpriteBatch batch;
    public BitmapFont font;
    public BitmapFont boldFont;

    @Override
    public void create() {
        batch = new SpriteBatch();

        font = AssetLibrary.getInstance().defaultFont;
        boldFont = AssetLibrary.getInstance().boltFont;

        this.setScreen(new StartScreen(this));
    }


    public  void render() {
        super.render();
    }

    public void dispose() {
        batch.dispose();
        font.dispose();
    }
}
