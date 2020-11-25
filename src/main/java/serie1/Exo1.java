package serie1;

public class Exo1 {
    /*
    Soit un nombre indéfini d'entiers, retourner la somme des carrés de ces entiers :
    [1,2,3] = 1²+2²+3² = 14
    [14,9,-9,1,4,3] -> 384
    Un tableau vide doit renvoyer -1
    [] -> -1
     */

    public static long calculeSommeDesCarres(int[] tabSrc) {
        long result = -1;
        long tempResult = 0;
        if (tabSrc != null && tabSrc.length > 0) {
            for (int val : tabSrc) {
                tempResult += val * val;
            }
            result = tempResult;
        }
        return result;
    }
}
