package Lab5.Source;

import Lab5.FileInteraction.XmlTools;
import Lab5.FileInteraction.Xml_Interchangeable;

public class Coordinates implements Xml_Interchangeable{

    private Float x; //Максимальное значение поля: 226, Поле не может быть null
    private int y; //Максимальное значение поля: 668

    public Coordinates(Float x, int y){
        if (x == null) throw new IllegalArgumentException();
        this.x = x;
        this.y = y;
    }

    //getters
    public Float getX(){
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return String.format("Координаты:(%.1f; %d)", x, y);
    }

    @Override
    public String createXml() {
        return XmlTools.createXmlLine("Coordinates",
                "\n" + XmlTools.createXmlLine("x", String.valueOf(x)) +
                        XmlTools.createXmlLine("y", String.valueOf(y)));
    }

}

