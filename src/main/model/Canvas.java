package model;

import ui.tools.Tool;

import java.awt.*;

public class Canvas {
    private Pixel[][] bitmap;
    int xpos = 1920;
    int ypos = 1080;


    public Canvas() {
        bitmap = new Pixel[xpos][ypos];
        for (int row = 0; row < xpos; row++) {
            for (int col = 0; col < ypos; col++) {
                bitmap[row][col] = new Pixel(Color.white);
            }
        }
    }

    //MODIFIES: this
    //EFFECTS: currently, it changes the color of the pixel on that coordinate.
    public void draw(Tool t, int x, int y) {
        if (t.description == "pencil") {
            bitmap[x][y].setColor(Color.black);
        } else if (t.description == "eraser") {
            bitmap[x][y].setColor(Color.white);
        }
    }

    public Pixel getPixel(int x, int y) {
        return bitmap[x][y];
    }

    public Pixel[][] getBitmap() {
        return bitmap;
    }

    public int getSize() {
        return xpos * ypos;
    }

}

