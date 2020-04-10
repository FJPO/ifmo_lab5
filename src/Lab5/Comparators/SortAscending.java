package Lab5.Comparators;

import Lab5.Source.LabWork;

/**
 * Реализует сортировку по возрастанию (сортирует по алфавиту)
 */
public class SortAscending implements Sortable {

    @Override
    public int sort(LabWork lab, LabWork lab2) {
        return lab.getName().compareTo(lab2.getName());
    }
}
