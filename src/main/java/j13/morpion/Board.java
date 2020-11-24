package j13.morpion;

class Board {
    private Output output;

    public Board(Output output) {
        this.output = output;
    }

    void afficherGrille(char[][] tabToDisplay){
        int tabLength =tabToDisplay.length;

        for(int indLigne=0; indLigne<tabLength; indLigne++){
            for(int indCol=0; indCol<tabLength; indCol++){
                this.output.displayContent(tabToDisplay[indLigne][indCol]+"|");
            }
            this.output.displayContentNewLine();
        }
    }
}
