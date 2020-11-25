package j16.essai;

import java.util.ArrayList;

public class TabFromList {
    private final ArrayList<ArrayList<Object>> tabList;
    private int indexCurrOne;

    public TabFromList() {
        this.tabList = new ArrayList<>();
        indexCurrOne = -1;
    }

    void addElement(Object obj, int posUn, int posDeux) {
        if (posUn > indexCurrOne) {
            //Crée le 1er niveau
            indexCurrOne = posUn;
            for (int i = 0; i <= posUn; i++) {
                try {
                    if (tabList.get(i) == null)
                        tabList.set(i, new ArrayList<>());
                } catch (IndexOutOfBoundsException e) {
                    tabList.add(new ArrayList<>());
                }
            }
        }
        //Crée le 2nd niveau
        //TODO cela crée un niveau de trop
        ArrayList<Object> al = tabList.get(posUn);
        for (int i = 0; i <= posDeux; i++) {
            if (al.size() <= posDeux)
                al.add(null);
        }
        //ajoute l'élément
        tabList.get(posUn).add(posDeux, obj);
    }

    Object getElement(int posUn, int posDeux) {
        Object obj;
        try {
            obj = tabList.get(posUn).get(posDeux);
        }
        catch(IndexOutOfBoundsException e){
            obj =null;
        }
        return  obj;
    }

    @Override
    public String toString() {
        return "TabFromList{" +
                "tabList=" + tabList +
                ", indexCurrOne=" + indexCurrOne +
                '}';
    }
}
