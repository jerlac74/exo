package j13.staticsample;

public class Dictionnaire {
    //un singleton
    private static Dictionnaire unique = new Dictionnaire();

    private Dictionnaire() {
    }

    public static Dictionnaire getInstance() {
        if (unique == null)
            unique = new Dictionnaire();
        return unique;
    }
}
