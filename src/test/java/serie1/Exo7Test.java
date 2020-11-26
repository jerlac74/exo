package serie1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Exo7Test {
    /*
    Le but est de prendre un texte et de la convertir soit :

    Tout en majuscules si le texte comprend une majorité de majuscules.
    Tout en minuscules si le texte comprend une majorité de minuscules.
    En cas d'égalité, on ne convertira rien !
    "Toto" -> "toto"
    "TITi" -> "TITI"
    "taTA" -> "taTA"
     */

    @Test
    @DisplayName("vérifie la conversion du texte")
    void exo7() {
        String[] inputChaines={"av B","","ToToT","Toto", "TITi", "taTA"};
        String[] resultats={"av b","","TOTOT","toto", "TITI", "taTA"};

        int turn=0;
        Assertions.assertThat(Exo7.convertString(inputChaines[turn])).isEqualTo(resultats[turn++]);
        Assertions.assertThat(Exo7.convertString(inputChaines[turn])).isEqualTo(resultats[turn++]);
        Assertions.assertThat(Exo7.convertString(inputChaines[turn])).isEqualTo(resultats[turn++]);
        Assertions.assertThat(Exo7.convertString(inputChaines[turn])).isEqualTo(resultats[turn++]);
        Assertions.assertThat(Exo7.convertString(inputChaines[turn])).isEqualTo(resultats[turn++]);
        Assertions.assertThat(Exo7.convertString(inputChaines[turn])).isEqualTo(resultats[turn++]);
    }

}
