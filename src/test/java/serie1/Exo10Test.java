package serie1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class Exo10Test {
    /*
    Soit une chaîne de caractère représentant un nombre et un nombre n de virgules.
    Votre but est de trouver le plus grand chiffre possible après avoir inséré n virgules dans cette chaîne de caractères.
    Il ne peut pas y avoir deux virgules à la suite.

    '1234',1 = 234 car c'est le max de ('1','234'), ('12','34') et ('123','4').
    '1234',2 = 34 car c'est le max de ('1','2','34'), ('1','23','4') et ('12','3','4').
    '1234',3 = 4
    '2020',1 = 202
     */

    @Test
    @DisplayName("vérifie la nombre Max")
    void exo10() {
        String[] datas={"'1234',1", "'1234',2", "'1234',3", "'2020',1" };

        int[] resultats={234,34,4,202};

        int turn=0;
        Assertions.assertThat(Exo10.findNumberMax(datas[turn])).isEqualTo(resultats[turn++]);
        Assertions.assertThat(Exo10.findNumberMax(datas[turn])).isEqualTo(resultats[turn++]);
        Assertions.assertThat(Exo10.findNumberMax(datas[turn])).isEqualTo(resultats[turn++]);
        Assertions.assertThat(Exo10.findNumberMax(datas[turn])).isEqualTo(resultats[turn++]);
    }

}
