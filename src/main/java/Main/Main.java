package Main;

import Exceptions.FormatFileException;
import Exceptions.FormatTypeException;
import Exceptions.InvalidSearchParameters;
import Parser.Parser;
import Parser.FileConnection;
import Parser.Parameter;
import Parser.Section;
import Parser.Sections;

import java.io.IOException;

public class Main {
    public static void main(String[] args){

        Parser parser = new Parser();
        Integer indexOfCurrentSection = -1;
        try {
            FileConnection file = new FileConnection();
            parser.parsing(file.connect("input.ini"));
            Sections sections = parser.getSections();
            for (Section section : sections.getSections()) {
                System.out.println("[" + section.getName() + "]");
                for (Parameter parameter : section.getParameters()) {
                    System.out.println(parameter.getName() + "    " + parameter.getValue() + "    " + parameter.getValue().getClass().getName());
                }
            }
            System.out.println(sections.findParam("COMMON", "StatisterTimeMs").getValue());
            System.out.println(sections.findParam("ADC_DEV", "Driver").getValue());
        } catch (IOException | FormatFileException | FormatTypeException | InvalidSearchParameters e){
            e.printStackTrace();
        }

    }

}
