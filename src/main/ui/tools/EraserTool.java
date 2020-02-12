package ui.tools;

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
