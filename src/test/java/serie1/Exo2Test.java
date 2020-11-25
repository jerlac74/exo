package serie1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static serie1.Exo2.calculerMoyenneTableau;

public class Exo2Test {
    /*
    Ecrire une méthode qui permet de calculer la moyenne d'un tableau de décimaux.
    La moyenne doit être un entier arrondi à l'inférieur.
    Un tableau vide doit renvoyer une exception.

    [10, 20] -> (10+20)/2 = 15
    [11,12,13,14,15, 16] -> 13
    [] -> Exception
     */

    @Test
    @DisplayName("pour un tableau vide déclenche une exception")
    void tabVide() {
        double[] tabVide= {};
        Throwable exp = Assertions.catchThrowable(
                ()-> {calculerMoyenneTableau(tabVide);}
        );
        Assertions.assertThat(exp).isNotNull();
    }

    @Test
    @DisplayName("calcule moyenne pour un tab donné")
  //  @ParameterizedTest(name="Result for this tab {0}")
//    @ValueSource(ints= {[1,2,3],})
    void moyenneTab() {
        double[] tabInput ={10, 20};
        Assertions.assertThat(calculerMoyenneTableau(tabInput)).isEqualTo(15);

        double[] tabInput2 ={11,12,13,14,15, 16};
        Assertions.assertThat(calculerMoyenneTableau(tabInput2)).isEqualTo(13);
    }
}
