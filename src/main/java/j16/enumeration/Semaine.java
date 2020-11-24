package j16.enumeration;

public enum Semaine {
    LUNDI(false, ":-("),
    MARDI(false, ":-)"),
    MERCREDI(false, ":-)"),
    JEUDI(false, ":-)"),
    VENDREDI(false, ";-o"),
    SAMEDI(true, ":-o"),
    DIMANCHE(true, ";-)");

    private final boolean isWeekend;
    private final String smiley;

    Semaine(boolean isWE, String smiley) {
        this.isWeekend = isWE;
        this.smiley = smiley;
    }

    public boolean isWeekend() {
        return isWeekend;
    }

    public String getSmiley() {
        return smiley;
    }
}
