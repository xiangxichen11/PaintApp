package ui.tools;
// An abstract class that contains the main methods for all tools that will eventually be implemented.

import ui.ToolPanel;

import javax.swing.*;

public abstract class Tool {
    public String description;
    private boolean toolActive;
    protected int size;

    public Tool() {
        toolActive = false;
        size = 0;
    }

    public boolean isToolActive() {
        return toolActive;
    }

    public void activateTool() {
        toolActive = true;
    }

    public void deactivateTool() {
        toolActive = false;
    }

    protected abstract void setSize(int size);

    protected abstract int getSize();
}



