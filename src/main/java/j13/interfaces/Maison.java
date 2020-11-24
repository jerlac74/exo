package j13.interfaces;

public class Maison extends Batiment implements AvecChauffage, AvecClimatisation {

    @Override
    public void chauffer() {
        super.temperature++;
    }

    @Override
    public void refroidir() {
        super.temperature--;
    }

}
