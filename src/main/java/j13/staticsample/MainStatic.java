package j13.staticsample;

public class MainStatic {

    public static void main(String[] args) {
        Centaure centaure =new Centaure();
        System.out.println(centaure.toString());

        Centaure cent =new Centaure();
        System.out.println(Centaure.getPopulation());
        System.out.println("Autre:"+Centaure.getPopulation());
        Centaure cent1=null;
        System.out.println("Autre 1:"+Centaure.getPopulation());

        Dictionnaire dico0 = Dictionnaire.getInstance();
        Dictionnaire dico1 = Dictionnaire.getInstance();
        Dictionnaire dico2 = Dictionnaire.getInstance();

        Factorielle fact =new Factorielle();
        int retour=0;
        try {
            //déclencher uen exception sur nombre < 0 et à partir de 13.
            retour =Factorielle.calculer(-1);
        }
        catch (FactorielleException e){
            //on pourrait utiliser Exception e au lieu du nôtre.
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        System.out.println("retour:"+retour);
    }
}
