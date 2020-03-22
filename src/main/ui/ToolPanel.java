package ui;

import model.Canvas;
import model.Pixel;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
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

public class ToolPanel extends JPanel {
    private static final String PAINT_FILE = "./data/bigDaddy.JSON";
    public Tool activeTool;

    public ToolPanel() {
        createPencilButton();
        createEraserButton();
        createSaveButton();
        createLoadButton();
    }

    public void createPencilButton() {
        JButton button = new JButton("Pencil");
        button.addActionListener(e -> setToolActive(new PencilTool()));
        add(button);
    }

    public void createEraserButton() {
        JButton button = new JButton("Eraser");
        button.addActionListener(e -> setToolActive(new EraserTool()));
        add(button);
    }

    public void createSaveButton() {
        JButton button = new JButton("Save");
        button.addActionListener(e -> saveCanvas());
        add(button);
    }

    public void createLoadButton() {
        JButton button = new JButton("Load");
        button.addActionListener(e -> loadCanvas());
        add(button);
    }

    public void setToolActive(Tool tool) {
        this.activeTool = tool;
    }

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
