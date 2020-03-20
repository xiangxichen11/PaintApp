package ui;

import model.Canvas;
import model.Pixel;
import ui.tools.EraserTool;
import ui.tools.PencilTool;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.*;
import java.util.List;

public class CanvasPanel extends JPanel {
    private ToolPanel tools;
    public Canvas canvas;
    // inner list: index 0 is color, index 1 is int[] x points, index 2 is int[] y points
    private List<List<Object>> strokes;

    public CanvasPanel(ToolPanel tools) {
        this.tools = tools;
        canvas = new Canvas();
        strokes = new ArrayList<>();

        addMouseListener(new MouseClickListener());
        addMouseMotionListener(new MouseMotionListener());
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        g2.setStroke(new BasicStroke(6));

        for (List<Object> stroke : strokes) {
            g2.setColor((Color) stroke.get(0));
            g2.drawPolyline(((int[]) stroke.get(1)), ((int[]) stroke.get(2)), ((int[]) stroke.get(1)).length);
        }
    }

    private class MouseClickListener extends MouseAdapter {
        public void mousePressed(MouseEvent e) {
            if (tools.activeTool.getClass().isAssignableFrom(PencilTool.class)) {
                strokes.add(new ArrayList<>());
                strokes.get(strokes.size() - 1).add(Color.black);
                strokes.get(strokes.size() - 1).add(new int[0]);     // x points
                strokes.get(strokes.size() - 1).add(new int[0]);     // y points
            } else if (tools.activeTool.getClass().isAssignableFrom(EraserTool.class)) {
                strokes.add(new ArrayList<>());
                strokes.get(strokes.size() - 1).add(Color.blue);
                strokes.get(strokes.size() - 1).add(new int[0]);
                strokes.get(strokes.size() - 1).add(new int[0]);
            }
        }
    }

    private class MouseMotionListener extends MouseMotionAdapter {
        public void mouseDragged(MouseEvent e) {
            if (tools.activeTool.getClass().isAssignableFrom(PencilTool.class)) {
                canvas.getBitmap()[e.getX()][e.getY()] = new Pixel(Color.black);
            } else if (tools.activeTool.getClass().isAssignableFrom(EraserTool.class)) {
                canvas.getBitmap()[e.getX()][e.getY()] = new Pixel(Color.white);
            }

            int[] lastXStrokePoints = (int[]) strokes.get(strokes.size() - 1).get(1);
            int[] tempXPoints = new int[lastXStrokePoints.length + 1];
            System.arraycopy(lastXStrokePoints, 0, tempXPoints, 0, lastXStrokePoints.length);
            tempXPoints[tempXPoints.length - 1] = e.getX();
            strokes.get(strokes.size() - 1).set(1, tempXPoints);

            int[] lastYStrokePoints = (int[]) strokes.get(strokes.size() - 1).get(2);
            int[] tempYPoints = new int[lastYStrokePoints.length + 1];
            System.arraycopy(lastYStrokePoints, 0, tempYPoints, 0, lastYStrokePoints.length);
            tempYPoints[tempYPoints.length - 1] = e.getY();
            strokes.get(strokes.size() - 1).set(2, tempYPoints);

            repaint();
        }
    }
}


