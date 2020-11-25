package serie1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.assertj.core.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static serie1.Exo1.calculeSommeDesCarres;

public class Exo1Test {
    /*
    Soit un nombre indéfini d'entiers, retourner la somme des carrés de ces entiers :
    [1,2,3] = 1²+2²+3² = 14
    [14,9,-9,1,4,3] -> 384
    Un tableau vide doit renvoyer -1
    [] -> -1
     */

    @Test
    @DisplayName("pour un tableau vide retourne -1")
    void tabVide() {
        int[] tabVide= {};
        Assertions.assertThat(calculeSommeDesCarres(tabVide)).isEqualTo(-1);
    }

    @Test
    @DisplayName("calcule somme pour un tab donné")
  //  @ParameterizedTest(name="Result for this tab {0}")
//    @ValueSource(ints= {[1,2,3],})
    void sommeForArrayGiven() {
        int[] tabInput ={1,2,3};
        Assertions.assertThat(calculeSommeDesCarres(tabInput)).isEqualTo(14);

        int[] tabInput2 ={14,9,-9,1,4,3};
        Assertions.assertThat(calculeSommeDesCarres(tabInput2)).isEqualTo(384);
    }
}
