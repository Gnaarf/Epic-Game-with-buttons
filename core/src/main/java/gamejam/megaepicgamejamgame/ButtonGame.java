package gamejam.megaepicgamejamgame;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import gamejam.megaepicgamejamgame.levels.*;

public class ButtonGame extends Game {

    public SpriteBatch batch;
    public BitmapFont font;
    public BitmapFont boldFont;

    public int level;

    @Override
    public void create() {
        batch = new SpriteBatch();
        level = 1;

        font = AssetLibrary.getInstance().defaultFont;
        boldFont = AssetLibrary.getInstance().boldFont;

        this.setScreen(new LevelSimpleButton(this));
    }

    public void startNextLevel() {
        this.level++;
        startLevel(this.level);
    }
    public void restartLevel() {
        startLevel(this.level);
    }

    public void startLevel(int level) {
        this.level = level;
        switch (level) {
            case 1: this.setScreen(new LevelSimpleButton(this)); break;
            case 2: this.setScreen(new LevelPressFourButtons(this)); break;
            case 3: this.setScreen(new LevelMoveFinger(this)); break;
            case 4: this.setScreen(new LevelOpenLid(this)); break;
            case 5: this.setScreen(new LevelMouse(this)); break;
            case 6: this.setScreen(new LevelUnpressTheButton(this)); break;
            case 7: this.setScreen(new LevelConveyor(this)); break;
            case 8: this.setScreen(new LevelZoomButton(this)); break;
            case 9: this.setScreen(new LevelHouseEnter(this)); break;
            default:
                Gdx.app.log("ERROR", "Reached max level Count -> Restarting!");
                this.level = 1;
                this.setScreen(new StartScreen(this));
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
