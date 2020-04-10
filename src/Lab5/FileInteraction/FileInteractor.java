package Lab5.FileInteraction;

import Lab5.Source.LabWork;

import java.io.*;
import java.util.ArrayList;

/**
 Класс отвечает за работу с файлом
 */
public class FileInteractor {

    private String path;
    private static FileInteractor instance = null;

    private FileInteractor(String path) throws IOException{
        this.path = path;
        File f = new File(path);
        if (!f.exists()){
            throw new IOException();
        }
    }

    /**
     * Инициализирует FileInteractor
     * @param path Путь с котором будет работать программа
     * @throws IOException Если путь не найден, бросает IOException
     */
    public static void init(String path) throws IOException{
        instance = new FileInteractor(path);
    }

    /**
     * Возвращает инициализированный FileInteractor
     * @return элемент класса FileInteractor
     */
    public static FileInteractor getInstance(){
        if (instance == null) throw new NullPointerException();
        return instance;
    }

    /**
     * Извлекает коллекцию элементов LabWork из файла
     * @return ArrayList из элементов LabWork
     * @throws IOException если во время чтения файла произошла ошибика
     */
    public ArrayList<LabWork> readData() throws IOException{
        if (new File(path).length() == 0) return new ArrayList<LabWork>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            ArrayList<LabWork> elementsList = new ArrayList<>();
            String line;
            String closeTag = "Elements";
            if ((!"<?xml version=\"1.0\" encoding=\"UTF-8\" ?>".equals(reader.readLine()) || (!"<Elements>".equals(reader.readLine())))) {
                throw new IOException();
            }

            while (!closeTag.equals(XmlTools.getTag(line = reader.readLine())))
                if (XmlTools.getTag(line).equals("LabWork")) {
                    elementsList.add(ClassesCreator.createLabWork(reader));
                }
            reader.close();
            return elementsList;
        }catch(Exception e){
            System.out.println("Ошибка чтения файла, создана пустая коллекция");
            return new ArrayList<LabWork>();
        }
    }


    /**
     * Сохраняет коллекцию в файл
     * @param elements ArrayList из жлементов LabWork
     * @throws IOException елси во время записи данных произойдет ошибка
     */
    public void writeData(ArrayList<LabWork> elements) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(path));
        writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n");
        writer.write("<Elements>\n");
        for (Object element: elements){
            writer.write(((Xml_Interchangeable)element).createXml());
        }
        writer.write("</Elements>");
        writer.close();
    }
}
