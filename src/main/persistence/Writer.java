package persistence;

import model.Canvas;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Writer {
    private FileWriter fileWriter;

    public Writer(File file) throws IOException {
        fileWriter = new FileWriter(file);
    }

    public void write(String string) throws IOException {
        fileWriter.write(string);
    }

    public void closeWriter() throws IOException {
        fileWriter.close();

    }


}
