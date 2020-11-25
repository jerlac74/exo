package serie1;

public class Exo2 {
    /*
    Ecrire une méthode qui permet de calculer la moyenne d'un tableau de décimaux.
    La moyenne doit être un entier arrondi à l'inférieur.
    Un tableau vide doit renvoyer une exception.

    [10, 20] -> (10+20)/2 = 15
    [11,12,13,14,15, 16] -> 13
    [] -> Exception
     */

    public static int calculerMoyenneTableau(double[] tabSrc) {
        int result = -1;
        int tempResult = 0;
        if (tabSrc != null && tabSrc.length > 0) {
            for (double val : tabSrc) {
                tempResult += val;
            }
            result = tempResult/tabSrc.length;
        }
        else{
            throw new ArithmeticException("Le tableau est vide");
        }
        return result;
    }
}
