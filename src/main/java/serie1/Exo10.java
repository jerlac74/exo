package serie1;

import java.util.TreeSet;

public class Exo10 {
    /*
    Soit une chaîne de caractère représentant un nombre et un nombre n de virgules.
    Votre but est de trouver le plus grand chiffre possible après avoir inséré n virgules dans cette chaîne de caractères.
    Il ne peut pas y avoir deux virgules à la suite.

    '1234',1 = 234 car c'est le max de ('1','234'), ('12','34') et ('123','4').
    '1234',2 = 34 car c'est le max de ('1','2','34'), ('1','23','4') et ('12','3','4').
    '1234',3 = 4
    '2020',1 = 202
     */

    public static int findNumberMax(String inputData) {
        StringBuilder result = new StringBuilder();
        int max = 0;

        if (inputData != null && inputData.length() > 0) {

            //Découper la chaine reçue '1234',1
            //=> '1234' et 1
            String[] splitted = inputData.split(",");
            int nombreVirguleAMettre = Integer.parseInt(splitted[1]);
            String texteSansQuotes = splitted[0].replaceAll("'", "");
            //si =0 on retourne le nombre
            if (nombreVirguleAMettre == 0)
                return Integer.parseInt(texteSansQuotes);

            max = findRecurse(nombreVirguleAMettre, texteSansQuotes, max);
        }
        return max;
    }

    private static int findRecurse(int nombreDeVirgule, String data, int max) {
        /*
        prendre le 1er chiffre
        mettre 1 virgule, décrémenter le nombre de virgule
        si ce nouveau nombre >0
            refaire ce traitement avec l'ensemble des chiffres suivant
        sinon concaténer le reste des chiffres pour le 2nd résultat
        comparer l'entier du 1er chiffre avec celui du 2nd
        et conserver le plus grand et le comparer au max déjà trouvé
        puis passer au suivant
         */
        int nombreVirguleCourant = nombreDeVirgule;

        for (int i = 0; i < data.length() - 1; i++) {
            nombreVirguleCourant--;
            if (nombreVirguleCourant > 0)
                max =findRecurse(nombreVirguleCourant, data.substring(i+1), max);
            else {
                String elt = data.substring(0, i + 1);
                int nombreFirst = Integer.parseInt(elt);
                int nombreRestant = Integer.parseInt(data.substring(i + 1));
                if (nombreFirst > max)
                    max = nombreFirst;
                if (nombreRestant > max)
                    max = nombreRestant;
            }
            nombreVirguleCourant =nombreDeVirgule;
        }
        return max;
    }

}
