package Parser;

import Exceptions.FormatFileException;
import Exceptions.FormatTypeException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class Parser {
    private Sections sections;
    private Integer indexOfCurrentSection = -1;

    public Sections getSections() {
        return sections;
    }

    public void parsing(ArrayList<String> file) throws FormatTypeException {
        for (String line : file) {
            if (line.contains("[") && line.contains("]") && !line.substring(0, line.indexOf("[")).contains(";")) {
                try {
                    String sectionName = line.substring(line.indexOf("[") + 1, line.indexOf("]"));
                    if (sectionName.contains(" ") || !sectionName.matches("[a-zA-Z0-9_]+"))
                        throw new FormatTypeException("Format type exception");
                    sections.append(new Section(sectionName));
                } catch (FormatTypeException e) {
                    e.printStackTrace();
                }
                indexOfCurrentSection += 1;
            } else if (line.charAt(0) != ';') {
                try {
                    String parameterName = line.substring(0, line.indexOf("=") - 1);
                    String parameterValue = line.substring(line.indexOf("=") + 2, line.contains(";") ? line.indexOf(";") - 1 : line.length());
                    String tempParamValue = parameterValue.replace(".", "0");
                    if (parameterValue.matches("[0-9]+")) {
                        Integer value = Integer.valueOf(parameterValue);
                        sections.get(indexOfCurrentSection).append(new Parameter<Integer>(parameterName, value));
                    } else if (tempParamValue.matches("[0-9]+")) {
                        Double value = Double.valueOf(parameterValue);
                        sections.get(indexOfCurrentSection).append(new Parameter<Double>(parameterName, value));
                    } else if (tempParamValue.matches("[0-9]+")) {
                        sections.get(indexOfCurrentSection).append(new Parameter<String>(parameterName, parameterValue));
                    } else {
                        throw new FormatTypeException("Format type exception");
                    }
                } catch (FormatTypeException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}

