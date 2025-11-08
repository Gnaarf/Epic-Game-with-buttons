package gamejam.megaepicgamejamgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;

public final class AssetLibrary {
    private static AssetLibrary INSTANCE;

    // Textures
    public Texture libgdx_logo;
    public Texture button_down;
    public Texture button_up;
    public Texture pointing_index_finger;
    public Texture safety_lid;
    public Texture safety_lid_transparent;

    // Sounds
    public Sound moan_01;
    public Sound moan_02;
    private AssetLibrary() {
        // Textures
        button_down = new Texture("button_down.png");
        button_up = new Texture("button_up.png");
        libgdx_logo = new Texture("libgdx.png");
        pointing_index_finger = new Texture("pointing_index_finger.png");
        safety_lid = new Texture("safety_lid.png");
        safety_lid_transparent = new Texture("safety_lid_transparent.png");

        moan_01 = Gdx.audio.newSound(Gdx.files.internal("moan_01.mp3"));
        moan_02 = Gdx.audio.newSound(Gdx.files.internal("moan_01.mp3"));
    }

    public static AssetLibrary getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new AssetLibrary();
        }

        return INSTANCE;
    }
}
