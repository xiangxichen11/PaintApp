package ui;

import model.Canvas;
import model.Pixel;
import ui.tools.PencilTool;
import ui.tools.Tool;

import java.awt.*;

public class Main {
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RESET = "\u001B[0m";

    public static void main(String[] args) {
        Canvas canvas = new Canvas();
        PencilTool pencil = new PencilTool();
        canvas.draw(pencil, 0, 0);
        pencil.setColor(Color.CYAN);
        pencil.setSize(100);
        printCanvas(canvas);
    }


    public static void printCanvas(Canvas canvas) {
        for (int row = 0; row < 10; row++) {
            for (int col = 0; col < 10; col++) {
                if (row != 0 || col != 0) {
                    System.out.print("o");
                } else {
                    System.out.print(ANSI_YELLOW + ". " + ANSI_RESET);
                }
            }
            System.out.println(" ");
        }
    }
}
