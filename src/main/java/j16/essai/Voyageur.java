package j16.essai;

public class Voyageur {
    private int numeroVoyageur;
    private int numeroSiege;
    private String nom;
    private ClasseVoyageur classeVoyageur;

    public Voyageur(int numeroVoyageur, int numeroSiege, String nom, ClasseVoyageur classeVoyageur) {
        this.numeroVoyageur = numeroVoyageur;
        this.numeroSiege = numeroSiege;
        this.nom = nom;
        this.classeVoyageur = classeVoyageur;
    }

    public int getNumeroVoyageur() {
        return numeroVoyageur;
    }

    public int getNumeroSiege() {
        return numeroSiege;
    }

    public String getNom() {
        return nom;
    }

    public ClasseVoyageur getClasseVoyageur() {
        return classeVoyageur;
    }

    @Override
    public String toString() {
        return "Voyageur{" +
                "numeroVoyageur=" + numeroVoyageur +
                ", numeroSiege=" + numeroSiege +
                ", nom='" + nom + '\'' +
                ", classeVoyageur=" + classeVoyageur +
                '}';
    }

    //pour comparer on peut aussi faire implémenter l'interface Comparable ou Comparable<Voyageur>(permet d'avoir directement un voyageur)
    /*
    on compare le this avec l'élément transmis
    public int compareTo(Voyageur o){
        Voyageur compare =(Voyageur)o;
        int i = this.classeVoyageur.compareTo(compare.getClasseVoyageur);
        if(i==0)
            return this.numeroSiege - compere.getNumeroSiege;
     */


}
