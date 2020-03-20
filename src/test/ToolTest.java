import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ui.tools.EraserTool;
import ui.tools.PencilTool;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;


public class ToolTest {
    PencilTool pencil;
    EraserTool eraser;


    @BeforeEach
    public void runBefore(){
        pencil = new PencilTool();
        eraser = new EraserTool();
    }

    @Test
    void testIsToolActive(){
        pencil.activateTool();

        assertTrue(pencil.isToolActive());
        assertFalse(eraser.isToolActive());
        pencil.deactivateTool();
        assertFalse(pencil.isToolActive());
        eraser.activateTool();
        assertTrue(eraser.isToolActive());
    }

    @Test
    void testPencilColor(){
        pencil.setColor(Color.black);

        assertEquals(Color.black, pencil.getColor());
    }

    @Test
    void testToolSize(){
        pencil.setSize(1);
        eraser.setSize(1);

        assertEquals(1, pencil.getSize());
        assertEquals(1, eraser.getSize());
    }

}
