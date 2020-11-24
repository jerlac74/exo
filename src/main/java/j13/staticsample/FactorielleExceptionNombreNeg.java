package j13.staticsample;

public class FactorielleExceptionNombreNeg extends FactorielleException{
    public FactorielleExceptionNombreNeg() {
        super("Nombre négatif en entrée !");
    }

    public FactorielleExceptionNombreNeg(String message) {
        super(message);
    }
}
