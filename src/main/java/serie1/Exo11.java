package serie1;

public class Exo11 {
    /*
    Le but ici est de savoir s'il est possible de rendre la monnaie sur une somme donnée. Pour cela, nous avons 4 paramètres :

    Un nombre de pièces de 10ct
    Un nombre de pièces de 20ct
    Un nombre de pièces de 50ct
    La somme sur laquelle nous devons rendre la monnaie
    On cherche simplement à savoir si le rendu est possible. Il n'est pas nécessaire de trouver le rendu optimal.
    peutRendre(0,0,0,50) -> false
    peutRendre(2,2,2,200) -> false
    peutRendre(1,2,2,10) -> true
    peutRendre(1,2,2,80) -> true
    peutRendre(1,2,2,90) -> true
    peutRendre(0,2,5,80) -> false
    peutRendre(1,1,1,55) -> false
     */

    public static final int[] quantitePiece =new int[3];
    public static final int[] typePiece =new int[]{50,20,10};

    public static boolean peutRendre(int piece10cts, int piece20cts, int piece50cts, int sommeARendre) {

        if (piece10cts == 0 && piece20cts == 0 && piece50cts == 0) {
            return (sommeARendre == 0);
        }

        quantitePiece[0]=piece50cts;
        quantitePiece[1]=piece20cts;
        quantitePiece[2]=piece10cts;

        return calculAvecPiece(quantitePiece[0], sommeARendre, 0);
    }

    private static boolean calculAvecPiece(int nombrePiece, int sommeRestante, int indicePieceATester){
        int somme=sommeRestante;

        while (nombrePiece > 0) {
            somme = sommeRestante - (nombrePiece * typePiece[indicePieceATester]);
            if(somme<0){
                nombrePiece--;
            }
            else if(somme==0){
                return true;
            }
            else {
                break;
            }
        }
        if(somme<0) {
            somme = sommeRestante;
        }
        //on a testé toutes les pièces de cette catégorie
        //on passe aux autres
        indicePieceATester++;
        if(indicePieceATester < quantitePiece.length)
            return calculAvecPiece(quantitePiece[indicePieceATester], somme, indicePieceATester);
        else
            return false;
    }

}
