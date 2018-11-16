package Parser;

import Exceptions.InvalidSearchParameters;

import java.util.ArrayList;

public class Sections {
    private ArrayList<Section> sections;

    public void append(Section section) {
        sections.add(section);
    }

    Sections() {
        sections = new ArrayList<>(10);
    }

    public Section get(Integer index) {
        return sections.get(index);
    }

    public Parameter findParam(String sectionName, String paramName) throws InvalidSearchParameters {
        try {
            for (Section section : sections) {
                if (section.getName().equals(sectionName)) {
                    for (Parameter parameter : section.getParameters()) {
                        if (parameter.getName().equals(paramName))
                            return parameter;
                    }
                }
            }
        } catch (NullPointerException e) {
            throw new InvalidSearchParameters("Invalid Search Parameters", e);
        }
        return null;
    }
    public ArrayList<Section> getSections() {
        return sections;
    }
}
