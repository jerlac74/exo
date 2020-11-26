package serie1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Exo5Test {
    /*
    Jessica-Marie-Sue-Hellen est une femme...difficile. Elle n'accepte de sortir qu'avec des hommes selon les critères suivants :

    Âge : Il doit avoir entre 18 et 35 ans
    Physique : Au minimum 8/10
    Revenus annuels : Au minimum 50 000€/an, mais si c'est au delà de 1 000 000€/an, on oublie le reste des critères !
    Ecrire une méthode permettant de modéliser la chance d'un homme à sortir avec Jessica-Marie-Sue-Helen
    21, 9, 60000 -> true
    21, 7, 90000 -> false
    90, 2, 2000000 -> true
     */

    @Test
    @DisplayName("vérifie si elle accepte")
    void exo5() {
        int indiceAge=0;
        int indicePhysique=1;
        int indiceSalaire=2;
        ArrayList<int[]> datas=new ArrayList<>();
        datas.add(new int[]{17,9,51000});
        datas.add(new int[]{21,9,60000});
        datas.add(new int[]{21,7,90000});
        datas.add(new int[]{90,2,2000000});
        datas.add(new int[]{35,5,1000000});

        boolean[] resultat={false,true,false,true,true};
        int turn=0;
        Assertions.assertThat(Exo5.isGoodforYou(datas.get(turn)[indiceAge],datas.get(turn)[indicePhysique],datas.get(turn)[indiceSalaire])).isEqualTo(resultat[turn++]);
        Assertions.assertThat(Exo5.isGoodforYou(datas.get(turn)[indiceAge],datas.get(turn)[indicePhysique],datas.get(turn)[indiceSalaire])).isEqualTo(resultat[turn++]);
        Assertions.assertThat(Exo5.isGoodforYou(datas.get(turn)[indiceAge],datas.get(turn)[indicePhysique],datas.get(turn)[indiceSalaire])).isEqualTo(resultat[turn++]);
        Assertions.assertThat(Exo5.isGoodforYou(datas.get(turn)[indiceAge],datas.get(turn)[indicePhysique],datas.get(turn)[indiceSalaire])).isEqualTo(resultat[turn++]);
        Assertions.assertThat(Exo5.isGoodforYou(datas.get(turn)[indiceAge],datas.get(turn)[indicePhysique],datas.get(turn)[indiceSalaire])).isEqualTo(resultat[turn++]);
    }


}
