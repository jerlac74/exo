package j16.exstring;

public class MainExString {
    public static void main(String[] args) {
        String test = "Mon Texte avec des 'a' et des aAbaC";
        System.out.println(toUpper(test));
        System.out.println(nbreA(test));
        System.out.println(transformAen4(test));
        try {
            System.out.println(suppr5to10(test));
        } catch (RuntimeException e) {
            System.out.println("Exception occured :" + e.getMessage());
        }
        System.out.println(transformIntToString(26));
        System.out.println(transformStringToInt("263"));

        ChaineDecoString cds = new ChaineDecoString(test + "ueous adevbat");
        System.out.println(cds.toUpper());
        System.out.println(cds.nbreA());
        System.out.println(cds.transformAen4());
        try {
            System.out.println(cds.suppr5to10());
        } catch (RuntimeException e) {
            System.out.println("Exception occured :" + e.getMessage());
        }
        System.out.println(cds.transformIntToString(256));
        System.out.println(cds.transformStringToInt("48569"));

    }

    public static String toUpper(String str) {
        return str.toUpperCase();
    }

    public static int nbreA(String str) {
        int cntA = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'a')
                cntA++;
        }

        return cntA;
    }

    public static String transformAen4(String str) {
        return str.replace('a', '4');
    }

    public static String suppr5to10(String str) {
        if (str.length() < 10)
            throw new RuntimeException("Le texte doit contenir au minimum 10 caractères");
        return str.substring(0, 5) + str.substring(10);
    }

    public static String transformIntToString(int intVal) {
        return String.valueOf(intVal);
    }

    public static int transformStringToInt(String str) {
        return Integer.valueOf(str);
        //ou parseInt
    }
}

