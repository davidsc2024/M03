package EjercicioUno;

public class Cercle {
    private double radi;

    // Constructor
    public Cercle(double radi) {
        this.radi = radi;
    }

    // Getter y Setter de radi
    public double getRadi() {
        return radi;
    }

    public void setRadi(double radi) {
        this.radi = radi;
    }

    // Funcion area
    public double area() {
        return Math.PI * Math.pow(radi, 2);
    }

    // Funcion perimetro
    public double perimetro() {
        return 2 * Math.PI * radi;
    }

    // Funcion visualizar
    public void visualitzar() {
        System.out.println("Círculo:");
        System.out.println("Radio: " + radi);
        System.out.println("Área: " + area());
        System.out.println("Perímetro: " + perimetro());
    }
}
