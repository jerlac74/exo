package j13.morpion;

import java.text.MessageFormat;
import java.util.Scanner;

public class Game {
    private final char CHARX = 'X';
    private final char CHARO = 'O';
    private final int BORNE_TAB = 3;
    private final int MAX_TOUR = BORNE_TAB * BORNE_TAB;

    private final ScreenOutput screenOutput;
    private final Board board;

    public Game() {
        this.screenOutput = new ScreenOutput();
        this.board = new Board(this.screenOutput);
    }

    public void launch() {
        Scanner sc = new Scanner(System.in);

        this.screenOutput.displayContentNewLine("Jeu du morpion");
        //System.out.println("Jeu du morpion");

        //1 ligne et 1 colonne d'entête et un tab 3x3 pour le morpion
		/*si la borne est différente à 3, il faut modifier :
		- l'initialisation pour faire apparaitre l'entête
		- les tests de valeur des saisies
		Lors de l'init, il faut créer un tableau avec les bonnes données qui servira à faire les vérifications de saisie
		*/
        char[][] tabToPlay = initTab(BORNE_TAB);

        board.afficherGrille(tabToPlay);

        int nombreTour = run(sc, tabToPlay);

        if (nombreTour == MAX_TOUR) {
            this.screenOutput.displayContentNewLine();
            this.screenOutput.displayContentNewLine("Jeu terminé : il n'y a aucun vainqueur !");
        }
    }

    private char[][] initTab(int indexMorpion) {
        //1 ligne et 1 colonne d'entête et un tab nxn pour le morpion
        int borne = indexMorpion + 1;
        char[][] tabInit = new char[borne][borne];
        char toWrite;

        for (int indLigne = 0; indLigne < borne; indLigne++) {
            for (int indCol = 0; indCol < borne; indCol++) {
                toWrite = ' ';
                //en 1ère ligne 0, on écrit les noms de colonnes
                if (indLigne == 0) {
                    if (indCol == 1)
                        toWrite = '1';
                    else if (indCol == 2)
                        toWrite = '2';
                    else if (indCol == 3)
                        toWrite = '3';
                } else {
                    //en 1ère colonne, on inscrit A B ou C sauf sur la 1ère ligne
                    if (indCol == 0) {
                        if (indLigne == 1)
                            toWrite = 'A';
                        else if (indLigne == 2)
                            toWrite = 'B';
                        else if (indLigne == 3)
                            toWrite = 'C';
                    }
                }

                tabInit[indLigne][indCol] = toWrite;
            }
        }

        return tabInit;
    }

    private int ligneIndex(String ligneInput) {
        /*
		fournit l'index de la ligne du tableau associée à la lettre saisie ou -1 si la donnée ne convient pas
		*/
        int result = -1;

        char inputUpper = ligneInput.toUpperCase().charAt(0);
        if (inputUpper == 'A') {
            result = 1;
        } else if (inputUpper == 'B') {
            result = 2;
        } else if (inputUpper == 'C') {
            result = 3;
        }

        return result;
    }

    private char hasWon(char[][] tabToCheck) {
		/*
		on gagne si on a le même caractère :
		- sur toute la ligne
		- ou sur toute la colonne
		- ou en diagonale

		retourne ' ' si personne n'a gagné ou X ou O pour désigner le vainqueur
		*/

        int borne = tabToCheck.length;

        int cntXCol, cntXLine, cntOCol, cntOLine;
        int cntXDiagOne = 0;
        int cntXDiagTwo = 0;
        int cntODiagOne = 0;
        int cntODiagTwo = 0;

        char symbolCurr;
        char symbolCurrLine;
        char symbolCurrCol;

        for (int indLigne = 1; indLigne < borne; indLigne++) {
            cntXCol = 0;
            cntOCol = 0;
            cntXLine = 0;
            cntOLine = 0;
            for (int indCol = 1; indCol < borne; indCol++) {
                //on vérifie les colonnes de la ligne
                symbolCurrCol = tabToCheck[indLigne][indCol];
                if (symbolCurrCol == CHARX)
                    cntXCol++;
                else if (symbolCurrCol == CHARO)
                    cntOCol++;
                //pour vérifier la ligne, on inverse les indices du tableau
                symbolCurrLine = tabToCheck[indCol][indLigne];
                if (symbolCurrLine == CHARX)
                    cntXLine++;
                else if (symbolCurrLine == CHARO)
                    cntOLine++;
            }
            if (cntXCol == 3 || cntXLine == 3)
                return CHARX;
            if (cntOCol == 3 || cntOLine == 3)
                return CHARO;

            //Vérification des 2 diagonales, on utilise les positions directement
            //1ère  : tabToCheck[1][1] + tabToCheck[2][2] + tabToCheck[3][3];
            //2ième : tabToCheck[1][3] + tabToCheck[2][2] + tabToCheck[3][1];
            symbolCurr = tabToCheck[indLigne][indLigne];
            if (symbolCurr == CHARX) {
                cntXDiagOne++;
                if (cntXDiagOne == 3)
                    return CHARX;
            } else if (symbolCurr == CHARO) {
                cntODiagOne++;
                if (cntODiagOne == 3)
                    return CHARO;
            }

            symbolCurr = tabToCheck[indLigne][borne - indLigne];
            if (symbolCurr == CHARX) {
                cntXDiagTwo++;
                if (cntXDiagTwo == 3)
                    return CHARX;
            } else if (symbolCurr == CHARO) {
                cntODiagTwo++;
                if (cntODiagTwo == 3)
                    return CHARO;
            }
        }

        return ' ';
    }

    private int run(Scanner sc, char[][] tabToPlay) {
        int numPlayer = 1;
        int nombreTour = 0;
        char currVal, vainqueur, toWrite;
        String ligneInput;
        int ligneIndex, colInput;

        while (nombreTour != MAX_TOUR) {
            //demande de saisie pour le joueur
            this.screenOutput.displayContentNewLine(MessageFormat.format("Choix du Joueur {0}", numPlayer));
            this.screenOutput.displayContentNewLine("Donnez le nom de la ligne A, B ou C :");

            //récupère la saisie de l'utilisateur
            ligneInput = sc.next();
            ligneIndex = ligneIndex(ligneInput);

            if (ligneIndex != -1) {
                this.screenOutput.displayContentNewLine("Donnez l'indice de colonne 1, 2 ou 3 :");

                //récupère la saisie de l'utilisateur
                colInput = checkColInput(sc.next());

                if (colInput > 0 && colInput <= BORNE_TAB) {
                    currVal = tabToPlay[ligneIndex][colInput];
                    if (currVal != CHARO && currVal != CHARX) {
                        toWrite = CHARX;
                        if (numPlayer == 2)
                            toWrite = CHARO;
                        tabToPlay[ligneIndex][colInput] = toWrite;

                        this.board.afficherGrille(tabToPlay);

                        vainqueur = hasWon(tabToPlay);

                        if (vainqueur == CHARX) {
                            this.screenOutput.displayContentNewLine("Le joueur 1 a gagné");
                            break;
                        } else if (vainqueur == CHARO) {
                            this.screenOutput.displayContentNewLine("Le joueur 2 a gagné");
                            break;
                        }

                        if (numPlayer == 1)
                            numPlayer = 2;
                        else
                            numPlayer = 1;

                        nombreTour++;
                    } else
                        this.screenOutput.displayContentNewLine("Une valeur existe déjà à cet emplacement");
                } else
                    this.screenOutput.displayContentNewLine(MessageFormat.format("L''indice de colonne doit être 1, 2 ou 3. Vous avez écrit: {0}", colInput));
            } else
                this.screenOutput.displayContentNewLine(MessageFormat.format("Le nom de la ligne doit être A, B ou C. Vous avez écrit : {0}", ligneInput));
        }

        return nombreTour;
    }

    private int checkColInput(String colInput) {
        int retValue;
        try {
            retValue = Integer.parseInt(colInput);
        } catch (NumberFormatException e) {
            retValue = 0;
        }
        return retValue;
    }
}
