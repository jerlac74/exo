package j13.interfaces;

public class MainInter {

    public static void main(String[] args) {

        Maison maison =new Maison();
        maison.chauffer();
        System.out.println("Maison:"+maison);
        maison.chauffer();
        maison.chauffer();
        maison.chauffer();
        maison.chauffer();
        maison.chauffer();
        System.out.println("Maison:"+maison);
        maison.refroidir();
        maison.refroidir();
        System.out.println("Maison:"+maison);

        DataCenter dc =new DataCenter();
        dc.refroidir();
        System.out.println("DC:"+dc);

    }
}
