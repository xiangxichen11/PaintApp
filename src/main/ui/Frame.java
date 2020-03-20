package ui;

import model.Canvas;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {

    public Frame() {
        setLayout(new BorderLayout());
        setSize(new Dimension(600, 600));
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        ToolPanel tools = new ToolPanel();
        CanvasPanel canvas = new CanvasPanel(tools);
        canvas.setBackground(Color.white);
        add(tools, BorderLayout.NORTH);
        add(canvas, BorderLayout.CENTER);

        setVisible(true);
    }

}
