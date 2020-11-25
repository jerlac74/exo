package j16.essai;

import java.util.Comparator;

public class VoyageurComparator implements Comparator<Voyageur> {
    @Override
    public int compare(Voyageur v1, Voyageur v2) {
        int compVal =v1.getClasseVoyageur().ordinal() - v2.getClasseVoyageur().ordinal();
        if(compVal==0)
            compVal =v1.getNumeroSiege() - v2.getNumeroSiege();

        return compVal;
    }
}
