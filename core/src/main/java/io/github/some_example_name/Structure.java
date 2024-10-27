package io.github.some_example_name;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Structure {
    private Texture woodHorizontal, woodVertical, stoneHorizontal, stoneVertical, glassHorizontal, glassVertical;
    private float[][] blockPositions;

    public Structure() {
        woodHorizontal = new Texture("wood_horizontal.png");
        woodVertical = new Texture("wood_vertical.png");
        stoneHorizontal = new Texture("stone_horizontal.png");
        stoneVertical = new Texture("stone_vertical.png");
        glassHorizontal = new Texture("glass_horizontal.png");
        glassVertical = new Texture("glass_vertical.png");

        blockPositions = new float[][] {
            {500, 181}, {580, 181},
            {200, 300}, {100, 250},
        };
    }

    public void render(SpriteBatch batch) {
        for (float[] pos : blockPositions) {
            batch.draw(woodHorizontal, pos[0], pos[1], 80, 20);
        }
    }

    public void dispose() {
        woodHorizontal.dispose();
        woodVertical.dispose();
        stoneHorizontal.dispose();
        stoneVertical.dispose();
        glassHorizontal.dispose();
        glassVertical.dispose();
    }
}
