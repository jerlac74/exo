package serie1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class Exo11Test {
    /*
    Le but ici est de savoir s'il est possible de rendre la monnaie sur une somme donnée. Pour cela, nous avons 4 paramètres :

    Un nombre de pièces de 10ct
    Un nombre de pièces de 20ct
    Un nombre de pièces de 50ct
    La somme sur laquelle nous devons rendre la monnaie
    On cherche simplement à savoir si le rendu est possible. Il n'est pas nécessaire de trouver le rendu optimal.
    peutRendre(0,0,0,50) -> false
    peutRendre(2,2,2,200) -> false
    peutRendre(1,2,2,10) -> true
    peutRendre(1,2,2,80) -> true
    peutRendre(1,2,2,90) -> true
    peutRendre(0,2,5,80) -> false
    peutRendre(1,1,1,55) -> false
     */

    @Test
    @DisplayName("vérifie le rendu de monnaie")
    void exo11() {
        ArrayList<int[]> datas = new ArrayList<>();
        datas.add(new int[]{0, 0, 0, 50});
        datas.add(new int[]{2, 2, 2, 200});
        datas.add(new int[]{1, 2, 2, 10});
        datas.add(new int[]{1, 2, 2, 80});
        datas.add(new int[]{1, 2, 2, 90});
        datas.add(new int[]{0, 2, 5, 80});
        datas.add(new int[]{1, 1, 1, 55});

        boolean[] resultats = {false, false, true, true, true, false, false};

        int turn = 0;
        Assertions.assertThat(Exo11.peutRendre(datas.get(turn)[0], datas.get(turn)[1], datas.get(turn)[2], datas.get(turn)[3]))
                .isEqualTo(resultats[turn++]);
        Assertions.assertThat(Exo11.peutRendre(datas.get(turn)[0], datas.get(turn)[1], datas.get(turn)[2], datas.get(turn)[3]))
                .isEqualTo(resultats[turn++]);
        Assertions.assertThat(Exo11.peutRendre(datas.get(turn)[0], datas.get(turn)[1], datas.get(turn)[2], datas.get(turn)[3]))
                .isEqualTo(resultats[turn++]);
        Assertions.assertThat(Exo11.peutRendre(datas.get(turn)[0], datas.get(turn)[1], datas.get(turn)[2], datas.get(turn)[3]))
                .isEqualTo(resultats[turn++]);
        Assertions.assertThat(Exo11.peutRendre(datas.get(turn)[0], datas.get(turn)[1], datas.get(turn)[2], datas.get(turn)[3]))
                .isEqualTo(resultats[turn++]);
        Assertions.assertThat(Exo11.peutRendre(datas.get(turn)[0], datas.get(turn)[1], datas.get(turn)[2], datas.get(turn)[3]))
                .isEqualTo(resultats[turn++]);
        Assertions.assertThat(Exo11.peutRendre(datas.get(turn)[0], datas.get(turn)[1], datas.get(turn)[2], datas.get(turn)[3]))
                .isEqualTo(resultats[turn++]);
    }

}
