package j16.exstring;

public class ChaineDecoString {
    private String origineString;

    public ChaineDecoString(String origineString) {
        this.origineString = origineString;
    }

    public String toUpper(){
        return this.origineString.toUpperCase();
    }

    public int nbreA(){
        int cntA=0;
        for (int i = 0; i < this.origineString.length(); i++) {
            if(this.origineString.charAt(i)=='a')
                cntA++;
        }

        return cntA;
    }

    public String transformAen4(){
        return this.origineString.replace('a','4');
    }

    public String suppr5to10(){
        if(this.origineString.length()<10)
            throw new RuntimeException("Le texte doit contenir au minimum 10 caractères");
        return this.origineString.substring(0,5)+this.origineString.substring(10);
    }

    public String transformIntToString(int intVal){
        return String.valueOf(intVal);
    }

    public int transformStringToInt(String str){
        return Integer.valueOf(str);
    }
}
