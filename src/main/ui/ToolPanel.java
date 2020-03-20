package ui;

import ui.tools.EraserTool;
import ui.tools.PencilTool;
import ui.tools.Tool;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToolPanel extends JPanel {
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
        JButton button = new JButton("Blue Pencil");
        button.addActionListener(e -> setToolActive(new EraserTool()));
        add(button);
    }

    public void createSaveButton() {
        JButton button = new JButton("Save");
        add(button);
    }

    public void createLoadButton() {
        JButton button = new JButton("Load");
        add(button);
    }

    public void setToolActive(Tool tool) {
        this.activeTool = tool;
    }
}
