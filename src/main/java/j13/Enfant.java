package j13;

/**
 * classe Enfant
 */
public class Enfant {

    protected String nom;
    protected String prenom;
    protected int age;
    protected String adresse;

    public Enfant(String nom, String prenom, String adresse) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String sePresenter() {
        StringBuilder strb = new StringBuilder();
        strb.append("Je suis ");
        strb.append(this.prenom);
        strb.append(" ");
        strb.append(this.nom.toUpperCase());
        strb.append("\n");
        strb.append("j'habite ");
        strb.append(this.adresse);
        return strb.toString();
    }
}
