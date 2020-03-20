package ui.tools;

import com.sun.crypto.provider.JceKeyStore;
import netscape.javascript.JSObject;
import ui.PaintApp;
import ui.ToolPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//A pencil tool that will eventually allow the user to free hand draw in the ui.
public class PencilTool extends Tool {
    private static Color color;
    private int size;

    public PencilTool() {
        description = "pencil";
    }

    public void setColor(Color c) {
        color = c;
    }

    public Color getColor() {
        return color;
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
