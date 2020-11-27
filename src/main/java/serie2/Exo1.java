package serie2;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class Exo1 {
    /*
    Jeu des 8 dames
     */

    private int sizeBoard;
    private boolean[][] board;
    private Output output;

    public Exo1(int sizeBoard) {
        this.sizeBoard = sizeBoard;
        this.board = new boolean[this.sizeBoard][this.sizeBoard];
        this.output = new ScreenOutput();
    }

    public Exo1(boolean[][] board) {
        this.board = new boolean[board.length][board.length];
        this.sizeBoard = board.length - 1;
        copyBoardValues(board);
        this.output = new ScreenOutput();
    }

    public boolean[][] getBoard() {
        return board;
    }

    public boolean[][] cloneBoard() {
        boolean[][] copy = new boolean[this.sizeBoard][this.sizeBoard];

        int lengthBoard = board.length;
        for (int ligne = 0; ligne < lengthBoard; ligne++) {
            System.arraycopy(board[ligne], 0, copy[ligne], 0, lengthBoard);
        }

        return copy;
    }

    @Override
    public String toString() {
        return afficherGrille();
    }

    public boolean estUneSolution() {
        /*
        Vérifie que la position des dames dans le tableau est une solution à l'unicité d'une dame dans une ligne/colonne/et les 2 diagonales.
        verifierDiagonaleDroite indice de -tabLength à tabLength
        verifierDiagonaleGauche indice de 0 à tabLength*2
        verifierColonne indice de 0 à tabLength
        verifierLigne indice de 0 à tabLength
         */
        int lengthTab = this.sizeBoard;
        for (int i = -lengthTab; i <= lengthTab; i++) {
            if (!verifierDiagonaleDroite(i))
                return false;
        }
        for (int i = 0; i <= lengthTab * 2; i++) {
            if (!verifierDiagonaleGauche(i))
                return false;
        }
        for (int i = 0; i <= lengthTab; i++) {
            if (!verifierLigne(i))
                return false;
            if (!verifierColonne(i))
                return false;
        }

        return true;
    }

    public void nextMoveNaif() {
        /*
        Pour l'algorithme naïf, nous allons partir de la position suivante et nous allons itérer pour essayer la totalité des possibilités une à une.

        Position de départ :
        |X|X|X|X|
        | | | | |
        | | | | |
        | | | | |
        Le but est de déplacer la dame de la colonne la plus à gauche d'une case vers le bas.
        S'il faut déplacer une dame vers le bas alors qu'elle est déjà à la dernière case de sa colonne,
        nous la repositionnons sur la première case de sa colonne (tout en haut) et nous déplaçons la dame de la colonne suivante d'une case vers le bas.

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
        S'il n'y a plus de coup disponibles, il faut lever une erreur.
        Exemple 3 :
        | | | | |
        | | | | |
        | | | | |
        |X|X|X|X|
        Coup suivant -> Exception !
         */
        //Trouver la position actuelle
        //this.sizeBoard +1 nous donne le nombre de dames à trouver
        int count=0;
        HashMap<Integer, Integer> positionsDames = new HashMap<>();
        for (int ligne = 0; ligne <= this.sizeBoard; ligne++) {
            for (int col = 0; col <= this.sizeBoard; col++) {
                if (this.board[ligne][col]) {
                    positionsDames.put(ligne, col);
                    count++;
                    if(count==this.sizeBoard+1)
                        break;
                }
            }
            if(count==this.sizeBoard+1)
                break;
        }
        //TODO
        //déplacer selon la règle
        
        //
        for (int col = 0; col <= this.sizeBoard; col++) {
            for (int ligne = 0; ligne <= this.sizeBoard; ligne++) {
                //si toute la ligne a une valeur
                //on déplace la colonne la plus à gauche sur la ligne suivante si elle est libre
                if (this.board[ligne][col]) {
                    //le déplacer sur la ligne suivante
                    int ligneSuiv = ligne + 1;
                    if (ligneSuiv <= this.sizeBoard) {
                        this.board[ligneSuiv][col] = true;
                        this.board[ligne][col] = false;
                    } else {
                        this.board[0][col] = true;
                        this.board[0][col + 1] = false;
                        this.board[1][col] = true;
                    }
                }
            }
        }
    }

    public boolean verifierDiagonaleDroite(int indiceDiag) {
        /*
        Ecrire un algorithme qui vérifie qu'il n'y a pas plus d'une dame pour une diagonale 'droite' (qui va vers la droite en descendant) donnée.
        retourne true s'il n'y a pas plus d'une dame sur la diagonale

        diag 0 = 00, 11, 22, 33
        diag 1 = 01, 12, 23
        diag 2 = 02, 13
        diag 3 = 03
        diag -1 = 10, 21, 32
        diag -2 = 20, 31
        diag -3 = 30
         */
        int countDame = 0;

        if (Math.abs(indiceDiag) <= this.sizeBoard) {

            int turn = 0;
            int indexI, indexJ;
            int absIndiceDiag = Math.abs(indiceDiag);
            int loop = absIndiceDiag + turn;

            while (loop <= this.sizeBoard) {
                if (indiceDiag >= 0) {
                    indexI = turn;
                    indexJ = loop;
                } else {
                    indexI = loop;
                    indexJ = turn;
                }
                if (this.board[indexI][indexJ])
                    countDame++;
                turn++;
                loop = absIndiceDiag + turn;
            }
        }
        return (countDame <= 1);
    }

    public boolean verifierDiagonaleGauche(int indiceDiag) {
        /*
        Effectuer le même travail pour les diagonales gauches. Attention, les diagonales droites sont numérotées de -3 à 3,
        et les diagonales gauches sont numérotées de 0 à 6
        retourne true s'il n'y a pas plus d'une dame sur la diagonale
        | | | | |
        | | | | |
        | | | | |
        | | | |0|
        diag 0 = 00
        diag 1 = 01, 10
        diag 2 = 02, 11, 20
        diag 3 = 03, 12, 21, 30
        diag 4 = 13, 22, 31
        diag 5 = 23, 32
        diag 6 = 33
        on découpe l'indice afin qu'on obtienne les 2 chiffres qui font la somme tant que le chiffre est <= la taille du tableau
         */
        int countDame = 0;

        if (indiceDiag <= (this.sizeBoard * 2)) {
            int turn = 0;

            for (int i = 0; i <= this.sizeBoard; i++) {
                for (int j = 0; j <= this.sizeBoard; j++) {
                    turn = i + j;
                    if (turn == indiceDiag) {
                        if (this.board[i][j])
                            countDame++;
                    } else if (turn > indiceDiag) {
                        //on sort du j
                        break;
                    }
                }
            }
        }
        return (countDame <= 1);
    }

    public boolean verifierColonne(int indiceColonne) {
        /*
        Ecrire un algorithme qui vérifie qu'il n'y a pas plus d'une dame pour une colonne donnée
        retourne true s'il n'y a pas plus d'une dame sur la colonne
         */

        int countDame = 0;

        if (indiceColonne >= 0) {
            for (int ligne = 0; ligne <= this.sizeBoard; ligne++) {
                if (this.board[ligne][indiceColonne])
                    countDame++;
            }
        }
        return (countDame <= 1);
    }

    public boolean verifierLigne(int indiceLigne) {
        /*
        Ecrire un algorithme qui vérifie qu'il n'y a pas plus d'une dame pour une ligne donnée
        retourne true s'il n'y a pas plus d'une dame sur la ligne
        */
        int countDame = 0;

        if (indiceLigne >= 0) {
            for (int col = 0; col <= this.sizeBoard; col++) {
                if (this.board[indiceLigne][col])
                    countDame++;
            }
        }
        return (countDame <= 1);
    }

    private String afficherGrille() {
        /*la 1ère colonne et la 1ère ligne seront les indices à afficher
           0 1 2 3
        0 |X| |X| |
        1 | |X| | |
        2 | | | | |
        3 | | | |X|
        on commence les boucles à -1 pour simuler cela
         */

        StringBuilder result = new StringBuilder();
        char toDisplay = ' ';
        for (int indLigne = -1; indLigne <= this.sizeBoard; indLigne++) {
            for (int indCol = -1; indCol <= this.sizeBoard; indCol++) {
                if (indLigne == -1)
                    if (indCol != -1)
                        result.append(" " + indCol);
                    else
                        result.append("  ");
                else if (indCol == -1)
                    result.append(indLigne + " |");
                else
                    result.append((this.board[indLigne][indCol] ? "X" : " ") + "|");
            }
            result.append("\n");
        }
        return result.toString();
    }

    private void copyBoardValues(boolean[][] boardToCopy) {
        int lengthBoard = boardToCopy.length;

        for (int ligne = 0; ligne < lengthBoard; ligne++) {
            System.arraycopy(boardToCopy[ligne], 0, board[ligne], 0, lengthBoard);
        }
    }

}
