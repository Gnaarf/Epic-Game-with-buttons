package gamejam.megaepicgamejamgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.utils.Timer;
import gamejam.megaepicgamejamgame.levels.*;

public class LevelScreen implements Screen {

    public final ButtonGame game;

    // variables for the Transition Transition
    protected LevelScreen levelAfterFail;
    protected LevelScreen nextLevel;
    protected boolean alreadyWon;

    private Timer transitionTimer;
    private boolean debugEnabled = true;

    public LevelScreen(final ButtonGame game) {
        this.game = game;
        this.transitionTimer = new Timer();
        this.alreadyWon = false;
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        if (debugEnabled) {
            int goToLevel = -1;
            if (Gdx.input.isKeyJustPressed(Input.Keys.NUM_1)) {
                goToLevel = 1;
            }
            else if (Gdx.input.isKeyJustPressed(Input.Keys.NUM_2)) {
                goToLevel = 2;
            }
            else if (Gdx.input.isKeyJustPressed(Input.Keys.NUM_3)) {
                goToLevel = 3;
            }
            else if (Gdx.input.isKeyJustPressed(Input.Keys.NUM_4)) {
                goToLevel = 4;
            }
            else if (Gdx.input.isKeyJustPressed(Input.Keys.NUM_5)) {
                goToLevel = 5;
            }

            if (goToLevel > 0) {
                final int level = goToLevel;
                Timer.instance().postTask(new Timer.Task() {
                    @Override
                    public void run() {
                        dispose();
                        game.startLevel(level);
                    }
                });
            }
        }
    }

    public void initFail(LevelScreen _levelAfterFail) {
        if (!this.alreadyWon) {
            this.levelAfterFail = _levelAfterFail;
            game.setScreen(new FailScreen(this.game, this, levelAfterFail));
            dispose();
        }
    }

    public void initSuccess(LevelScreen _nextLevel) {
        if (!this.alreadyWon) {
            this.alreadyWon = true;
            this.nextLevel = _nextLevel;
            AssetLibrary.getInstance().winSound.play();
            transitionTimer.scheduleTask(new Timer.Task() {
                @Override
                public void run() {
                    successTransition();
                }
            }, 0.75f);
        }
    }

    public void successTransition() {
        game.setScreen(nextLevel);
        this.dispose();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
