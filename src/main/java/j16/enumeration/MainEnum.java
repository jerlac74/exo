package j16.enumeration;

import java.text.MessageFormat;

public class MainEnum {
    public static void main(String[] args) {
        for (Semaine day: Semaine.values()) {
            System.out.println(MessageFormat.format("day:{0} - we: {1} - smiley: {2}",day, day.isWeekend(), day.getSmiley()));
        }

        System.out.println("Jeudi avant samedi ?");
        System.out.println(Semaine.JEUDI.ordinal());
        System.out.println(Semaine.SAMEDI.ordinal());

        if(Semaine.JEUDI.ordinal()< Semaine.SAMEDI.ordinal())
            System.out.println("Jeudi est bien avant Samedi");
        else
            System.out.println("Jeudi n'est pas avant Samedi");

    }
}
