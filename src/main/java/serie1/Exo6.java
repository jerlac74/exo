package serie1;

public class Exo6 {
    /*
    En général, lorsque vous payer, vous recevez un ticket de carte bleue avec le numéro de votre carte masquée.
    Seuls restent les 4 derniers numéros, le reste étant remplacé par des #.
    Le but de cet exercice est d'écrire une méthode permettant de remplacer tous les caractères d'une chaîne de caractère par des # (sauf les 4 derniers).

    123456789012 -> ########9012
    1234 5678 9012 -> ##########9012
    MomNomEstPersonne -> #############onne
    42 -> 42
     */

    public static String hideCharacters(String inputData) {
        String result = inputData;

        if(inputData!=null && inputData.length()>4){
            //longueur de la String - 1 - 4 caractères à garder.
            int lengthGlobal=inputData.length()-1;
            int lengthReduce = lengthGlobal-4;
            result="";

            for (int i = 0; i <= lengthGlobal; i++) {
                if(i<=lengthReduce)
                    result+="#";
                else
                    result+=inputData.charAt(i);
            }
        }

        return result;
    }
}
