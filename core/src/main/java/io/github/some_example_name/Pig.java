package io.github.some_example_name;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Pig {
    private Texture texture;
    private float x, y;
    private int pighealth;
    private int width;
    private int height;

    public Pig(float x, float y, String pigType, int width, int height) {
        this.texture = new Texture(pigType + ".png");
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void render(SpriteBatch batch) {
        batch.draw(texture, x, y, width, height);
    }

    public void dispose() {
        texture.dispose();
    }
    public int getHealth(){ return this.pighealth;}
    public void setHealth(){}
}
