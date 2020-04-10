package Lab5.Source;

import Lab5.FileInteraction.XmlTools;
import Lab5.FileInteraction.Xml_Interchangeable;

public class Person implements Xml_Interchangeable {
    private String name; //Поле не может быть null, Строка не может быть пустой
    private long height; //Значение поля должно быть больше 0
    private Location location; //Поле не может быть null

    public Person(String name, long height, Location location){
        if (name == null || name.equals("") || height <= 0 || location == null)
            throw new IllegalArgumentException();
        this.name = name;
        this.height = height;
        this.location = location;
    }

    //getters
    public String getName() {
        return name;
    }

    public long getHeight() {
        return height;
    }

    public Location getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return String.format("Человек: Имя: %s, Рост: %d; ", name, height) + location;
    }

    @Override
    public String createXml() {
        return XmlTools.createXmlLine("Person", "\n" + XmlTools.createXmlLine("name", name) +
                XmlTools.createXmlLine("height", String.valueOf(height)) + location.createXml());
    }
}
