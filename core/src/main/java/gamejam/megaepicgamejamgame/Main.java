package gamejam.megaepicgamejamgame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;

import java.util.ArrayList;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends ApplicationAdapter {
    private SpriteBatch batch;
    private Texture image;
    private BitmapFont font;

    Animation<TextureRegion> buttonAnimation;
    Button button;

    float gameTime = 0f;

    @Override
    public void create() {
        // init assets
        AssetLibrary.getInstance();
        batch = new SpriteBatch();
        image = new Texture("libgdx.png");
        font = new BitmapFont();


        button = Button.Create(new Vector2(50,50));

        TextureRegion buttonFrame1 = new TextureRegion(new Texture("button_up.png"));
        TextureRegion buttonFrame2 = new TextureRegion(new Texture("dickbutt\\button_down.png"));
        buttonAnimation = new Animation<TextureRegion>(1f, buttonFrame1, buttonFrame2);
    }

    float f = 0f;
    //BitmapFont font = new BitmapFont();

    @Override
    public void render() {
        gameTime += Gdx.graphics.getDeltaTime();

        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);
        batch.begin();
        f += 0.01f;
        //f %= 2;
        batch.draw(image, 140 * (float)Math.sin(f - 1f), 210);
        //font.draw(batch, "Hello, World!", 140, 210);

        font.draw(batch, "Wookiepeter stinkt!", 100, 150);
        TextureRegion currentFrame = buttonAnimation.getKeyFrame(gameTime, true);
        batch.draw(currentFrame, 200, 50, 100, 100); // Draw current frame at (50, 50)

        button.up = !(button.IsMouseOver() && Mouse.IsLeftPressed());
        button.Render(batch);

        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        image.dispose();
    }
}
