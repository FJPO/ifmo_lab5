package Lab5.Commands;

import Lab5.Source.LabWork;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Класс с методом, удаляющим элемент по его индексу
 */
public class RemoveAtIndex implements Executable{
    @Override
    public boolean isDesired(String name) {
        return "REMOVE_AT".equals(name.toUpperCase());
    }

    @Override
    public boolean execute(ArrayList<LabWork> list, String arg) {
        if ((arg != null) && (!arg.equals(""))) {
            list.remove(Integer.parseInt(arg));
            return true;
        } else{
            System.out.println("Введите индекс");
            return new RemoveAtIndex().execute(list, new Scanner(System.in).nextLine());
        }

    }
}
