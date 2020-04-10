package Lab5.Commands;

import Lab5.Source.LabWork;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Класс с методом, перемешивающем элементы в коллекции
 */
public class Shuffle implements Executable {

    @Override
    public boolean isDesired(String name) {
        return "SHUFFLE".equals(name.toUpperCase());
    }

    @Override
    public boolean execute(ArrayList<LabWork> list, String arg) {
        Collections.shuffle(list);
        return true;
    }
}
