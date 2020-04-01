import model.Canvas;
import model.Pixel;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import persistence.Reader;
import persistence.Writer;
import ui.CanvasPanel;
import ui.Frame;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

// Class that tests the Writer Class
public class WriterTest {
    private static final String PAINT_FILE = "./data/bigDaddy.JSON";
    Writer writer;
    Canvas canvas;

    @BeforeEach
    public void runBefore() throws IOException {
        writer = new Writer(new File(PAINT_FILE));
        canvas = new Canvas();
    }

    @Test
    void testWrite() throws IOException {
        writer.write(canvas.exportConsole());
        writer.closeWriter();

        try {
            JSONObject object = Reader.readObject(new File(PAINT_FILE));
            for (int row = 0; row < 10; row++) {
                JSONObject rowObj = (JSONObject) object.get(String.valueOf(row));
                for (int col = 0; col < 10; col++) {
                    Pixel pixel = new Pixel(Color.white);
                    canvas.getBitmap()[row][col] = pixel;
                    Long rgb = (Long) rowObj.get(String.valueOf(col));
                    Color color = new Color(rgb.intValue());
                    pixel.setColor(color);
                }
            }
        } catch (ParseException | IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("loaded canvas");
        }
    }
}