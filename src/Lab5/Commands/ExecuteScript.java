package Lab5.Commands;

import Lab5.Source.LabWork;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;


/**
 * Класс с методом, исполняющим комманды из файла
 */
public class ExecuteScript implements Executable {

    private final String mode = "SCRIPT";
    private BufferedReader bufferedReader;


    @Override
    public boolean isDesired(String name) {
        return "EXECUTE_SCRIPT".equals(name.toUpperCase());
    }

    @Override
    public boolean execute(ArrayList<LabWork> list, String arg) {

        if((arg == null)||(arg.equals(""))){
            System.out.println("Введите название файла");
            return new ExecuteScript().execute(list, new java.util.Scanner(System.in).nextLine());
        }

        if(!FileOpenedController.canOpen(arg)){
            System.out.println("Файл не может быть исполнен: возможна ошибка зацикливания");
            return false;
        }else{
            FileOpenedController.addToOpened(arg);
        }

        try {
            bufferedReader = new BufferedReader(new FileReader(arg));
        }catch(FileNotFoundException e){
            System.out.println("Такой файл не найден");
            return false;
        }


        Object[] objLines = bufferedReader.lines().toArray();
        String[] lines;
        for (int i = objLines.length-1; i > 0; i--) {
            String tempo, commandName;
            tempo = objLines[i].toString();
            if (!tempo.contains(" ")) commandName = tempo;
            else commandName = String.valueOf(tempo.toCharArray(), 0, tempo.indexOf(" "));

            if (!CommandKeeper.isCommandAvailable(commandName)) {
                objLines[i - 1] = objLines[i - 1].toString() + " " + objLines[i].toString();
                objLines[i] = null;
            }
        }



        lines = Arrays.stream(objLines).filter(Objects::nonNull).toArray(String[]::new);

        for (String currentLine : lines) {
            String commandName, commandArg;
            if (!currentLine.contains(" ")) {
                commandName = currentLine;
                commandArg = "";
            } else {
                commandName = String.valueOf(currentLine.toCharArray(), 0, currentLine.indexOf(" "));
                commandArg = String.valueOf(currentLine.toCharArray(), currentLine.indexOf(" ") + 1,
                        currentLine.length() - currentLine.indexOf(" ") - 1);
            }
            CommandKeeper.execute(commandName, list, commandArg, mode);
        }

        FileOpenedController.removeFromOpened(arg);
        return true;
    }
}
