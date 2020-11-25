package j16.essai;

import java.util.*;

public class MainEssai {
    public static void main(String[] args) {
        System.out.println("MainTest");
        String[] textes =new String[]{"Toto", "test 1", "test 2", "test 3", "autre texte"};

        List<String> listStr =new ArrayList<>();
        listStr.add("Toto00");
        listStr.add("test1");
        listStr.add("tes2");
        listStr.add("tesb56");
        listStr.add("autre texte89");
        listStr.addAll(Arrays.asList(textes));

        System.out.println("avant Tri displayCollection");
        displayCollection(listStr);

        System.out.println("Après tri");
        Collections.sort(listStr);
        displayCollection(listStr);

        System.out.println("Tri listStr2 sur ordre alphabétique");
        List<String> listStr2 =new ArrayList<>();
        listStr2.addAll(Arrays.asList(textes));
        System.out.println("  avant tri");
        displayCollection(listStr2);
        System.out.println("  après tri");
        listStr2.sort(new AlphaComparator());
        displayCollection(listStr2);

        System.out.println("Collection PriorityQueue");
        PriorityQueue<String> pq =new PriorityQueue<>();
        for (String texte : textes) {
            pq.add(texte);
        }
        displayCollection(pq);

        //Collections.sort(Arrays.asList(pq.toArray()));
        System.out.println("Après tri Queue");

        //Tab à 2 dimensions avec 2 listes
        System.out.println("Tab à 2 dimensions avec 2 listes");
        TabFromList tfl =new TabFromList();
        tfl.addElement("Test1", 0,0);
        tfl.addElement("Test2",0,2);
        tfl.addElement("Test3", 2,1);
        tfl.addElement(new int[]{1,3,6,5}, 2,1);
        System.out.println("Affichage de la liste de liste");
        System.out.println(tfl);

        //Test Voyageur
        int cnt=0;
        Voyageur v1=new Voyageur(++cnt,12,"voya"+cnt, ClasseVoyageur.ECO);
        Voyageur v2=new Voyageur(++cnt,28,"voya"+cnt, ClasseVoyageur.PREMIERE);
        Voyageur v3=new Voyageur(++cnt,15,"voya"+cnt, ClasseVoyageur.ECO);
        Voyageur v4=new Voyageur(++cnt,25,"voya"+cnt, ClasseVoyageur.BUSINESS);
        Voyageur v5=new Voyageur(++cnt,53,"voya"+cnt, ClasseVoyageur.PREMIERE);
        Voyageur v6=new Voyageur(++cnt,49,"voya"+cnt, ClasseVoyageur.BUSINESS);

        PriorityQueue<Voyageur> fileAttente =new PriorityQueue<>(new VoyageurComparator());
        fileAttente.add(v1);
        fileAttente.add(v2);
        fileAttente.add(v3);
        fileAttente.add(v4);
        fileAttente.add(v5);
        fileAttente.add(v6);

        //là on affiche selon l'ordre de println qui n'est pas celui dans la priorityQueue
        //La priorityQueue n'est pas trié directement, c'est juste en sortant les éléments via poll.
        //Avec ce for for (Voyageur voyageur : fileAttente) on n'est pas trié
        System.out.println("affichage voyageur avec un for quelconque");
        for (Voyageur voyageur : fileAttente) {
            System.out.println(voyageur);
        }

        System.out.println("affichage trié des voyageurs via le poll");

        int size = fileAttente.size();
        for (int i = 0; i < size; i++) {
            System.out.println(fileAttente.poll());
        }
    }

    public static void displayCollection(Collection<String> colToDisplay){
        for (String s : colToDisplay) {
            System.out.print(s+", ");
        }
        System.out.println();
    }
}
