package model;

import ui.tools.Tool;

import javax.swing.*;
import java.awt.*;

public class Canvas {
    private Pixel[][] bitmap;
    int x = 1920;
    int y = 1080;


    public Canvas() {
        bitmap = new Pixel[x][y];
        for (int row = 0; row < x; row++) {
            for (int col = 0; col < y; col++) {
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
        return x * y;
    }

}

