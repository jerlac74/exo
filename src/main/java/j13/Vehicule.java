package j13;

import java.text.MessageFormat;

public class Vehicule {
    private int nombreRoues;

    public Vehicule(int nombreRoues) {
        this.nombreRoues = nombreRoues;
    }

    public void direBonjour() {
        char s = ' ';
        if (this.nombreRoues > 1)
            s = 's';
        System.out.println("Bonjour, je suis un véhicule à " + this.nombreRoues + " roue" + s);
    }

    @Override
    public String toString() {
        char s = ' ';
        if (this.nombreRoues > 1)
            s = 's';
        return MessageFormat.format("Vehicule.toString'{}' \"Bonjour, je suis un véhicule à {0} roue{1}\"", this.nombreRoues, s);
    }
}
