package ui.tools;

public abstract class Tool {
    public String description;
    public boolean toolActive;
    public int size;

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

    public abstract void setSize(int size);

    public abstract int getSize();

}
