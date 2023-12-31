package com.airbound.game.sprites;

import com.airbound.game.GameConstants;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class Walls {
    private final Texture leftTexture;
    private final Texture rightTexture;
    private int parts;
    private int[] heights;

    public Walls(int wallTextureNumber){
        leftTexture = new Texture("Walls/wall" + wallTextureNumber + ".png");
        rightTexture = new Texture("Walls/wall" + wallTextureNumber + ".png");
        parts = 1600/leftTexture.getHeight()+2;
        heights = new int[parts];
        for (int i = 0; i < parts; i++) {
            heights[i] = (leftTexture.getHeight())*i-900;
        }
    }
    public void draw(SpriteBatch sb, float y)
    {

        for(int i=0; i<parts; i++)
        {
            if(-y > heights[i] + (leftTexture.getHeight()))
                heights[i] += parts*(leftTexture.getHeight());
            sb.draw(leftTexture, 0, heights[i]+y, GameConstants.WALL_SIZE, leftTexture.getHeight());
            sb.draw(rightTexture, GameConstants.GAME_WIDTH-GameConstants.WALL_SIZE, heights[i]+y, GameConstants.WALL_SIZE, rightTexture.getHeight());
        }
    }

    public void dispose(){
        rightTexture.dispose();
        leftTexture.dispose();
    }
}
