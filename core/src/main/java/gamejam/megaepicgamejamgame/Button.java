package gamejam.megaepicgamejamgame;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import org.w3c.dom.Text;

public class Button {

    public boolean up;
    public Vector2 position;
    public float scale;

    Vector2 defaultSize;

    static Texture image_up;
    static Texture image_down;

    // only for internal state tracking -> don't use!!!
    private boolean lastButtonState;

    public Button(float x, float y) {
        this(new Vector2(x, y));
    }

    public Button(Vector2 position){
        if(image_up == null){
            image_up = new Texture("button_up.png");
            image_down = new Texture("button_down.png");
        }
        this.up = true;
        lastButtonState = this.up;
        this.position = position;
        this.scale = 1f;
        float defaultWidth = 100;
        defaultSize = new Vector2(defaultWidth, defaultWidth * image_up.getHeight() / image_up.getWidth());
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
