package ui;

import javax.swing.*;
import java.awt.*;

// class that represents the frame that the panels are put inside
public class Frame extends JFrame {
    private static Frame frame;
    protected ToolPanel tools;
    protected CanvasPanel canvas;

    private Frame() {
    }

    //EFFECTS; represents the constructor for the Frame due to singleton effect.
    //                  Frame is set to a private method so whenever a frame needs to be
    //                  instantiated, this method is called
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
