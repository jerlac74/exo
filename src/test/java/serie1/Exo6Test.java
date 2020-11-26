package serie1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class Exo6Test {
    /*
    En général, lorsque vous payer, vous recevez un ticket de carte bleue avec le numéro de votre carte masquée.
    Seuls restent les 4 derniers numéros, le reste étant remplacé par des #.
    Le but de cet exercice est d'écrire une méthode permettant de remplacer tous les caractères d'une chaîne de caractère par des # (sauf les 4 derniers).

    123456789012 -> ########9012
    1234 5678 9012 -> ##########9012
    MomNomEstPersonne -> #############onne
    42 -> 42
     */

    @Test
    @DisplayName("vérifie nouvelle chaine avec # sauf 4 derniers")
    void exo6() {
        String[] inputChaines={"123456789012", "1234 5678 9012", "MomNomEstPersonne", "42"};
        String[] resultats={"########9012", "##########9012", "#############onne", "42"};

        int turn=0;
        Assertions.assertThat(Exo6.hideCharacters(inputChaines[turn])).isEqualTo(resultats[turn++]);
        Assertions.assertThat(Exo6.hideCharacters(inputChaines[turn])).isEqualTo(resultats[turn++]);
        Assertions.assertThat(Exo6.hideCharacters(inputChaines[turn])).isEqualTo(resultats[turn++]);
        Assertions.assertThat(Exo6.hideCharacters(inputChaines[turn])).isEqualTo(resultats[turn++]);
    }


}
