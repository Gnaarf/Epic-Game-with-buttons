package gamejam.megaepicgamejamgame;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.utils.Timer;

public class LevelScreen implements Screen {

    public final ButtonGame game;

    // variables for the Transition Transition
    protected LevelScreen levelAfterFail;
    protected LevelScreen nextLevel;
    protected boolean alreadyWon;

    private Timer transitionTimer;

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
