package ui.tools;

import ui.ToolPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// eraser tool that will eventually allow the user to erase in the ui.
public class EraserTool extends Tool {
    private int size;

    public EraserTool() {
        description = "eraser";
    }

    @Override
    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public int getSize() {
        return size;
    }

}
