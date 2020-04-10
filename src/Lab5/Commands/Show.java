package Lab5.Commands;

import Lab5.Source.LabWork;

import java.util.ArrayList;

/**
 * Класс с методом, отображающем все элекменты коллекции
 */
public class Show implements Executable{

    @Override
    public boolean isDesired(String name) {
        return "SHOW".equals(name.toUpperCase());
    }

    @Override
    public boolean execute(ArrayList<LabWork> list, String arg) {
        if (list.isEmpty()){
            System.out.println("Коллекция пуста");

        }else {
            System.out.println("Элементы ArrayList представлены ниже: ");

            for (int i = 0; i < list.size(); i++) System.out.println("\n\n№ " + i + "\n" + list.get(i));
        }
        return true;
    }
}
