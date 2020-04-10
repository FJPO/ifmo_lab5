package Lab5.Commands;

import Lab5.Source.LabWork;

import java.util.ArrayList;

/**
 * Класс с методом, отчищающем коллекцию
 */
public class Clear implements Executable {

    @Override
    public boolean isDesired(String name) {
        return "CLEAR".equals(name.toUpperCase());
    }

    @Override
    public boolean execute(ArrayList<LabWork> list, String arg) {
        list.clear();
        return true;
    }
}
