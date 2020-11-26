package serie1;

public class Exo7 {
    /*
    Le but est de prendre un texte et de la convertir soit :

    Tout en majuscules si le texte comprend une majorité de majuscules.
    Tout en minuscules si le texte comprend une majorité de minuscules.
    En cas d'égalité, on ne convertira rien !
    "Toto" -> "toto"
    "TITi" -> "TITI"
    "taTA" -> "taTA"
     */

    public static String convertString(String inputData) {
        String result=inputData;

        if(inputData!=null && inputData.matches("[\\w\\s\\-_]*")){

            int lengthGlobal=inputData.length();
            int countMaj=0;
            int countMinuscule=0;

            char[] chars =inputData.toCharArray();
            for (char aChar : chars) {
                if(aChar>='A' && aChar<='Z')
                    countMaj++;
                else if(aChar>='a' && aChar<='z')
                        countMinuscule++;
            }
            if(countMaj >countMinuscule)
                result =inputData.toUpperCase();
            else if(countMaj<countMinuscule)
                result =inputData.toLowerCase();
        }

        return result;
    }
}
