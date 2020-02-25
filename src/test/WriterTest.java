import model.Canvas;
import model.Pixel;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import persistence.Reader;
import persistence.Writer;

import java.awt.*;
import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WriterTest {
    private static final String TEST_FILE = "./data/bigDaddy.JSON";
    Writer writer;
    Canvas canvas;

    @BeforeEach
    public void runBefore() throws IOException {
        writer = new Writer(new File(TEST_FILE));
        canvas = new Canvas();
    }

    @Test
    void testWrite() throws IOException {
        writer.write(canvas.export());
        writer.closeWriter();

        try {
            JSONObject object = Reader.readObject(new File(TEST_FILE));
            for (int row = 0; row < 10; row++) {
                JSONObject rowObj = (JSONObject) object.get(String.valueOf(row));
                for (int col = 0; col < 10; col++) {
                    Pixel pixel = new Pixel(Color.white);
                    canvas.getBitmap()[row][col] = pixel;
                    Long rgb = (Long) rowObj.get(String.valueOf(col));
                    Color color = new Color(rgb.intValue());
                    pixel.setColor(color);
                    assertEquals(color, pixel.getPixelColor());
                }
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}