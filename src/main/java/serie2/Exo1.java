package serie2;

import java.util.*;

public class Exo1 {
    /*
    Jeu des 8 dames
     */

    private final int sizeBoard;
    private final boolean[][] board;
    private HashMap<Integer, Integer> positionsDames;

    public Exo1(int sizeBoard) {
        this.sizeBoard = sizeBoard;
        this.board = new boolean[this.sizeBoard][this.sizeBoard];

        //On initialise avec les dames en 1ère ligne
        initArrayIfEmpty();
    }

    public Exo1(boolean[][] board) {
        this.sizeBoard = board.length;
        this.board = new boolean[this.sizeBoard][this.sizeBoard];

        copyBoardValues(board, this.board);
    }

    public boolean[][] getBoard() {
        return board;
    }

    public boolean[][] cloneBoard() {
        boolean[][] copy = new boolean[this.sizeBoard][this.sizeBoard];

        copyBoardValues(board, copy);

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
        int lengthTab = this.sizeBoard - 1;

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

    public LinkedList<boolean[][]> findSolutions() {
        /*
        Regarder si votre plateau est une solution au problème (pas deux dames sur la même ligne, colonne, diagonale gauche ou diagonale droite).
        Si c'est cohérent, stocker une copie de cette solution dans une liste
        Passer à la possibilité suivante
         */
        LinkedList<boolean[][]> resultListe = new LinkedList<>();

        try {
            while (true) {
                nextMoveNaif();
                if (estUneSolution()) {
                    resultListe.add(cloneBoard());
                }
            }
        } catch (JeuDamesException exp) {
            //Fin du parcours
        }
        return resultListe;
    }

    public void nextMoveNaif() throws JeuDamesException {
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
        findDamesPositions();

        //déplacer selon la règle
        //commencer par déplacer la dame la plus à gauche d'une ligne vers le bas si possible
        int lignePos;
        int previousCol;
        boolean hasMove = false;
        for (int col = 0; col < this.sizeBoard; col++) {
            lignePos = positionsDames.get(col);
            if (lignePos < this.sizeBoard - 1) {
                //on n'est pas sur la dernière ligne alors on peut décaler d'un en-dessous
                this.board[lignePos + 1][col] = true;
                this.board[lignePos][col] = false;
                positionsDames.replace(col, lignePos + 1);
                hasMove = true;
                if (col != 0) {
                    previousCol = col - 1;
                    while (previousCol >= 0) {
                        //on remonte le précédent
                        this.board[0][previousCol] = true;
                        this.board[this.sizeBoard - 1][previousCol] = false;
                        positionsDames.replace(previousCol, 0);
                        previousCol--;
                    }
                }
                break;
            }
            //si on n'a pas fait de mouvement alors c'était que la dame de la colonne était sur la dernière ligne,
            // on va chercher à déplacer le suivant via la boucle for
        }
        if (!hasMove) {
            //il n'y a pas eu de mouvement => on propage un exception
            throw new JeuDamesException("il n'y a plus de mouvements possible !");
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

        if (Math.abs(indiceDiag) < this.sizeBoard) {

            int turn = 0;
            int indexI, indexJ;
            int absIndiceDiag = Math.abs(indiceDiag);
            int loop = absIndiceDiag + turn;

            while (loop < this.sizeBoard) {
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

        if (indiceDiag <= ((this.sizeBoard - 1) * 2)) {
            int turn = 0;

            for (int i = 0; i < this.sizeBoard; i++) {
                for (int j = 0; j < this.sizeBoard; j++) {
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
            for (int ligne = 0; ligne < this.sizeBoard; ligne++) {
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
            for (int col = 0; col < this.sizeBoard; col++) {
                if (this.board[indiceLigne][col])
                    countDame++;
            }
        }
        return (countDame <= 1);
    }

    //[Private Methods]

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
        for (int indLigne = -1; indLigne < this.sizeBoard; indLigne++) {
            for (int indCol = -1; indCol < this.sizeBoard; indCol++) {
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

    private void copyBoardValues(boolean[][] boardSrc, boolean[][] boardDest) {
        int lengthBoard = boardSrc.length;

        for (int ligne = 0; ligne < lengthBoard; ligne++) {
            System.arraycopy(boardSrc[ligne], 0, boardDest[ligne], 0, lengthBoard);
        }
    }

    private void findDamesPositions() {
        /*
        Sert à conserver la position actuelle des dames du tableau.
        Ces positions seront utilisées pour déterminer les prochains mouvements.
        this.positionsDames contient les dames via leur position avec key=colonne, value=ligne
         */

        //this.sizeBoard nous donne le nombre de dames à trouver
        int count = 0;

        if (this.positionsDames == null) {
            this.positionsDames = new HashMap<>();
        }

        if (this.positionsDames.size() == 0) {
            for (int ligne = 0; ligne < this.sizeBoard; ligne++) {
                for (int col = 0; col < this.sizeBoard; col++) {
                    if (this.board[ligne][col]) {
                        positionsDames.put(col, ligne);
                        count++;
                        if (count == this.sizeBoard)
                            break;
                    }
                }
                if (count == this.sizeBoard)
                    break;
            }
        }
    }

    private void initArrayIfEmpty() {
        /*
        //On initialise avec les dames en 1ère ligne si le tableau est vide
         */
        findDamesPositions();
        if (this.positionsDames.size() == 0) {
            //Aucune dame n'a été positionné dans le tableau
            for (int i = 0; i < this.sizeBoard; i++) {
                this.board[0][i] = true;
            }
        }
    }
}
