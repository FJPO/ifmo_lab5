package Lab5.Commands;

import Lab5.Source.LabWork;

import java.util.ArrayList;

/**
 * Класс с методом, выводящем информацию о коллекции
 */
public class Info implements Executable {

    @Override
    public boolean isDesired(String name) {
        return "INFO".equals(name.toUpperCase());
    }

    @Override
    public boolean execute(ArrayList<LabWork> list, String arg) {
        if(list == null || list.size()==0){
            System.out.println("Путсая коллекция");
            return true;
        }
        java.time.LocalDateTime minDate = list.get(0).getCreationDate();
        for(LabWork labWork : list)
            if (labWork.getCreationDate().compareTo(minDate)<0) minDate = labWork.getCreationDate();

        System.out.println("Коллекция из элементов LabWork\nСоздана " + minDate +"\nРазмер: " +list.size()+ " элементов");
        return true;
    }
}
