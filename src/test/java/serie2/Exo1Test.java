package serie2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import serie1.Exo11;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class Exo1Test {
    /*
    Jeu des 8 dames
     */

    private boolean[][] srcArray;
    private String myString;

    @BeforeEach
    void setUp() {
        /*
        [[true, false, true, false],[false, true, false, false],[false, false, false, false],[false, false, false, true]]
        ->
           0 1 2 3
        0 |X| |X| |
        1 | |X| | |
        2 | | | | |
        3 | | | |X|
         */
        srcArray = new boolean[][]{{true, false, true, false}, {false, true, false, false}, {false, false, false, false}, {false, false, false, true}};

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("   0 1 2 3");
        stringBuilder.append("\n");
        stringBuilder.append("0 |X| |X| |");
        stringBuilder.append("\n");
        stringBuilder.append("1 | |X| | |");
        stringBuilder.append("\n");
        stringBuilder.append("2 | | | | |");
        stringBuilder.append("\n");
        stringBuilder.append("3 | | | |X|");
        stringBuilder.append("\n");

        myString = stringBuilder.toString();
    }

    @Test
    @DisplayName("vérifie que le clone d'un tableau vide est équivalent et a une adresse mémoire différente")
    void checkCloneArrayEmpty() {
        Exo1 exo1 = new Exo1(4);
        boolean[][] copyArray = exo1.cloneBoard();
        boolean[][] board = exo1.getBoard();

        Assertions.assertThat(copyArray).isDeepEqualTo(board);
        System.out.println("copy:" + copyArray.toString());
        System.out.println("board:" + board.toString());
        Assertions.assertThat(copyArray).isNotSameAs(board);
    }

    @Test
    @DisplayName("vérifie que le clone d'un tableau rempli est équivalent et a une adresse mémoire différente")
    void checkCloneArrayFilled() {
        int size = 4;
        boolean[][] randomArray = new boolean[size][size];
        for (int ligne = 0; ligne < randomArray.length; ligne++) {
            for (int col = 0; col < randomArray.length; col++) {
                randomArray[ligne][col] = (Math.random() <= 0.5);
            }
        }
        Exo1 exo1 = new Exo1(randomArray);
        boolean[][] copyArray = exo1.cloneBoard();
        boolean[][] board = exo1.getBoard();

        Assertions.assertThat(copyArray).isDeepEqualTo(board);
        System.out.println("copy:" + copyArray.toString());
        System.out.println("board:" + board.toString());
        Assertions.assertThat(copyArray).isNotSameAs(board);
        Assertions.assertThat(board).isDeepEqualTo(randomArray);
    }

    @Test
    @DisplayName("vérifie que la création d'un tableau à partir d'un fourni, copie bien le contenu")
    void checkCopyArray() {
        int size = 4;
        boolean[][] randomArray = new boolean[size][size];
        for (int ligne = 0; ligne < size; ligne++) {
            for (int col = 0; col < size; col++) {
                randomArray[ligne][col] = (Math.random() <= 0.5);
            }
        }
        Exo1 exo1 = new Exo1(randomArray);
        boolean[][] board = exo1.getBoard();

        Assertions.assertThat(board).isDeepEqualTo(randomArray);
        System.out.println("randomArray:" + randomArray.toString());
        System.out.println("board:" + board.toString());
        Assertions.assertThat(board).isNotSameAs(randomArray);
    }

    @Test
    @DisplayName("vérifie l'affichage d'une grille pour un tableau donné")
    void checkAfficherGrille() {
        /*
        [[true, false, true, false],[false, true, false, false],[false, false, false, false],[false, false, false, true]]
        ->
           0 1 2 3
        0 |X| |X| |
        1 | |X| | |
        2 | | | | |
        3 | | | |X|
         */

        Exo1 exo1 = new Exo1(srcArray);

        System.out.println("myString:\n" + myString);
        System.out.println("board:\n" + exo1.toString());
        Assertions.assertThat(exo1.toString()).isEqualTo(myString);
    }

    @Test
    @DisplayName("vérifie qu'il n'y a pas plus d'une dame pour une ligne donnée")
    void checkOnlyOneDameInLine() {
        /*
        Ecrire un algorithme qui vérifie qu'il n'y a pas plus d'une dame pour une ligne donnée

        Soit le plateau en entrée :
        |X| |X| |
        | |X| | |
        | | | | |
        | | | |X|
        verifierLigne(0)-> false
        verifierLigne(1)-> true
         */

        boolean[] resulats = {false, true, true, true};
        int turn = 0;

        Exo1 exo1 = new Exo1(srcArray);

        Assertions.assertThat(exo1.verifierLigne(turn)).isEqualTo(resulats[turn++]);
        Assertions.assertThat(exo1.verifierLigne(turn)).isEqualTo(resulats[turn++]);
        Assertions.assertThat(exo1.verifierLigne(turn)).isEqualTo(resulats[turn++]);
        Assertions.assertThat(exo1.verifierLigne(turn)).isEqualTo(resulats[turn++]);
    }

    @Test
    @DisplayName("vérifie qu'il n'y a pas plus d'une dame pour une colonne donnée")
    void checkOnlyOneDameInColumn() {
        /*
        Ecrire un algorithme qui vérifie qu'il n'y a pas plus d'une dame pour une colonne donnée

        Soit le plateau en entrée :
        |X| |X|X|
        | |X| | |
        | | | | |
        | | | |X|
        verifierColonne(0)-> true
        verifierColonne(3)-> false
         */

        boolean[] resulats = {true, true, true, false};
        int turn = 0;

        srcArray[0][3] = true;
        Exo1 exo1 = new Exo1(srcArray);

        Assertions.assertThat(exo1.verifierColonne(turn)).isEqualTo(resulats[turn++]);
        Assertions.assertThat(exo1.verifierColonne(turn)).isEqualTo(resulats[turn++]);
        Assertions.assertThat(exo1.verifierColonne(turn)).isEqualTo(resulats[turn++]);
        Assertions.assertThat(exo1.verifierColonne(turn)).isEqualTo(resulats[turn++]);
    }

    @Test
    @DisplayName("vérifie qu'il n'y a pas plus d'une dame pour une diagonale 'droite' (qui va vers la droite en descendant) donnée.")
    void checkOnlyOneDameInDiagonaleDroite() {
        /*
        Ecrire un algorithme qui vérifie qu'il n'y a pas plus d'une dame pour une diagonale 'droite' (qui va vers la droite en descendant) donnée.
        Pour plus de simplicité, on peut leur donner un numéro qui correspond au numéro de la colonne de laquelle part une diagonale. i.e :

        Diagonale droite 0 :
        |O| | | |
        | |O| | |
        | | |O| |
        | | | |O|

        Diagonale droite 3 :
        | | | |O|
        | | | | |
        | | | | |
        | | | | |

        Diagonale droite -2 :
        | | | | |
        | | | | |
        |O| | | |
        | |O| | |
        Soit le plateau en entrée :
        |X| |X|X|
        | |X| | |
        |X| | | |
        | |X| |X|
        verifierDiagonaleDroite(0)-> false
        verifierDiagonaleDroite(1)-> true
        verifierDiagonaleDroite(2)-> true
        verifierDiagonaleDroite(3)-> true
        verifierDiagonaleDroite(-1)-> true
        verifierDiagonaleDroite(-2)-> false
        verifierDiagonaleDroite(-3)-> true
         */

        boolean[] resulats = {false, true, true, true, true, false, true};
        int turn = 0;

        srcArray[0][3] = true;
        srcArray[2][0] = true;
        srcArray[3][1] = true;
        Exo1 exo1 = new Exo1(srcArray);

        Assertions.assertThat(exo1.verifierDiagonaleDroite(turn)).isEqualTo(resulats[turn++]);
        Assertions.assertThat(exo1.verifierDiagonaleDroite(turn)).isEqualTo(resulats[turn++]);
        Assertions.assertThat(exo1.verifierDiagonaleDroite(turn)).isEqualTo(resulats[turn++]);
        Assertions.assertThat(exo1.verifierDiagonaleDroite(turn)).isEqualTo(resulats[turn++]);
        Assertions.assertThat(exo1.verifierDiagonaleDroite(-1)).isEqualTo(resulats[turn++]);
        Assertions.assertThat(exo1.verifierDiagonaleDroite(-2)).isEqualTo(resulats[turn++]);
        Assertions.assertThat(exo1.verifierDiagonaleDroite(-3)).isEqualTo(resulats[turn++]);
    }

    @Test
    @DisplayName("vérifie qu'il n'y a pas plus d'une dame pour une diagonale 'gauche'.")
    void checkOnlyOneDameInDiagonaleGauche() {
        /*
        Effectuer le même travail pour les diagonales gauches. Attention, les diagonales droites sont numérotées de -3 à 3,
        et les diagonales gauches sont numérotées de 0 à 6
        e.g :

        Diagonale gauche 0 :
        |O| | | |
        | | | | |
        | | | | |
        | | | | |

        Diagonale gauche 3 :
        | | | |O|
        | | |O| |
        | |O| | |
        |O| | | |

        Diagonale gauche 6 :
        | | | | |
        | | | | |
        | | | | |
        | | | |0|

        Soit le plateau en entrée :
        |X| |X|X|
        | |X| |X|
        |X| | | |
        | |X| |X|
        verifierDiagonaleGauche(0)-> true
        verifierDiagonaleGauche(1)-> true
        verifierDiagonaleGauche(2)-> false
        verifierDiagonaleGauche(3)-> true
        verifierDiagonaleGauche(4)-> false
        verifierDiagonaleGauche(5)-> true
        verifierDiagonaleGauche(6)-> true
         */

        boolean[] resulats = {true, true, false, true, false, true, true};
        int turn = 0;

        srcArray[0][3] = true;
        srcArray[1][3] = true;
        srcArray[2][0] = true;
        srcArray[3][1] = true;
        Exo1 exo1 = new Exo1(srcArray);

        Assertions.assertThat(exo1.verifierDiagonaleGauche(turn)).isEqualTo(resulats[turn++]);
        Assertions.assertThat(exo1.verifierDiagonaleGauche(turn)).isEqualTo(resulats[turn++]);
        Assertions.assertThat(exo1.verifierDiagonaleGauche(turn)).isEqualTo(resulats[turn++]);
        Assertions.assertThat(exo1.verifierDiagonaleGauche(turn)).isEqualTo(resulats[turn++]);
        Assertions.assertThat(exo1.verifierDiagonaleGauche(turn)).isEqualTo(resulats[turn++]);
        Assertions.assertThat(exo1.verifierDiagonaleGauche(turn)).isEqualTo(resulats[turn++]);
        Assertions.assertThat(exo1.verifierDiagonaleGauche(turn)).isEqualTo(resulats[turn++]);
    }

    @Test
    @DisplayName("parcours de tableau et qui vérifie les ligne/colonnes/diagonales-gauche/diagonales-droite des cases occupées.")
    void checkOnlyOneDameInAll() {
        /*
        Ecrire une méthode qui parcourt de tableau et qui vérifie les lignes/colonnes/diagonales-gauche/diagonales-droite des cases occupées.
         */
        /*
        Soit le plateau en entrée :
        | | | | |
        |X| | | |
        | | | | |
        | | | |X|
        estUneSolution() -> true
         */
        srcArray[0] = new boolean[]{false, false, false, false};
        srcArray[1] = new boolean[]{true, false, false, false};
        srcArray[2] = new boolean[]{false, false, false, false};
        srcArray[3] = new boolean[]{false, false, false, true};
        Exo1 exo1 = new Exo1(srcArray);
        Assertions.assertThat(exo1.estUneSolution()).isEqualTo(true);
        /*
        Soit le plateau en entrée :
        | | |X| |
        | | | |X|
        | | | | |
        | | | | |
        estUneSolution() -> false
         */
        srcArray[0] = new boolean[]{false, false, true, false};
        srcArray[1] = new boolean[]{true, false, false, true};
        srcArray[2] = new boolean[]{false, false, false, false};
        srcArray[3] = new boolean[]{false, false, false, false};
        Exo1 exo2 = new Exo1(srcArray);
        Assertions.assertThat(exo2.estUneSolution()).isEqualTo(false);

        /*
        Soit le plateau en entrée :
        | |X|X|X|
        |X| | | |
        | | | | |
        | | | | |
        estUneSolution()-> false
         */
        srcArray[0] = new boolean[]{false, true, true, true};
        srcArray[1] = new boolean[]{true, false, false, false};
        srcArray[2] = new boolean[]{false, false, false, false};
        srcArray[3] = new boolean[]{false, false, false, false};
        Exo1 exo3 = new Exo1(srcArray);
        Assertions.assertThat(exo3.estUneSolution()).isEqualTo(false);

        /*
        Soit le plateau en entrée :
        |X| |X|X|
        | |X| |X|
        |X| | | |
        | |X| |X|
        estUneSolution()-> false
         */
        srcArray[0] = new boolean[]{true, false, true, true};
        srcArray[1] = new boolean[]{false, true, false, true};
        srcArray[2] = new boolean[]{true, false, false, false};
        srcArray[3] = new boolean[]{false, true, false, true};
        Exo1 exo4 = new Exo1(srcArray);
        Assertions.assertThat(exo4.estUneSolution()).isEqualTo(false);
    }

    @Test
    @DisplayName("Vérification du prochain déplacement.")
    void checkNextMoveNaif() {
        /*
        Pour l'algorithme naïf, nous allons partir de la position suivante et nous allons itérer pour essayer la totalité des possibilités une à une.

        Position de départ :
        |X|X|X|X|
        | | | | |
        | | | | |
        | | | | |
        Le but est de déplacer la dame de la colonne la plus à gauche d'une case vers le bas.
        S'il faut déplacer une dame vers le bas alors qu'elle est déjà à la dernière case de sa colonne,
        nous la repositionnons sur la première case de sa colonne (tout en haut)
        et nous déplaçons la dame de la colonne suivante d'une case vers le bas.

        S'il n'y a plus de coup disponibles, il faut lever une erreur.
         */
        /*
        Exemple 1 :
        |X|X|X|X|
        | | | | |
        | | | | |
        | | | | |
        Coup suivant :
        | |X|X|X|
        |X| | | |
        | | | | |
        | | | | |
         */
        boolean[][] destArray= new boolean[4][];

        srcArray[0] = new boolean[]{true, true, true, true};
        srcArray[1] = new boolean[]{false, false, false, false};
        srcArray[2] = new boolean[]{false, false, false, false};
        srcArray[3] = new boolean[]{false, false, false, false};
        Exo1 exoSrc1 = new Exo1(srcArray);
        Throwable exp1 = Assertions.catchThrowable(
                ()->{exoSrc1.nextMoveNaif();}
        );

        destArray[0] = new boolean[]{false, true, true, true};
        destArray[1] = new boolean[]{true, false, false, false};
        destArray[2] = new boolean[]{false, false, false, false};
        destArray[3] = new boolean[]{false, false, false, false};

        Assertions.assertThat(exoSrc1.getBoard()).isDeepEqualTo(destArray);
        Assertions.assertThat(exp1).isNull();

        /*
        Exemple 2 :
        | |X|X|X|
        | | | | |
        | | | | |
        |X| | | |
        Coup suivant :
        |X| |X|X|
        | |X| | |
        | | | | |
        | | | | |
         */
        srcArray[0] = new boolean[]{false, true, true, true};
        srcArray[1] = new boolean[]{false, false, false, false};
        srcArray[2] = new boolean[]{false, false, false, false};
        srcArray[3] = new boolean[]{true, false, false, false};
        Exo1 exoSrc2 = new Exo1(srcArray);
        Throwable exp2 = Assertions.catchThrowable(
                ()->{exoSrc2.nextMoveNaif();}
        );
        destArray[0] = new boolean[]{true, false, true, true};
        destArray[1] = new boolean[]{false, true, false, false};
        destArray[2] = new boolean[]{false, false, false, false};
        destArray[3] = new boolean[]{false, false, false, false};

        Assertions.assertThat(exoSrc2.getBoard()).isDeepEqualTo(destArray);
        Assertions.assertThat(exp2).isNull();

        /*
        Exemple 3 :
        | | | | |
        | | |X| |
        | | | |X|
        |X|X| | |
        Coup suivant :
        |X|X| | |
        | | | | |
        | | |X|X|
        | | | | |
         */
        srcArray[0] = new boolean[]{false, false, false, false};
        srcArray[1] = new boolean[]{false, false, true, false};
        srcArray[2] = new boolean[]{false, false, false, true};
        srcArray[3] = new boolean[]{true, true, false, false};
        Exo1 exoSrc3= new Exo1(srcArray);
        Throwable exp3 = Assertions.catchThrowable(
                ()->{exoSrc3.nextMoveNaif();}
        );
        destArray[0] = new boolean[]{true, true, false, false};
        destArray[1] = new boolean[]{false, false, false, false};
        destArray[2] = new boolean[]{false, false, true, true};
        destArray[3] = new boolean[]{false, false, false, false};

        Assertions.assertThat(exoSrc3.getBoard()).isDeepEqualTo(destArray);
        Assertions.assertThat(exp3).isNull();

        /*
        Exemple 4 :
        | | | | |
        | | | | |
        | | | | |
        |X|X|X|X|
        Coup suivant -> Exception !
         */
        srcArray[0] = new boolean[]{false, false, false, false};
        srcArray[1] = new boolean[]{false, false, false, false};
        srcArray[2] = new boolean[]{false, false, false, false};
        srcArray[3] = new boolean[]{true, true, true, true};
        Exo1 exoSrc4= new Exo1(srcArray);
        Throwable exp4= Assertions.catchThrowable(
                ()->{exoSrc4.nextMoveNaif();}
        );

        Assertions.assertThat(exp4).isNotNull().isInstanceOf(JeuDamesException.class);
    }

    @Test
    @DisplayName("Cherche les solutions au problème pour 4 Dames sans initialisation donnée")
    void findSolutionsFor4StartEmpty() {
        long start = System.currentTimeMillis();

        Exo1 exoSrc1 = new Exo1(4);
        LinkedList<boolean[][]> resultList = exoSrc1.findSolutions();

        //fermer le timer et afficher le résultat
        long end = System.currentTimeMillis();
        System.out.println("findSolutionsFor4StartEmpty: Durée en millisecondes:" + (end - start));

        Assertions.assertThat(resultList).hasSize(2);

        //Afficher les solutions
        for (boolean[][] tab : resultList) {
            exoSrc1 =new Exo1(tab);
            System.out.println(exoSrc1.toString());
        }
    }
    @Test
    @DisplayName("Cherche les solutions au problème pour 4 Dames posées sur la 1ère ligne")
    void findSolutionsFor4StartFilledFirstRow() {
        long start = System.currentTimeMillis();

        boolean[][] destArray= new boolean[4][];
        srcArray[0] = new boolean[]{true, true, true, true};
        srcArray[1] = new boolean[]{false, false, false, false};
        srcArray[2] = new boolean[]{false, false, false, false};
        srcArray[3] = new boolean[]{false, false, false, false};
        Exo1 exoSrc1 = new Exo1(srcArray);
        LinkedList<boolean[][]> resultList = exoSrc1.findSolutions();

        //fermer le timer et afficher le résultat
        long end = System.currentTimeMillis();
        System.out.println("findSolutionsFor4StartFilledFirstRow: Durée en millisecondes:" + (end - start));

        Assertions.assertThat(resultList).hasSize(2);

        //Afficher les solutions
        for (boolean[][] tab : resultList) {
            exoSrc1 =new Exo1(tab);
            System.out.println(exoSrc1.toString());
        }
    }

    @Test
    @DisplayName("Cherche les solutions au problème pour 4 Dames dont la position est donnée pour le départ")
    void findSolutionsFor4StartFilled() {
        long start = System.currentTimeMillis();

        boolean[][] destArray= new boolean[4][];
        srcArray[0] = new boolean[]{false, false, false, true};
        srcArray[1] = new boolean[]{false, false, true, false};
        srcArray[2] = new boolean[]{false, true, false, false};
        srcArray[3] = new boolean[]{true, false, false, false};
        Exo1 exoSrc1 = new Exo1(srcArray);
        LinkedList<boolean[][]> resultList = exoSrc1.findSolutions();

        //fermer le timer et afficher le résultat
        long end = System.currentTimeMillis();
        System.out.println("findSolutionsFor4StartFilled: Durée en millisecondes:" + (end - start));

        Assertions.assertThat(resultList).hasSize(2);

        //Afficher les solutions
        for (boolean[][] tab : resultList) {
            exoSrc1 =new Exo1(tab);
            System.out.println(exoSrc1.toString());
        }
    }

    @Test
    @DisplayName("Cherche les solutions au problème pour 8 Dames sans position donnée")
    void findSolutionsFor8StartEmpty() {
        long start = System.currentTimeMillis();

        Exo1 exoSrc1 = new Exo1(8);
        LinkedList<boolean[][]> resultList = exoSrc1.findSolutions();

        //fermer le timer et afficher le résultat
        long end = System.currentTimeMillis();
        System.out.println("findSolutionsFor8StartEmpty: Durée en millisecondes:" + (end - start));

        Assertions.assertThat(resultList).hasSize(92);
    }
    @Test
    @DisplayName("Cherche les solutions au problème pour 8 Dames avec les dames en 1ère ligne")
    void findSolutionsFor8StartFilledFirstRow() {
        long start = System.currentTimeMillis();

        boolean[][] array8= new boolean[8][];
        array8[0] = new boolean[]{true, true, true, true, true, true, true, true};
        array8[1] = new boolean[]{false, false, false, false, false, false, false, false};
        array8[2] = new boolean[]{false, false, false, false, false, false, false, false};
        array8[3] = new boolean[]{false, false, false, false, false, false, false, false};
        array8[4] = new boolean[]{false, false, false, false, false, false, false, false};
        array8[5] = new boolean[]{false, false, false, false, false, false, false, false};
        array8[6] = new boolean[]{false, false, false, false, false, false, false, false};
        array8[7] = new boolean[]{false, false, false, false, false, false, false, false};
        Exo1 exoSrc1 = new Exo1(array8);
        LinkedList<boolean[][]> resultList = exoSrc1.findSolutions();

        //fermer le timer et afficher le résultat
        long end = System.currentTimeMillis();
        System.out.println("findSolutionsFor8StartFilledFirstRow: Durée en millisecondes:" + (end - start));

        Assertions.assertThat(resultList).hasSize(92);
    }

    @Test
    @DisplayName("Cherche les solutions au problème pour 8 Dames avec des positions données.")
    void findSolutionsFor8StartFilled() {
        long start = System.currentTimeMillis();

        boolean[][] array8= new boolean[8][];
        array8[0] = new boolean[]{false, false, false, false, false, false, false, true};
        array8[1] = new boolean[]{false, false, false, false, false, false, true, false};
        array8[2] = new boolean[]{false, false, false, false, false, true, false, false};
        array8[3] = new boolean[]{false, false, false, false, true, false, false, false};
        array8[4] = new boolean[]{false, false, false, true, false, false, false, false};
        array8[5] = new boolean[]{false, false, true, false, false, false, false, false};
        array8[6] = new boolean[]{false, true, false, false, false, false, false, false};
        array8[7] = new boolean[]{true, false, false, false, false, false, false, false};
        Exo1 exoSrc1 = new Exo1(array8);
        LinkedList<boolean[][]> resultList = exoSrc1.findSolutions();

        //fermer le timer et afficher le résultat
        long end = System.currentTimeMillis();
        System.out.println("findSolutionsFor8StartFilled: Durée en millisecondes:" + (end - start));

        Assertions.assertThat(resultList).hasSize(92);
    }
}
