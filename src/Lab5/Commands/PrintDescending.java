package Lab5.Commands;

import Lab5.Comparators.SortDescending;
import Lab5.Source.LabWork;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Класс с методом, выводящим элементы коллекции в порядеке убывания по алфавиту (от я до а)
 */
public class PrintDescending implements Executable {

    @Override
    public boolean isDesired(String name) {
        return "PRINT_DESCENDING".equals(name.toUpperCase());
    }

    @Override
    public boolean execute(ArrayList<LabWork> list, String arg) {
        ArrayList<LabWork> tempoList = new ArrayList<>(list);
        tempoList.forEach(labWork -> labWork.setSortBehavior(new SortDescending()));
        Collections.sort(tempoList);
        (new Show()).execute(tempoList, "");
        return true;
    }
}
