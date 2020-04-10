package Lab5.Commands;

import Lab5.Source.Difficulty;
import Lab5.Source.LabWork;

import java.util.ArrayList;

/**
 * Класс с методом, добавляющим элемент в коллекцию из консоли, при условии, что он превосходит по сложности ослальные элементы LabWork
 */
public class AddIfMax implements Executable {

    @Override
    public boolean isDesired(String name) {
        return "ADD_IF_MAX".equals(name.toUpperCase());
    }

    @Override
    public boolean execute(ArrayList<LabWork> list, String arg) {
        ArrayList<LabWork> tempo = new ArrayList<>();
        (new AddElement()).execute(tempo, "");

        boolean canAdd = true;
        for (LabWork labWork : list)
            if (labWork.getDifficulty().compareTo(tempo.get(0).getDifficulty()) > 0) {
                canAdd = false;
                break;
            }

        if (canAdd) list.add(tempo.get(0));
        else System.out.println("Элемент не добавлен");
        return true;
    }
}
