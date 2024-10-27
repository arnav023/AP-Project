package io.github.some_example_name;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Bird {
    private Texture texture;
    private float x, y;

    public Bird(float x, float y, String name) {
        this.texture = new Texture(name+".png");
        this.x = x;
        this.y = y;
    }

    public void render(SpriteBatch batch) {
        batch.draw(texture, x, y, 40, 40);
    }

    public void dispose() {
        texture.dispose();
    }
}
