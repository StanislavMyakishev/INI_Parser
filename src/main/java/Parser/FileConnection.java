package Parser;

import Exceptions.FormatFileException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class FileConnection {

    public FileConnection() {
    }

    public static ArrayList<String> connect(String fileName) throws FormatFileException, IOException {
        if (!(fileName.contains(".ini"))) {
            throw new FormatFileException("Incorrect file format!");
        }
        ArrayList<String> file = new ArrayList<String>();
        try {
            Files.lines(Paths.get(fileName)).forEach(file::add);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.exit(-1);
        }
        return file;
    }

}
