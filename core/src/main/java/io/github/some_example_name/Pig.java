package io.github.some_example_name;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Pig {
    private Texture texture;
    private float x, y;

    public Pig(float x, float y, String pigType) {
        this.texture = new Texture(pigType + ".png");
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
