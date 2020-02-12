import model.Pixel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PixelTest {
    Pixel pixel;

    @BeforeEach
    void runBefore(){
        pixel = new Pixel(Color.GREEN);
    }

    @Test
    void testConstructor(){
        assertEquals(Color.GREEN, pixel.getPixelColor());
    }

    @Test
    void testGetPixelColor(){
        pixel.setColor(Color.CYAN);
        assertEquals(Color.CYAN, pixel.getPixelColor());
    }
}
