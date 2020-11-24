package j13;

public class Main {

    public static void main(String[] args) {
        // write your code here
        /*
        System.out.println("Texte");

        System.out.println("A faire 2");
        int[] tab = new int[10];
        for (int i = 0; i < tab.length; i++) {
            System.out.println("for i:" + i);
            tab[i]=i*10;
        }
        for (int i : tab) {
            System.out.println(" for tab i:" + i);
        }
        */
        Enfant enf = new Enfant("MyName", "oliver", "3 rue des orfèvres");
        System.out.println(enf.sePresenter());

        System.out.println();

        Vehicule vehi =new Velo();
        System.out.println(vehi.getClass()); //=> affiche class j13.exo.Velo

        Velo velo = new Velo();
        velo.direBonjour();
        System.out.println(velo);

        Train train =new Train();
        train.direBonjour();
        System.out.println(train);

        String s1="chat";
        String s2="chat";
        if(s1.equals(s2))
            System.out.println("S1 et S2 sont équivalents.");
        else
            System.out.println("S1 et S2 ne sont pas équivalents.");

    }
}
