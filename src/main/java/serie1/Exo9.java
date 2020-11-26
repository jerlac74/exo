package serie1;

import java.util.Arrays;
import java.util.Collections;
import java.util.TreeSet;

public class Exo9 {
    /*
    Soit un tableau d'entiers positifs compris entre 0 et 9, trouvez chiffre minimum résultat de la combinaison des numéros du tableau.
    Les doublons sont à ignorer.

    [1, 3, 1] -> 13
    [5, 7, 5, 9, 7] -> 579
    [9, 1, 3, 1, 7, 4, 6, 6, 7] -> 134679
     */

    public static int findCombinaisonMin(int[] tabInput) {
        StringBuilder result = new StringBuilder();

        if (tabInput != null && tabInput.length > 0) {
            TreeSet<Integer> treeSet = new TreeSet<>();
            for (int i : tabInput) {
                treeSet.add(i);
            }
            /*
            Initialisation possible avec un Integer[] comme ceci:
            TreeSet<Integer> treeSetTest = new TreeSet<>();
            Integer[] testInt =new Integer[]{15,25,36};
            treeSetTest.addAll(Arrays.asList(testInt));
             */

            int size =treeSet.size();
            for (int i = 0; i < size; i++) {
                result.append(treeSet.pollFirst());
            }
        }

        String resultInt= result.toString();
        if(resultInt.length()>0)
            return Integer.parseInt(resultInt);

        return 0;
    }
}
