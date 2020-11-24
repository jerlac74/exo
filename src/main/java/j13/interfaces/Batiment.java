package j13.interfaces;

import java.text.MessageFormat;

public class Batiment {
    int temperature;

    @Override
    public String toString() {
        return MessageFormat.format("Je suis du type {0}, la température est de :{1}", getClass().getSimpleName(), temperature);
    }
}
