package Lab5.Comparators;

import Lab5.Source.LabWork;

/**
 * Реализует сортировку по убыванию (сортирует по алфавиту)
 */
public class SortDescending implements Sortable {
    @Override
    public int sort(LabWork lab, LabWork lab2) {
        return lab2.getName().compareTo(lab.getName());
    }
}
