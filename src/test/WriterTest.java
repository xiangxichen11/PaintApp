import model.Canvas;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import persistence.Writer;

import java.io.File;
import java.io.IOException;

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


    }
}
