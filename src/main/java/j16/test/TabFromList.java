package j16.test;

import java.util.ArrayList;

public class TabFromList {
    private ArrayList dim1 =new ArrayList<>();
    private ArrayList dim2 =new ArrayList<>();
    private ArrayList<ArrayList> tabList;
    private int dimensionUn;
    private int dimensionDeux;

    public TabFromList() {
        this.tabList =new ArrayList<>();
    }

    void addElementInFirstIndex(Object obj){
        ArrayList newtab =new ArrayList();
        newtab.add(obj);
        tabList.add(newtab);
    }

    void addElement(Object obj, int posUn, int posDeux){
        for (int i = 0; i < posUn; i++) {
            if (tabList.get(i)==null)
                tabList.add(new ArrayList());
        }
        for (int i = 0; i <posDeux; i++) {
            ArrayList al =tabList.get(posUn);
            if (al.get(i)==null)
                al.add(null);
            //al.get(i)=obj;
        }
        //tabList.get(posUn)[posDeux].
        //tabList.get(posUn).get(posDeux) =obj;

    }

     Object getElement(int posUn, int posDeux){
        return tabList.get(posUn).get(posDeux);
    }
}
