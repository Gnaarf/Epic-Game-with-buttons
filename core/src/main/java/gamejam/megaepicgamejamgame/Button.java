package gamejam.megaepicgamejamgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import org.w3c.dom.Text;

import java.awt.*;

public class Button {

    public boolean up;
    public Vector2 position;
    public float scale;
    public String text;

    Vector2 defaultSize;
    Vector2 textOffSet;

    public int DEFAULT_FONT_SIZE = 35;
    public BitmapFont currentFont;

    static Texture image_up;
    static Texture image_down;

    // only for internal state tracking -> don't use!!!
    private boolean lastButtonState;

    public Button(float x, float y) {
        this(new Vector2(x, y), "");
    }
    public Button(float x, float y, String text) {
        this(new Vector2(x, y), text);
    }
    public Button(Vector2 position) {
        this(position, "");
    }

    public Button(Vector2 position, String text){
        currentFont = AssetLibrary.generateFont(false, DEFAULT_FONT_SIZE);
        if(image_up == null){
            image_up = new Texture("button_up.png");
            image_down = new Texture("button_down.png");
        }
        this.up = true;
        lastButtonState = this.up;
        this.position = position;
        this.text = text;
        float defaultWidth = 100;
        this.scale = 1f;
        defaultSize = new Vector2(defaultWidth, defaultWidth * image_up.getHeight() / image_up.getWidth());
        this.setScale(scale);
    }


    public void setScale(float scale) {
        this.scale = scale;
        int newFontScale = Math.max(4, (int) (DEFAULT_FONT_SIZE * Math.pow(this.scale, 1.2f)));
        this.currentFont = AssetLibrary.generateFont(false, newFontScale);
        updateTextOffset();
    }

    private void updateTextOffset() {
        GlyphLayout layout = new GlyphLayout();
        layout.setText(currentFont, this.text);
        this.textOffSet = new Vector2(((defaultSize.x * scale) - layout.width) / 2, (defaultSize.y * this.scale) * 0.85f);
    }

    public boolean IsUp(){
        return up;
    }

    public boolean IsDown() {
        return !up;
    }

    public void Render(SpriteBatch batch) {
        Texture image = IsUp() ? image_up : image_down;
        batch.draw(image, position.x, position.y, defaultSize.x * scale, defaultSize.y * scale);
        // Vector2 textPos = new Vector2(position.x + 40*scale, position.y+80*scale);
        Vector2 textPos = new Vector2(position.x + this.textOffSet.x, position.y + this.textOffSet.y);
        if(IsDown()){textPos.y -= 10*scale;}
        currentFont.draw(batch, text, textPos.x,  textPos.y);

        // play sound on button state change
        if (lastButtonState != IsUp()) {
            lastButtonState = IsUp();
            Sound soundToPlay = IsUp() ? AssetLibrary.getInstance().buttonUpSound : AssetLibrary.getInstance().buttonDownSound;
            soundToPlay.play();

        }
    }

    Vector2 GetSize(){
        return new Vector2(defaultSize.x * scale, defaultSize.y * scale);
    }

    public boolean IsMouseOver(){
        Rectangle rect = new Rectangle(position.x, position.y, GetSize().x, GetSize().y);
        return rect.contains(Mouse.GetPosition());
    }
}
