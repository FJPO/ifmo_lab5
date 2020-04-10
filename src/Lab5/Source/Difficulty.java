package Lab5.Source;

import Lab5.FileInteraction.XmlTools;
import Lab5.FileInteraction.Xml_Interchangeable;

public enum Difficulty implements Xml_Interchangeable {
    VERY_EASY("Очень просто"),
    NORMAL("Средне"),
    VERY_HARD("Очень сложно"),
    INSANE("Невозможно"),
    TERRIBLE("Ужасно");

    private String name;
    Difficulty(String name){this.name = name;}

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Сложность: " + name;
    }


    @Override
    public String createXml() {
        return XmlTools.createXmlLine("Difficulty", "\n" + this.name() + "\n");


    }



}
