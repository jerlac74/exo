package j13.staticsample;

public class FactorielleExceptionInco extends FactorielleException{
    public FactorielleExceptionInco() {
        super("incohérence de calcul !");
    }

    public FactorielleExceptionInco(String message) {
        super(message);
    }
}
