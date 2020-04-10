package Lab5.Commands;

import Lab5.Source.*;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Класс с методом, добавляющим элемент в коллекцию из консоли
 */
public class AddElement implements Executable {

    @Override
    public boolean isDesired(String name) {
        return "ADD".equals(name.toUpperCase());
    }

    @Override
    public boolean execute(ArrayList<LabWork> list, String arg) {

        Scanner scanner;
        String[] line;
        String labName = null;
        Coordinates coordinates = null;
        Double minimalPoint = null;
        Integer tunedInWorks = null;
        Double averagePoint = null;
        Difficulty difficulty = null;
        Person author;
        String authorName = null;
        Long authorHeight = null;

        int errorTag = 0;
        for(;;) {
            try {
                scanner = new Scanner(System.in);
                if (errorTag == 0) {
                    System.out.print("Введите имя: ");
                    labName = scanner.nextLine();
                    if(labName.equals("")) {
                        System.out.println("Имя не может быть null");
                        continue;
                    }
                    ++errorTag;
                } else System.out.println("Имя: " + labName);

                if (errorTag == 1) {
                    System.out.print("\nВведите координаты x и y через пробел: ");
                    line = scanner.nextLine().split(" ");
                    if (Integer.parseInt(line[1]) > 668){
                        System.out.println("Поле y не может быть больше 668");
                        continue;
                    }
                    if(Float.parseFloat(line[0]) > 226){
                        System.out.println("Поле не может быть больше 226");
                        continue;
                    }
                    coordinates = new Coordinates(Float.parseFloat(line[0]), Integer.parseInt(line[1]));
                    ++errorTag;
                } else System.out.println(coordinates);

                if (errorTag == 2) {
                    System.out.print("\nВведите минимальный балл: ");
                    minimalPoint = Double.parseDouble(scanner.nextLine());
                    if(minimalPoint <= 0){
                        System.out.println("Поле не может быть меньше нуля");
                        minimalPoint = null;
                        continue;
                    }
                    ++errorTag;
                } else System.out.println("Минимальный балл: " + minimalPoint);

                if (errorTag == 3) {
                    System.out.print("\nВведите значение поля tunedInWorks: ");
                    tunedInWorks = Integer.parseInt(scanner.nextLine());
                    ++errorTag;
                } else System.out.println("tunedInworks: " + tunedInWorks);

                if (errorTag == 4) {
                    System.out.print("\nВведите средний балл: ");
                    String tempoLine = scanner.nextLine();
                    if(!tempoLine.equals("")) {
                        averagePoint = Double.parseDouble(tempoLine);
                        if (averagePoint <= 0) {
                            System.out.println("Поле не может быть меньше нуля");
                            averagePoint = null;
                            continue;
                        }
                    }
                    ++errorTag;
                } else System.out.println("Средний балл: " + averagePoint);

                if (errorTag == 5) {
                    System.out.print("\nВведите сложность: (на английском)\n");
                    for (Difficulty dif : Difficulty.values()) System.out.println(dif + " " + dif.name());
                    String tempo = scanner.nextLine();
                    if (!tempo.equals(""))  difficulty = Difficulty.valueOf(tempo.toUpperCase());
                    ++errorTag;
                } else System.out.println(difficulty);

                if (errorTag == 6) {
                    System.out.print("\nВведите имя автора: ");
                    authorName = scanner.nextLine();
                    if (authorName.equals("")){
                        System.out.println("Имя не может быть null");
                        authorName = null;
                        continue;
                    }
                    ++errorTag;
                } else System.out.println("Имя автора: " + authorName);

                if (errorTag == 7) {
                    System.out.print("\nВведите рост автора: ");
                    authorHeight = Long.parseLong(scanner.nextLine());
                    if (authorHeight < 0){
                        System.out.println("Рост не сожет быть меньше нуля");
                        authorHeight = null;
                        continue;
                    }
                    ++errorTag;
                } else System.out.println("Рост автора: " + authorHeight);

                if (errorTag == 8) {
                    System.out.print("\nВведите местонахождение автора(x, y, z через пробел): ");
                    line = scanner.nextLine().split(" ");


                    author = new Person(authorName, authorHeight,
                            new Location(Float.parseFloat(line[0]), Integer.parseInt(line[1]), Long.parseLong(line[2])));

                    list.add(new LabWork(labName, coordinates, minimalPoint, tunedInWorks, averagePoint, difficulty, author));
                    errorTag = 0;
                    break;

                }
            } catch (Exception e) {
                System.out.println("\nОшибка ввода!\n");
            }
        }

        return true;
    }

}
