package serie1;

import java.util.HashMap;

public class Exo5 {
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

    public static boolean isGoodforYou(int age, int physique, int salaire) {
        boolean result = false;

        if(salaire >=1000000)
            return true;
        else{
            boolean ageResult = (age >= 18 && age <= 35);
            boolean physiqueResult = (physique >= 8 && physique <= 10);
            boolean salaireResult = (salaire >= 50000);

            result = ageResult && physiqueResult && salaireResult;
        }

        return result;
    }
}
