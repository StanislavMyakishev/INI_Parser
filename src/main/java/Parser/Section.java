package Parser;

import java.util.ArrayList;

public class Section {
    private String name;
    private ArrayList<Parameter> parameters;

    Section(String name_) {
        name = name_;
        parameters = new ArrayList<>(100);
    }

    public void append(Parameter parameter) {
        parameters.add(parameter);
    }

    public String getName() {
        return name;
    }

    public ArrayList<Parameter> getParameters() {
        return parameters;
    }
}
