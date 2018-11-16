import Exceptions.FormatFileException;
import Exceptions.FormatTypeException;
import Parser.FileConnection;
import Parser.Parser;
import Parser.Sections;
import org.junit.Test;

import java.io.IOException;

public class ParserTest {

    @Test(expected = FormatTypeException.class)
    public void parsing() throws FormatTypeException, IOException{
        Parser parser = new Parser();
        FileConnection file = new FileConnection();
        try {
            parser.parsing(file.connect("//java/wrongType.ini"));
        }catch (FormatFileException | IOException e){
            throw new FormatTypeException("Format Type Exception");
        }
        Sections sections = parser.getSections();
    }

    @Test
    public void parsing2() throws FormatTypeException, IOException{
        Parser parser = new Parser();
        FileConnection file = new FileConnection();
        try {
            parser.parsing(file.connect("//java/input.ini"));
        }catch (FormatFileException | IOException e){
            throw new FormatTypeException("Format Type Exception");
        }
        Sections sections = parser.getSections();
    }
}