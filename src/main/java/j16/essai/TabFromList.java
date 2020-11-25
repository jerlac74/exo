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
        createFirstLevelIfNeeded(posUn);
        //Crée le 2nd niveau
        createSecondLevelIfNeeded(posUn, posDeux);
        //ajoute l'élément
        tabList.get(posUn).add(posDeux, obj);
    }

    void setElement(Object obj, int posUn, int posDeux) {
        createFirstLevelIfNeeded(posUn);
        //Crée le 2nd niveau
        createSecondLevelIfNeeded(posUn, posDeux);
        //ajoute l'élément
        tabList.get(posUn).set(posDeux, obj);
    }

    private void createSecondLevelIfNeeded(int posUn, int posDeux) {
        ArrayList<Object> al = tabList.get(posUn);
        for (int i = 0; i <= posDeux; i++) {
            if (al.size() < posDeux +1)
                al.add(null);
        }
    }

    private void createFirstLevelIfNeeded(int posUn) {
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
