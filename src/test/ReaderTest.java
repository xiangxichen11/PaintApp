import model.Canvas;
import model.Pixel;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import persistence.Reader;

import java.awt.*;
import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
// Class that tests the Reader Class
public class ReaderTest {
    private static final String TEST_FILE = "./data/bigDaddy.JSON";
    private Canvas canvas;
    private Reader reader;

    @BeforeEach
    void runBefore(){
        canvas = new Canvas();
        reader = new Reader();
    }

    @Test
    void testReadObject(){
        try{
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
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



    @Test
    void testIOException() {
        try {
            Reader.readObject(new File("./path/does/not/exist/testAccount.txt"));
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
