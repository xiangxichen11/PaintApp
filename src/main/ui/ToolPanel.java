package ui;

import model.Canvas;
import ui.tools.EraserTool;
import ui.tools.PencilTool;
import ui.tools.Tool;

import javax.swing.*;

// class that represents a menu bar consisting of buttons that have a specific function
public class ToolPanel extends JPanel {
    public Tool activeTool;
    private Canvas canvas;

    public ToolPanel() {
        canvas = new Canvas();

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
        button.addActionListener(e -> canvas.saveCanvas());
        add(button);
    }

    //EFFECTS: creates a button that allows the canvas to be reloaded
    public void createLoadButton() {
        JButton button = new JButton("Load");
        button.addActionListener(e -> canvas.loadCanvas());
        add(button);
    }

    //EFFECTS: sets the current to be the active tool
    public void setToolActive(Tool tool) {
        this.activeTool = tool;
    }
}
