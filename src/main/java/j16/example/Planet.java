package j16.example;

public enum Planet {
    MERCURE (1.2, 2.4),
    URANUS (3.6, 6.2);

    private final double mass;
    private final double radius;

    private Planet(double mass, double radius){
        this.mass =mass;
        this.radius =radius;
    }

    public double mass(){return mass;}
    public double radius(){return radius;}
}
