package j13.staticsample;

public class Factorielle {
    //si on déclare FactorielleException héritant de RuntimeException, on n'a pas besoin de déclarer throws dans cette méthode.
    public static int calculer(int n) throws FactorielleExceptionInco, FactorielleExceptionNombreNeg {
        int result = 1;
        int prev;

        if (n < 0)
            throw new FactorielleExceptionNombreNeg();

        for (int i = 1; i <= n; i++) {
            prev = result;
            result *= i;

            if (result / i != prev)
                throw new FactorielleExceptionInco();
        }
        //retourne 1 si n=0 car result est initialisé à 1
        return result;
    }
}
