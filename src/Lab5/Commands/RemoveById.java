package Lab5.Commands;

import Lab5.Source.LabWork;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Класс с методом, удаляющим элемент по его id
 */
public class RemoveById implements Executable {

    @Override
    public boolean isDesired(String name) {
        return "REMOVE_BY_ID".equals(name.toUpperCase());
    }

    @Override
    public boolean execute(ArrayList<LabWork> list, String arg) {
        while (arg == null || "".equals(arg)){
            System.out.println("Введите id");
            arg = new Scanner(System.in).nextLine();
        }
        for (int i = 0; i<list.size(); i++)
            if (list.get(i).getId() == Integer.parseInt(arg)){
                list.remove(i);
                return true;
            }
        System.out.println("Элемента с таким Id не найдено");
        return false;
    }
}
