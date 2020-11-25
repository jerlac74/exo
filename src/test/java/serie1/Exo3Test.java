package serie1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static serie1.Exo3.findIndexFarFromZero;

public class Exo3Test {
    /*
    Soit un tableau d'entiers relatifs, trouvez l'index de l'élément le plus éloigné de zéro.

    [1,-2,10,-15,3] -> 3 (car c'est l'index de -15, l'entier le plus éloigné de 0)
    S'il y a égalité, entre deux nombres, l'un positif, le second négatif, prenez le positif.

    [-10,10,3,-5] -> 1
    S'il y a égalité entre deux nombres positifs, prenez le premier index.

    [-10,10,3,10] -> 1
     */

    @Test
    @DisplayName("pour un tableau vide retourne -1")
    void tabVide() {
        int[] tabVide = {};

        Assertions.assertThat(findIndexFarFromZero(tabVide)).isEqualTo(-1);
    }

    @Test
    @DisplayName("trouve l'index de l'entier le plus loin de zéro")
        //  @ParameterizedTest(name="Result for this tab {0}")
//    @ValueSource(ints= {[1,2,3],})
    void givenArray_findIndexFarFromZero() {
        int[] tabInput = {1, -2, 10, -15, 3};
        Assertions.assertThat(findIndexFarFromZero(tabInput)).isEqualTo(3);

        int[] tabInput2 = {-10, 10, 3, -5};
        Assertions.assertThat(findIndexFarFromZero(tabInput2)).isEqualTo(1);

        int[] tabInput3 = {-10, 10, 3, 10};
        Assertions.assertThat(findIndexFarFromZero(tabInput3)).isEqualTo(1);

        int[] tabInput4 = {0, 10, 3, -15, 10, 15};
        Assertions.assertThat(findIndexFarFromZero(tabInput4)).isEqualTo(5);

        int[] tabInput5 = {0, 10, 3, 15, 10, -15};
        Assertions.assertThat(findIndexFarFromZero(tabInput5))
                .withFailMessage("Erreur pour tabInput5")
                .isEqualTo(3);

        int[] tabInput6 = {0, -20, 3, -20, 10, 15};
        Assertions.assertThat(findIndexFarFromZero(tabInput6)).isEqualTo(1);

        int[] tabInput7 = {0, -20, 3, -20, 20, 15};
        Assertions.assertThat(findIndexFarFromZero(tabInput7)).isEqualTo(4);
    }
}
