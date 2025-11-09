package gamejam.megaepicgamejamgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.utils.Array;

import java.util.Random;

public final class AssetLibrary {
    private static AssetLibrary INSTANCE;

    // Textures
    public Texture libgdx_logo;
    public Texture button_down;
    public Texture button_up;
    public Texture pointing_index_finger;
    public Texture safety_lid;
    public Texture safety_lid_transparent;
    public Texture mouse;

    // Sounds
    public Sound winSound;
    public Sound buttonDownSound;
    public Sound buttonUpSound;
    public Sound swooshSound;
    public Sound swooshSoundNoDelay;
    public Sound fakeWinSound;
    public Sound windowsErrorSound;
    public Sound mousePeep;
    public Array<Sound> frustrationSounds;

    public BitmapFont defaultFont;
    public BitmapFont boldFont;

    private AssetLibrary() {
        // Textures
        button_down = new Texture("button_down.png");
        button_up = new Texture("button_up.png");
        libgdx_logo = new Texture("libgdx.png");
        pointing_index_finger = new Texture("pointing_index_finger.png");
        safety_lid = new Texture("safety_lid.png");
        safety_lid_transparent = new Texture("safety_lid_transparent.png");
        mouse = new Texture("ButtonGame_mouse.png");


        loadSounds();

        defaultFont = generateFont(false, 40);
        boldFont = generateFont(true, 40);
    }

    private void loadSounds() {
        winSound = Gdx.audio.newSound(Gdx.files.internal("winning_chime.mp3"));
        buttonDownSound = Gdx.audio.newSound(Gdx.files.internal("button_press_down.mp3"));
        buttonUpSound = Gdx.audio.newSound(Gdx.files.internal("button_press_up.mp3"));
        swooshSound = Gdx.audio.newSound(Gdx.files.internal("swoosh_sound_effect.mp3"));
        swooshSoundNoDelay = Gdx.audio.newSound(Gdx.files.internal("swoosh_sound_effect_no_delay.wav"));
        fakeWinSound = Gdx.audio.newSound(Gdx.files.internal("fakeout_chime.mp3"));
        windowsErrorSound = Gdx.audio.newSound(Gdx.files.internal("Windows Background.mp3"));
        mousePeep = Gdx.audio.newSound(Gdx.files.internal("mouse_peep.mp3"));

        frustrationSounds = new Array<>();

        frustrationSounds.add(Gdx.audio.newSound(Gdx.files.internal("moan_01.mp3")));
        frustrationSounds.add(Gdx.audio.newSound(Gdx.files.internal("moan_01.mp3")));
        frustrationSounds.add(Gdx.audio.newSound(Gdx.files.internal("sentence_01.mp3")));
        frustrationSounds.add(Gdx.audio.newSound(Gdx.files.internal("sentence_02.mp3")));
        frustrationSounds.add(Gdx.audio.newSound(Gdx.files.internal("sentence_03.mp3")));
        frustrationSounds.add(Gdx.audio.newSound(Gdx.files.internal("sentence_04.mp3")));
        frustrationSounds.add(Gdx.audio.newSound(Gdx.files.internal("sentence_05.mp3")));
    }

    public static AssetLibrary getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new AssetLibrary();
        }

        return INSTANCE;
    }

    public static BitmapFont generateFont(boolean bold, int size) {
        String fontPath;
        if (bold) {
            fontPath = "Montserrat-Bold.ttf";
        } else {
            fontPath = "Montserrat-Medium.ttf";
        }

        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal(fontPath));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = size;
        BitmapFont font = generator.generateFont(parameter); // font size 12 pixels
        generator.dispose();

        return font;
    }
    public Sound getRandomFrustationSound() {
        Random random = new Random();
        int index = random.nextInt(frustrationSounds.size);
        return frustrationSounds.get(index);
    }
}

