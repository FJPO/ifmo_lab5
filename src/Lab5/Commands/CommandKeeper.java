package Lab5.Commands;

import Lab5.Source.LabWork;

import java.util.ArrayList;

/**
 * Класс, через который происходит работа с командами
 */
public class CommandKeeper {
    private static ArrayList<Executable> commandList = new ArrayList<>();
    private static ArrayList<Executable> standardCommands = new ArrayList<>();
    private static ArrayList<Executable> scriptCommands = new ArrayList<>();


    static {
        standardCommands.add(new Show());
        standardCommands.add(new AddElement());
        standardCommands.add(new RemoveAtIndex());
        standardCommands.add(new ExecuteScript());
        standardCommands.add(new AddIfMax());
        standardCommands.add(new Clear());
        standardCommands.add(new Exit());
        standardCommands.add(new FilterGreaterThanDifficulty());
        standardCommands.add(new Help());
        standardCommands.add(new Info());
        standardCommands.add(new PrintAscending());
        standardCommands.add(new PrintDescending());
        standardCommands.add(new RemoveById());
        standardCommands.add(new Save());
        standardCommands.add(new Shuffle());
        standardCommands.add(new Update());

        scriptCommands.add(new Show());
        scriptCommands.add(new AddElementFromScript());
        scriptCommands.add(new RemoveAtIndex());
        scriptCommands.add(new ExecuteScript());
        scriptCommands.add(new AddIfMaxFromScript());
        scriptCommands.add(new Clear());
        scriptCommands.add(new Exit());
        scriptCommands.add(new FilterGreaterThanDifficulty());
        scriptCommands.add(new Help());
        scriptCommands.add(new Info());
        scriptCommands.add(new PrintAscending());
        scriptCommands.add(new PrintDescending());
        scriptCommands.add(new RemoveById());
        scriptCommands.add(new Save());
        scriptCommands.add(new Shuffle());
        scriptCommands.add(new UpdateFromScript());


    }



    /**
     * Выполняет команду
     * @param commandName String-название команды
     * @param list ArrayList элементов LabWork, с которым мы работаем
     * @param arg Аргумент, полученный из командной строки
     * @return true или false в зависимости от того, выполнена ли команда правильно
     */
    public static boolean execute(String commandName, ArrayList<LabWork> list, String arg, String mode){

        if (mode.toUpperCase().equals("SCRIPT")) commandList = scriptCommands;
        else commandList = standardCommands;

        for(Executable command : commandList){
            if (command.isDesired(commandName)){
                try {
                    if (command.execute(list, arg)) {
                        System.out.println("Команда " + commandName + " выполнена");
                        return true;
                    } else {
                        System.out.println("Команда " + commandName + " не исполнена");
                        return false;
                    }
                }catch (Exception e){
                    System.out.println("Ошибка в выполнении программы");
                    return false;
                }
            }
        }
        System.out.println("Команда не найдена");
        return false;
    }

    public static boolean isCommandAvailable(String name){
        for (Executable command : commandList)
            if (command.isDesired(name)) return true;
        return false;
    }



}
