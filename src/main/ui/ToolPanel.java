package ui;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import persistence.Reader;
import persistence.Writer;
import ui.tools.EraserTool;
import ui.tools.PencilTool;
import ui.tools.Tool;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// class that represents a menu bar consisting of buttons that have a specific function
public class ToolPanel extends JPanel {
    private static final String PAINT_FILE = "./data/bigDaddy.JSON";
    public Tool activeTool;

    public ToolPanel() {
        createPencilButton();
        createEraserButton();
        createSaveButton();
        createLoadButton();
    }

    //EFFECTS: creates a button that activates the pencil tool
    public void createPencilButton() {
        JButton button = new JButton("Pencil");
        button.addActionListener(e -> setToolActive(new PencilTool()));
        add(button);
    }

    //EFFECTS: creates a button that activates the eraser tool
    public void createEraserButton() {
        JButton button = new JButton("Eraser");
        button.addActionListener(e -> setToolActive(new EraserTool()));
        add(button);
    }

    //EFFECTS: creates a button that allows the canvas to be saved
    public void createSaveButton() {
        JButton button = new JButton("Save");
        button.addActionListener(e -> saveCanvas());
        add(button);
    }

    //EFFECTS: creates a button that allows the canvas to be reloaded
    public void createLoadButton() {
        JButton button = new JButton("Load");
        button.addActionListener(e -> loadCanvas());
        add(button);
    }

    //EFFECTS: sets the current to be the active tool
    public void setToolActive(Tool tool) {
        this.activeTool = tool;
    }

    //EFFECTS: saves the button through writer in persistence.
    public void saveCanvas() {
        try {
            Writer writer = new Writer(new File(PAINT_FILE));
            writer.write(CanvasPanel.export());
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
                int[] xpointsXD = new int[((JSONArray) castedStroke.get("xpoints")).size()];
                int[] ypointsXD = new int[((JSONArray) castedStroke.get("ypoints")).size()];
                for (int i = 0; i < ((JSONArray) castedStroke.get("xpoints")).size(); i++) {
                    xpointsXD[i] = ((Long) ((JSONArray) castedStroke.get("xpoints")).get(i)).intValue();
                    ypointsXD[i] = ((Long) ((JSONArray) castedStroke.get("ypoints")).get(i)).intValue();
                }
                listOfStrokes.add(new ArrayList<>());
                listOfStrokes.get(listOfStrokes.size() - 1).add(
                        new Color(((Long) castedStroke.get("color")).intValue()));
                listOfStrokes.get(listOfStrokes.size() - 1).add(xpointsXD);
                listOfStrokes.get(listOfStrokes.size() - 1).add(ypointsXD);
            }
            CanvasPanel.strokes = listOfStrokes;
            Frame.getInstance().canvas.repaint();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
