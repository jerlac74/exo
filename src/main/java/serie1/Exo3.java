package serie1;

public class Exo3 {
    /*
    Soit un tableau d'entiers relatifs, trouvez l'index de l'élément le plus éloigné de zéro.

    [1,-2,10,-15,3] -> 3 (car c'est l'index de -15, l'entier le plus éloigné de 0)
    S'il y a égalité, entre deux nombres, l'un positif, le second négatif, prenez le positif.

    [-10,10,3,-5] -> 1
    S'il y a égalité entre deux nombres positifs, prenez le premier index.

    [-10,10,3,10] -> 1
     */

    public static int findIndexFarFromZero(int[] tabSrc) {
        int result = -1;
        int tempResult = 0;
        int plusGrand=0;
        int indexFound=-1;

        if (tabSrc != null && tabSrc.length > 0) {
            for (int i=0; i< tabSrc.length; i++) {
                int absVal =Math.abs(tabSrc[i]);
                if(absVal >plusGrand){
                    plusGrand = absVal;
                    indexFound =i;
                }
                else if(absVal ==plusGrand){
                    if(tabSrc[i] >0) {
                        if(tabSrc[indexFound]<0){
                            indexFound =i;
                        }
                        /*else if(tabSrc[indexFound]>0){
                            if(indexFound > i){
                                indexFound =i;
                            }
                        }*/
                    }
                }
            }
            result = indexFound;
        }

        return result;
    }
}
