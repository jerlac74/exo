package serie1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class Exo8Test {
    /*
    Soit un tableau d'entiers relatifs. Trouvez le maximum de la multiplication de deux entiers adjacents.

    [1, 2, 3] -> 6
    [9, 5, 10, 2, 24, -1, -48] -> 50
    [-23, 4, -5, 99, -27, 329, -2, 7, -921] -> -14
    Le cas du tableau vide n'est pas à prendre en compte.
     */

    @Test
    @DisplayName("vérifie la conversion du texte")
    void exo8() {
        ArrayList<int[]> datas=new ArrayList<>();
        datas.add(new int[]{1,2,3});
        datas.add(new int[]{9, 5, 10, 2, 24, -1, -48});
        datas.add(new int[]{-23, 4, -5, 99, -27, 329, -2, 7, -921});

        int[] resultats={6,50,-14};

        int turn=0;
        Assertions.assertThat(Exo8.findMaxMultiplication(datas.get(turn))).isEqualTo(resultats[turn++]);
        Assertions.assertThat(Exo8.findMaxMultiplication(datas.get(turn))).isEqualTo(resultats[turn++]);
        Assertions.assertThat(Exo8.findMaxMultiplication(datas.get(turn))).isEqualTo(resultats[turn++]);
    }

}
