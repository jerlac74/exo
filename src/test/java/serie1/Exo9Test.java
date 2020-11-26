package serie1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class Exo9Test {
    /*
    Soit un tableau d'entiers positifs compris entre 0 et 9, trouvez le nombre minimum résultat de la combinaison des numéros du tableau.
    Les doublons sont à ignorer.

    [1, 3, 1] -> 13
    [5, 7, 5, 9, 7] -> 579
    [9, 1, 3, 1, 7, 4, 6, 6, 7] -> 134679
     */

    @Test
    @DisplayName("vérifie la conversion du texte")
    void exo9() {
        ArrayList<int[]> datas=new ArrayList<>();
        datas.add(new int[]{1,3,1});
        datas.add(new int[]{5, 7, 5, 9, 7});
        datas.add(new int[]{9, 1, 3, 1, 7, 4, 6, 6, 7});

        int[] resultats={13,579,134679};

        int turn=0;
        Assertions.assertThat(Exo9.findCombinaisonMin(datas.get(turn))).isEqualTo(resultats[turn++]);
        Assertions.assertThat(Exo9.findCombinaisonMin(datas.get(turn))).isEqualTo(resultats[turn++]);
        Assertions.assertThat(Exo9.findCombinaisonMin(datas.get(turn))).isEqualTo(resultats[turn++]);
    }

}
