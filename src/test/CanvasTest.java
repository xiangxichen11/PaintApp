import model.Canvas;
import model.Pixel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ui.tools.EraserTool;
import ui.tools.PencilTool;
import ui.tools.Tool;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CanvasTest {
    Canvas canvas;
    Tool pencil;
    Tool eraser;


    @BeforeEach
    public void runBefore() {
        canvas = new Canvas();
        pencil = new PencilTool();
        eraser = new EraserTool();

    }
    @Test
    void testConstructor(){
        Canvas newPixel = new Canvas();
        assertEquals(Color.white, canvas.getPixel(0,0).getPixelColor());
        assertEquals(Color.white, canvas.getPixel(343,183).getPixelColor());
        assertEquals(1920*1080, canvas.getSize());
    }


    @Test
    void testDraw(){
        canvas.draw(pencil, 100, 100);
        assertEquals(Color.black, canvas.getPixel(100, 100).getPixelColor());
        canvas.draw(eraser,100,100);
        assertEquals(Color.white, canvas.getPixel(100,100).getPixelColor());
    }

}




