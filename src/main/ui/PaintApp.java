package ui;

import java.awt.*;

// Runs the program
public class PaintApp {
    //EFFECTS: main function that runs the paint app
    public static void main(String[] args) {
        Frame.getInstance().setVisible(true);
        Frame.getInstance().setPreferredSize(new Dimension(600, 600));


    }
}
