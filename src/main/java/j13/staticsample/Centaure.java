package j13.staticsample;

public class Centaure {
    static final int NOMBRE_BRAS=2;
    static final int NOMBRE_PATTES=4;

    private static int population=0;

    public static int getPopulation(){
        return population;
    }

    Centaure(){
        Centaure.population++;
    }


    @Override
    public String toString() {
        return "population:"+Centaure.population;
    }

/*    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        population--;
    }
*/
}
