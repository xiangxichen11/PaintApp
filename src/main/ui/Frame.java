package ui;

import model.Canvas;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {
    private static Frame frame;
    protected ToolPanel tools;
    protected CanvasPanel canvas;

    private Frame() {
    }

    public static Frame getInstance() {
        if (frame == null) {
            frame = new Frame();
            frame.setLayout(new BorderLayout());
            frame.setSize(new Dimension(600, 600));
            frame.setDefaultCloseOperation(EXIT_ON_CLOSE);

            frame.tools = new ToolPanel();
            frame.canvas = new CanvasPanel();
            frame.canvas.setBackground(Color.white);
            frame.add(frame.tools, BorderLayout.NORTH);
            frame.add(frame.canvas, BorderLayout.CENTER);

            frame.setVisible(true);
        }
        return frame;
    }

}
