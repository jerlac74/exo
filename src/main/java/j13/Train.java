package j13;

import java.text.MessageFormat;

public class Train extends Vehicule {
    public Train() {
        super(100);
    }

    @Override
    public void direBonjour() {
        super.direBonjour();
        System.out.print(" et je fais TchooTchoo");
        System.out.println();
    }

    @Override
    public String toString() {
        return MessageFormat.format("{0} et je fais TchooTchoo", super.toString());
    }
}
