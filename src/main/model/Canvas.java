package model;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.json.simple.JSONObject;
import ui.tools.Tool;

import java.awt.*;

// A 2D array that is a canvas for the paint board. Currently, whenever a new Canvas is called, it will bring up a java
// window that is suppose to represent the board. However, without the implementation of graphics, the window will
// provide nothing.
public class Canvas {
    private Pixel[][] bitmap;
    int xpos = 1920;
    int ypos = 1080;

    //EFFECTS: A 2D array that is currently blank acting like a canvas
    public Canvas() {
        bitmap = new Pixel[xpos][ypos];
        for (int row = 0; row < xpos; row++) {
            for (int col = 0; col < ypos; col++) {
                bitmap[row][col] = new Pixel(Color.white);
            }
        }
    }

    //MODIFIES: this
    //EFFECTS: if tool description == "pencil", set the pixel the tool is on to black,
    //                  else, if tool description = "eraser", set the pixel the tool is on to white.
    public void draw(Tool t, int x, int y) {
        if (t.description == "pencil") {
            bitmap[x][y].setColor(Color.black);
        } else if (t.description == "eraser") {
            bitmap[x][y].setColor(Color.white);
        }
    }

    public Pixel[][] getBitmap() {
        return bitmap;
    }

    public Pixel getPixel(int x, int y) {
        return bitmap[x][y];
    }

    public int getSize() {
        return xpos * ypos;
    }

    public JSONObject export() {
        JSONObject obj = new JSONObject();
        obj.put("bitmap", bitmap);
        System.out.println(obj.toJSONString());
        return obj;
    }


}

