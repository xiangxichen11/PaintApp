import model.Canvas;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ui.tools.EraserTool;
import ui.tools.PencilTool;
import ui.tools.Tool;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;


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
        assertEquals(Color.white, canvas.getPixel(0,0).getPixelColor());
        assertEquals(Color.white, canvas.getPixel(2,2).getPixelColor());
    }


    @Test
    void testPencilDraw(){
        canvas.draw(pencil, 10, 10);
        assertEquals(Color.black, canvas.getPixel(10, 10).getPixelColor());
        canvas.draw(eraser,10,10);
        assertEquals(Color.white, canvas.getPixel(10,10).getPixelColor());
    }

    @Test
    void testEraserDraw(){
        assertNotEquals("pencil", eraser.description);
        assertNotEquals(Color.black, canvas.getPixel(10, 10).getPixelColor());
        assertEquals("eraser", eraser.description);
        canvas.draw(eraser, 10, 10);
        assertEquals(Color.white,  canvas.getPixel(10, 10).getPixelColor());
    }

    @Test
    void testDrawNotPencilOrEraser(){
        eraser.description = "pen";
        canvas.draw(eraser, 10, 10);
        assertNotEquals(Color.black, canvas.getPixel(10, 10).getPixelColor());
    }

    @Test
    void testGetBitmap(){
        canvas.getBitmap()[0][0].setColor(Color.blue);

        assertEquals(Color.blue, canvas.getBitmap()[0][0].getPixelColor());
    }

    @Test
    void testExport(){
        Canvas canvas2 = new Canvas();
        canvas2.export().toString();
        canvas.export().toString();

        assertEquals(canvas2.export().toString(), canvas.export().toString());
    }

}




