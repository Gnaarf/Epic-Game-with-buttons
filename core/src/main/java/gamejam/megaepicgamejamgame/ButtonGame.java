package gamejam.megaepicgamejamgame;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ButtonGame extends Game {

    public SpriteBatch batch;
    public BitmapFont font;
    public BitmapFont boldFont;

    @Override
    public void create() {
        batch = new SpriteBatch();

        font = AssetLibrary.getInstance().defaultFont;
        boldFont = AssetLibrary.getInstance().boldFont;

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
