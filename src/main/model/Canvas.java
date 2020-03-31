package model;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import persistence.Reader;
import persistence.Writer;
import ui.CanvasPanel;
import ui.Frame;
import ui.tools.Tool;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// A 2D array that is a canvas for the paint board. Currently, whenever a new Canvas is called, it will bring up a java
// window that is suppose to represent the board. However, without the implementation of graphics, the window will
// provide nothing.
public class Canvas {
    private static final String PAINT_FILE = "./data/bigDaddy.JSON";
    public Pixel[][] bitmap;
    public int xpos = 600;
    public int ypos = 600;


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

    //EFFECTS: exports bitmap into a JSONObject and returns it into a JSONString
    public String exportConsole() {
        JSONObject newBitmap = new JSONObject();
        for (int row = 0; row < xpos; row++) {
            JSONObject thisRow = new JSONObject();
            for (int col = 0; col < ypos; col++) {
                thisRow.put(col, this.bitmap[row][col].getPixelColor().getRGB());
            }
            newBitmap.put(row, thisRow);
        }

        return newBitmap.toJSONString();
    }

    //EFFECTS: exports the list of strokes into a JSONObject and returns it into a JSONString
    public static String exportApp() {
        JSONObject object = new JSONObject();
        JSONArray jsonStrokes = new JSONArray();
        for (List<Object> stroke : CanvasPanel.strokes) {
            JSONObject singleStroke = new JSONObject(); // everything in one stroke
            singleStroke.put("color", ((Color) stroke.get(0)).getRGB());
            JSONArray xpoints = new JSONArray();        // array for x
            JSONArray ypoints = new JSONArray();        // array for y
            for (int i = 0; i < ((int[]) stroke.get(1)).length; i++) {
                xpoints.add(((int[]) stroke.get(1))[i]);
                ypoints.add(((int[]) stroke.get(2))[i]);
            }
            singleStroke.put("xpoints", xpoints);
            singleStroke.put("ypoints", ypoints);
            jsonStrokes.add(singleStroke);
        }
        object.put("strokes", jsonStrokes);
        return object.toJSONString();
    }

    //EFFECTS: saves the button through writer in persistence.
    public void saveCanvas() {
        try {
            Writer writer = new Writer(new File(PAINT_FILE));
            writer.write(exportApp());
            writer.closeWriter();
            System.out.println("Accounts saved to file " + PAINT_FILE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //EFFECTS: reloads the canvas from its JSON Object back into a list of strokes just that it can be
    //                  loaded back onto the canvas
    public void loadCanvas() {
        List<List<Object>> listOfStrokes = new ArrayList<>();
        try {
            JSONObject object = Reader.readObject(new File(PAINT_FILE));
            JSONArray strokes = (JSONArray) object.get("strokes");
            for (Object stroke : strokes) {
                JSONObject castedStroke = (JSONObject) stroke;
                int[] intArrayXPoints = new int[((JSONArray) castedStroke.get("xpoints")).size()];
                int[] intArrayYPoints = new int[((JSONArray) castedStroke.get("ypoints")).size()];
                for (int i = 0; i < ((JSONArray) castedStroke.get("xpoints")).size(); i++) {
                    intArrayXPoints[i] = ((Long) ((JSONArray) castedStroke.get("xpoints")).get(i)).intValue();
                    intArrayYPoints[i] = ((Long) ((JSONArray) castedStroke.get("ypoints")).get(i)).intValue();
                }
                listOfStrokes.add(new ArrayList<>());
                listOfStrokes.get(listOfStrokes.size() - 1).add(
                        new Color(((Long) castedStroke.get("color")).intValue()));
                listOfStrokes.get(listOfStrokes.size() - 1).add(intArrayXPoints);
                listOfStrokes.get(listOfStrokes.size() - 1).add(intArrayYPoints);
            }
            CanvasPanel.strokes = listOfStrokes;
            Frame.getInstance().canvas.repaint();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

