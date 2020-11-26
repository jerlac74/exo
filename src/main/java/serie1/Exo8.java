package serie1;

public class Exo8 {
    /*
     Soit un tableau d'entiers relatifs. Trouvez le maximum de la multiplication de deux entiers adjacents.

    [1, 2, 3] -> 6
    [9, 5, 10, 2, 24, -1, -48] -> 50
    [-23, 4, -5, 99, -27, 329, -2, 7, -921] -> -14
    Le cas du tableau vide n'est pas à prendre en compte.
     */

    public static int findMaxMultiplication(int[] tabInput) {
        int result=Integer.MIN_VALUE;

        if (tabInput != null && tabInput.length > 0) {

            int lengthGlobal = tabInput.length;
            int currRes = 0;

            for (int i = 1; i < lengthGlobal; i++) {
                currRes = tabInput[i - 1] * tabInput[i];
                if (currRes > result)
                    result = currRes;
            }
        }
        else
            result=0;

        return result;
    }
}
