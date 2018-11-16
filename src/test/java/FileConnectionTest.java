import Exceptions.FormatFileException;
import Parser.FileConnection;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

public class FileConnectionTest {

    @Test(expected = FormatFileException.class)
    public void connect() throws FormatFileException, IOException{
        ArrayList<String> file = FileConnection.connect("//java/wrongFormat.txt");
    }



}