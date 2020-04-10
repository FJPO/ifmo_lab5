package Lab5.Commands;

import Lab5.FileInteraction.FileInteractor;
import Lab5.Source.LabWork;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Класс с методом, сохраняющим коллекцию в файл
 */
public class Save implements Executable{

    @Override
    public boolean isDesired(String name) {
        return "SAVE".equals(name.toUpperCase());
    }

    @Override
    public boolean execute(ArrayList<LabWork> list, String arg) {
        try {
            FileInteractor.getInstance().writeData(list);
        }catch(IOException e) {
            System.out.println("Ошибка сохранения в файл");
            return false;
        }
        return true;
    }
}
