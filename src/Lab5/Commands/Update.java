package Lab5.Commands;

import Lab5.Source.LabWork;

import java.lang.management.ClassLoadingMXBean;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Класс с методом, переписывающем элемент коллекции по id
 */
public class Update implements Executable {

    @Override
    public boolean isDesired(String name) {
        return "UPDATE".equals(name.toUpperCase());
    }

    @Override
    public boolean execute(ArrayList<LabWork> list, String arg) {

        while (arg == null || "".equals(arg)){
            System.out.println("Введите id");
            arg = new Scanner(System.in).nextLine();
        }

        for (LabWork labWork : list)
            if ((labWork.getId() == Integer.parseInt(arg))){

                int id = labWork.getId();
                int position = list.indexOf(labWork);
                (new AddElement()).execute(list, "");
                list.get(list.size()-1).setId(id);
                list.set(position, list.get(list.size()-1));
                list.remove(list.size()-1);
                return true;
            }

        return false;
    }
}
