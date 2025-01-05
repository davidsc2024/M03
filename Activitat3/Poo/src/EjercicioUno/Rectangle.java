package EjercicioUno;

public class Rectangle {
    private double base;
    private double altura;
    
    // Constructor
    public Rectangle(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    // Getter y setter de base
    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    // Getter y Setter de altura
    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    // Funcion area
    public double area() {
        return base * altura;
    }

    // Funcion perimetro
    public double perimetro() {
        return 2 * (base + altura);
    }

    // Funcion visualizar
    public void visualitzar() {
        System.out.println("Rectángulo:");
        System.out.println("Base: " + base + ", Altura: " + altura);
        System.out.println("Área: " + area());
        System.out.println("Perímetro: " + perimetro());
    }

    
}
