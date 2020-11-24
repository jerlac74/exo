package j13.staticsample;

public abstract class FactorielleException extends Exception {
    public FactorielleException() {
        super();
    }

    public FactorielleException(String message) {
        super("Exception: Erreur dans le calcul d'un factoriel, détail : "+ message);
    }
}
