package Lab5.Commands;

import Lab5.Source.Difficulty;
import Lab5.Source.LabWork;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Класс с методом, выводящим элементы со соложностью больше, чем заданная
 */
public class FilterGreaterThanDifficulty implements Executable {

    @Override
    public boolean isDesired(String name) {
        return "FILTER_GREATER_THAN_DIFFICULTY".equals(name.toUpperCase());
    }

    @Override
    public boolean execute(ArrayList<LabWork> list, String arg) {
        if ((arg != null) && (!arg.equals(""))) {
            final Difficulty difficulty = Difficulty.valueOf(arg.toUpperCase());
            ArrayList<LabWork> ending = new ArrayList<>();
            list.forEach(labWork -> {
                if(labWork.getDifficulty().compareTo(difficulty)>0) ending.add(labWork);
            });
            (new Show()).execute(ending, "");
            return true;
        } else {
            System.out.println("Ввдеите сложноть (английский)");
            for(Difficulty dif: Difficulty.values()) System.out.println(dif + " " + dif.name());
            boolean tempo = new FilterGreaterThanDifficulty().execute(list, new Scanner(System.in).nextLine());
            if(!tempo) System.out.println("Неверное название");
            return tempo;
        }

    }
}
