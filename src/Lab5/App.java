package Lab5;

import Lab5.Commands.CommandKeeper;
import Lab5.FileInteraction.FileInteractor;
import Lab5.Source.LabWork;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Основной класс программы
 */
public class App {

    final String mode = "standard";
    private FileInteractor fileInteractor;
    private Scanner scanner = new Scanner(System.in);
    private ArrayList<LabWork> elementsList;

    /**
     *
     * @param path Путь, в котором хранятся элементы коллекции. Защищен от ошибок
     */
    public App(String path){
        for(;;) {
            try {
                FileInteractor.init(path);
                this.fileInteractor = FileInteractor.getInstance();
                elementsList = fileInteractor.readData();
            }catch(IOException e){
                System.out.println("Ошибка работы с файлом\nВведите название файла");
                path = scanner.nextLine();
                continue;
            }
            break;
        }

    }

    /**
     * Запускаает программу
     */
    public void start(){
        System.out.println("Вещественные числа вводятся через точку (12.32), для получения списка команд введите help," +
                " команды регистронечувствительны");
        for(;;){
            System.out.println("Ожидает команд");
            String line = scanner.nextLine();
            if(!line.contains(" ")){
                CommandKeeper.execute(line, elementsList, "", mode);
            }else {
                CommandKeeper.execute(String.valueOf(line.toCharArray(), 0, line.indexOf(" ")), elementsList,
                        String.valueOf(line.toCharArray(), line.indexOf(" ") + 1,
                                line.length() - line.indexOf(" ") - 1), mode);
            }

        }
    }

}
