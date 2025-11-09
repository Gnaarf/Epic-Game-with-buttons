package gamejam.megaepicgamejamgame;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import gamejam.megaepicgamejamgame.levels.*;

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

    public void startLevel(int level) {
        switch (level) {
            case 1: this.setScreen(new Level01(this)); break;
            case 2: this.setScreen(new Level02(this)); break;
            case 3: this.setScreen(new Level03(this)); break;
            case 4: this.setScreen(new Level04(this)); break;
            case 5: this.setScreen(new LevelMouse(this)); break;
        }
    }

    public  void render() {
        super.render();
    }

    public void dispose() {
        batch.dispose();
        font.dispose();
    }
}
