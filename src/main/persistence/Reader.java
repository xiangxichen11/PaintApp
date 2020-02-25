package persistence;

import model.Canvas;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Reader {

    public static JSONObject readObject(File file) throws IOException, ParseException {
        JSONObject jsonObject = (JSONObject) readFile(file);
        return jsonObject;
    }

    public static Object readFile(File file) throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        JSONObject obj = (JSONObject) parser.parse(new FileReader(file));
        return obj;
    }
}


