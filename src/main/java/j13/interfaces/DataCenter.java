package j13.interfaces;

public class DataCenter extends Batiment implements AvecClimatisation {

    @Override
    public void refroidir() {
        super.temperature = 20;
    }
}
