package gamejam.megaepicgamejamgame;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import org.w3c.dom.Text;

public class Button {

    public boolean up;
    public Vector2 position;
    public float scale;

    Vector2 defaultSize;

    static Texture image_up;
    static Texture image_down;

    Button(Vector2 position){
        this.up = true;
        this.position = position;
        this.scale = 1f;
        float defaultWidth = 100;
        defaultSize = new Vector2(defaultWidth, defaultWidth * image_up.getHeight() / image_up.getWidth());
    }

    public static Button Create(Vector2 position){
        if(image_up == null){
            image_up = new Texture("button_up.png");
            image_down = new Texture("button_down.png");
        }
        return new Button(position);
    }

    public boolean IsUp(){
        return up;
    }

    public boolean IsDown(){
        return !up;
    }

    public void Render(SpriteBatch batch) {
        Texture image = IsUp() ? image_up : image_down;
        batch.draw(image, position.x, position.y, defaultSize.x * scale, defaultSize.y * scale);
    }

    public boolean IsMouseOver(){
        Mouse.GetPosition();
        return true;
    }
}
