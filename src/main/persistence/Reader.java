package persistence;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

//A reader that can read a file
public class Reader {

    // EFFECTS: returns JSON object that has been parsed from the file. Will throw
    // IOException or ParseException if an exception is raised when opening / reading from file
    public static JSONObject readObject(File file) throws IOException, ParseException {
        JSONObject jsonObject = (JSONObject) readFile(file);
        return jsonObject;
    }

    //EFFECTS: returns object that has been read by JSONParser
    public static Object readFile(File file) throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        JSONObject obj = (JSONObject) parser.parse(new FileReader(file));
        return obj;
    }
}


