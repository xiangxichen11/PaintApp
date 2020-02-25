package persistence;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
// A writer that can write a paint file
public class Writer {
    private FileWriter fileWriter;

    // EFFECTS: constructs a writer that writes data to file
    public Writer(File file) throws IOException {
        fileWriter = new FileWriter(file);
    }
    //MODIFIES: this
    //EFFECTS: writes the file that is about to be saved
    public void write(String string) throws IOException {
        fileWriter.write(string);
    }
    //MODIFIES: this
    //EFFECTS: closes the writer
    public void closeWriter() throws IOException {
        fileWriter.close();

    }


}
