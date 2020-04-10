package Lab5.Commands;

import Lab5.Source.*;

import java.util.ArrayList;

/**
 * Класс с методом, добавляющим элемент в коллекцию из файла
 */

public class AddElementFromScript implements Executable {

    @Override
    public boolean isDesired(String name) {
        return "ADD".equals(name.toUpperCase());
    }

    @Override
    public boolean execute(ArrayList<LabWork> list, String arg) {

        String[] args = arg.split(" ");

        for (Difficulty dif : Difficulty.values())
            if (dif.getName().toUpperCase().equals(args[6])) args[6] = dif.name();
        Difficulty tempoDif;
        if (args[6].equals("")) tempoDif = null;
        else tempoDif = Difficulty.valueOf(args[6].toUpperCase());

        if( (args[0].equals("")) || (Float.parseFloat(args[1]) > 226) || ( Integer.parseInt(args[2]) > 668) ||
                ( Double.parseDouble(args[3]) < 0) || (args[7].equals("")) || (Long.parseLong(args[8]) < 0) ) return false;

        if( !(args[5].equals("")) && (Double.parseDouble(args[5]) < 0) ) return false;



        list.add(new LabWork(args[0],
                new Coordinates(Float.parseFloat(args[1]), Integer.parseInt(args[2])),
                Double.parseDouble(args[3]),
                Integer.parseInt(args[4]),
                (args[5].equals(""))?null:Double.parseDouble(args[5]),
                tempoDif,
                new Person(args[7], Long.parseLong(args[8]),
                        new Location(Float.parseFloat(args[9]),
                                Integer.parseInt(args[10]),
                                Long.parseLong(args[11])
                ))));
        return true;
    }
}
