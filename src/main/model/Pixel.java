package model;

import java.awt.*;

//A pixel on a canvas. Currently it only has color
public class Pixel {
    private Color color;

    //EFFECTS: represents the current pixel on the screen
    public Pixel(Color c) {
        this.color = c;
    }

    public void setColor(Color c) {
        color = c;
    }

    public Color getPixelColor() {
        return color;
    }


}
