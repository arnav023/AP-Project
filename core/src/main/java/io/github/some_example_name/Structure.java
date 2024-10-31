package io.github.some_example_name;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Arrays;

public class Structure {
    private Texture woodHorizontal, woodVertical, woodSquare, woodSolidSquare, stoneSquare, stoneSolidSquare, stoneHorizontal, stoneVertical, glassSquare, glassSolidSquare, glassHorizontal, glassVertical;
    private float[][] WoodHorizontalPositions;
    private float[][] WoodVerticalPositions;
    private float[][] WoodSquarePositions;
    private float[][] WoodSolidSquarePositions;
    private float[][] StoneHorizontalPositions;
    private float[][] StoneVerticalPositions;
    private float[][] StoneSquarePositions;
    private float[][] StoneSolidSquarePositions;
    private float[][] GlassHorizontalPositions;
    private float[][] GlassVerticalPositions;
    private float[][] GlassSquarePositions;
    private float[][] GlassSolidSquarePositions;
    private int health;

    public Structure() {
        woodHorizontal = new Texture("wood_horizontal.png");
        woodVertical = new Texture("wood_vertical.png");
        woodSquare = new Texture("wood_square.png");
        woodSolidSquare = new Texture("wood_solid_square.png");
        stoneHorizontal = new Texture("stone_horizontal.png");
        stoneVertical = new Texture("stone_vertical.png");
        stoneSquare = new Texture("stone_square.png");
        stoneSolidSquare = new Texture("stone_solid_square.png");
        glassHorizontal = new Texture("glass_horizontal.png");
        glassVertical = new Texture("glass_vertical.png");
        glassSquare = new Texture("glass_square.png");
        glassSolidSquare = new Texture("glass_solid_square.png");
    }

    public void render(SpriteBatch batch) {
        if(WoodHorizontalPositions!=null && WoodHorizontalPositions.length!=0) {
            for (float[] pos : WoodHorizontalPositions) {
                batch.draw(woodHorizontal, pos[0], pos[1], pos[2], pos[3]);
            }
        }
        if(WoodVerticalPositions!=null && WoodVerticalPositions.length!=0) {
            for (float[] pos : WoodVerticalPositions) {
                batch.draw(woodVertical, pos[0], pos[1], pos[2], pos[3]);
            }
        }
        if(WoodSquarePositions!=null && WoodSquarePositions.length!=0) {
            for (float[] pos : WoodSquarePositions) {
                batch.draw(woodSquare, pos[0], pos[1], pos[2], pos[3]);
            }
        }
        if(WoodSolidSquarePositions!=null && WoodSolidSquarePositions.length!=0) {
            for (float[] pos : WoodSolidSquarePositions) {
                batch.draw(woodSolidSquare, pos[0], pos[1], pos[2], pos[3]);
            }
        }
        if(StoneHorizontalPositions!=null && StoneHorizontalPositions.length!=0) {
            for (float[] pos : StoneHorizontalPositions) {
                batch.draw(stoneHorizontal, pos[0], pos[1], pos[2], pos[3]);
            }
        }
        if(StoneVerticalPositions!=null && StoneVerticalPositions.length!=0) {
            for (float[] pos : StoneVerticalPositions) {
                batch.draw(stoneVertical, pos[0], pos[1], pos[2], pos[3]);
            }
        }
        if(StoneSquarePositions!=null && StoneSquarePositions.length!=0) {
            for (float[] pos : StoneSquarePositions) {
                batch.draw(stoneSquare, pos[0], pos[1], pos[2], pos[3]);
            }
        }
        if(StoneSolidSquarePositions!=null && StoneSolidSquarePositions.length!=0) {
            for (float[] pos : StoneSolidSquarePositions) {
                batch.draw(stoneSolidSquare, pos[0], pos[1], pos[2], pos[3]);
            }
        }
        if(GlassHorizontalPositions!=null && GlassHorizontalPositions.length!=0) {
            for (float[] pos : GlassHorizontalPositions) {
                batch.draw(glassHorizontal, pos[0], pos[1], pos[2], pos[3]);
            }
        }
        if(GlassVerticalPositions!=null && GlassVerticalPositions.length!=0) {
            for (float[] pos : GlassVerticalPositions) {
                batch.draw(glassVertical, pos[0], pos[1], pos[2], pos[3]);
            }
        }
        if(GlassSquarePositions!=null && GlassSquarePositions.length!=0) {
            for (float[] pos : GlassSquarePositions) {
                batch.draw(glassSquare, pos[0], pos[1], pos[2], pos[3]);
            }
        }
        if(GlassSolidSquarePositions!=null && GlassSolidSquarePositions.length!=0) {
            for (float[] pos : GlassSolidSquarePositions) {
                batch.draw(glassSolidSquare, pos[0], pos[1], pos[2], pos[3]);
            }
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
    public int getHealth(){ return this.health;}
    public void setHealth(){}
    public void setWoodHorizontal(float[][] WoodHorizontalPositions){this.WoodHorizontalPositions=WoodHorizontalPositions;}
    public void setWoodVertical(float[][] WoodVerticalPositions){this.WoodVerticalPositions=WoodVerticalPositions;}
    public void setWoodSquare(float[][] WoodSquarePositions){this.WoodSquarePositions=WoodSquarePositions;}
    public void setWoodSolidSquare(float[][] WoodSolidSquarePositions){this.WoodSolidSquarePositions=WoodSolidSquarePositions;}
    public void setStoneHorizontal(float[][] StoneHorizontalPositions){this.StoneHorizontalPositions=StoneHorizontalPositions;}
    public void setStoneVertical(float[][] StoneVerticalPositions){this.StoneVerticalPositions=StoneVerticalPositions;}
    public void setStoneSquare(float[][] StoneSquarePositions){this.StoneSquarePositions=StoneSquarePositions;}
    public void setStoneSolidSquare(float[][] StoneSolidSquarePositions){this.StoneSolidSquarePositions=StoneSolidSquarePositions;}
    public void setGlassHorizontal(float[][] GlassHorizontalPositions){this.GlassHorizontalPositions=GlassHorizontalPositions;}
    public void setGlassVertical(float[][] GlassVerticalPositions){this.GlassVerticalPositions=GlassVerticalPositions;}
    public void setGlassSquare(float[][] GlassSquarePositions){this.GlassSquarePositions=GlassSquarePositions;}
    public void setGlassSolidSquare(float[][] GlassSolidSquarePositions){this.GlassSolidSquarePositions=GlassSolidSquarePositions;}

}
