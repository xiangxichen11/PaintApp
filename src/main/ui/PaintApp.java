package ui;

import model.Canvas;
import ui.tools.EraserTool;
import ui.tools.PencilTool;

import java.awt.*;
import java.util.Scanner;

//class that demonstrates what the program is capable of doing.

public class PaintApp {
    private Scanner input;


    //EFFECTS: runs the paint application
    public PaintApp() {
        runPaintApp();
    }

    // Used TellerApp as a reference
    //MODIFIES: this
    //EFFECTS: allows the app to run. Activates user inputs
    private void runPaintApp() {
        boolean stillOn = true;
        String command = "";
        input = new Scanner(System.in);

        while (stillOn) {
            showMenu();
            command = input.next();
            command = command.toLowerCase();

            if (command.equals("q")) {
                stillOn = false;
            } else {
                continueCommand(command);
            }
        }
        System.out.println("\nBye Bye!");
    }

    //EFFECTS: displays options menu
    private void showMenu() {
        System.out.println("\n Welcome to the Paint App");
        System.out.println("\n Please select one of the following");
        System.out.println("oc -> Open Canvas");
        System.out.println("pc -> Select Pencil Color");
        System.out.println("ps -> Select Pencil Size");
        System.out.println("es -> Select Eraser Size");
        System.out.println("up -> Use Pencil");
        System.out.println("ue -> Use Eraser");
        System.out.println("q -> Quit Application");
    }

    //MODIFIES: this
    //EFFECTS: runs user command
    private void continueCommand(String command) {
        if (command.equals("oc")) {
            printCanvas(-1, -1); // Since the canvas is currently taking in a coordinate, it will always return with a dot
                                                        // if the coordinates are within the bound. Thus, I have set the coordinate to (-1, -1)
                                                        // so that it prints a blank canvas at the start.
        } else if (command.equals("pc")) {
            pencilColor();
        } else if (command.equals("ps")) {
            pencilSize();
        } else if (command.equals("es")) {
            eraserSize();
        } else if (command.equals("up")) {
            usePencil();
        } else if (command.equals("ue")) {
            useEraser();
        } else {
            System.out.println("Unable to process");
        }
    }

    //EFFECTS: prints a canvas in console
    private void printCanvas(int x, int y) {
        for (int row = 0; row < 10; row++) {
            for (int col = 0; col < 10; col++) {
                if (!(row == x && col == y)) {
                    System.out.print("o");
                } else {
                    System.out.print(".");
                }
            }
            System.out.println("o");
        }
    }

    //MODIFIES: this
    //EFFECTS; sets color of pencil based on user
    private void pencilColor() {
        PencilTool pencil = new PencilTool();
        System.out.println("Enter color: ");
        String color = input.next();
        pencil.setColor(Color.getColor(color)); // I currently cannot print out the color of the pencil without graphics
        System.out.println("The color of your pencil is now: " + color);

    }

    //MODIFIES: this
    //EFFECTS; sets size of pencil based on user
    private void pencilSize() {
        PencilTool pencil = new PencilTool();
        System.out.println("Enter pencil size: ");
        int amount = input.nextInt();

        if (amount < 0) {
            System.out.println("Unable to process negative number");
        } else {
            pencil.setSize(amount); //Cannot show actual eraser size as no graphics have been implemented
            System.out.println("Your pencil size is " + amount);
        }
    }

    //MODIFIES: this
    //EFFECTS; sets size of pencil based on user
    private void eraserSize() {
        EraserTool eraser = new EraserTool();
        System.out.println("Enter eraser size: ");
        int amount = input.nextInt();

        if (amount < 0) {
            System.out.println("Unable to process negative number");
        } else {
            eraser.setSize(amount); //Cannot show actual eraser size as no graphics have been implemendes
            System.out.println("Your eraser size is " + amount);
        }
    }

    //EFFECTS; prints out a point on the canvas that the user has used the eraser on
    //                  Currently, both the eraser and pencil produce the same color dot as you
    //                   cannot specifically change the console text color using variables.
    private void useEraser() {
        Canvas canvas = new Canvas();
        System.out.println("Enter x coordinate value: ");
        int xpos = input.nextInt();
        System.out.println("Enter y coordinate value: ");
        int ypos = input.nextInt();

        if (xpos < 0 || ypos < 0) {
            System.out.println("Unable to process negative number");
        } else {
            canvas.getPixel(xpos, ypos);// These will currently only open a java window but nothing will happen
                                                        //   because graphics has not been implemented yet.
            printCanvas(xpos, ypos);
        }
    }

    //EFFECTS; prints out a point on the canvas that the user has used the pencil on
    //                  Currently, both the eraser and pencil produce the same color dot as you
    //                   cannot specifically change the console text color using variables.
    private void usePencil() {
        Canvas canvas = new Canvas();
        System.out.println("Enter x coordinate value: ");
        int xpos = input.nextInt();
        System.out.println("Enter y coordinate value: ");
        int ypos = input.nextInt();

        if (xpos < 0 || ypos < 0) {
            System.out.println("Unable to process negative number");
        } else {
            canvas.getPixel(xpos, ypos);// These will currently only open a java window but nothing will happen
                                                        //   because graphics has not been implemented yet.
            printCanvas(xpos, ypos);
        }
    }
}
