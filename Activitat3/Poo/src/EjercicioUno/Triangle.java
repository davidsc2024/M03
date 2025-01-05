package EjercicioUno;

public class Triangle {
    private double base;
    private double altura;

    // Constructor
    public Triangle(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    // Getter y Setter de base
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
        return (base * altura) / 2;
    }

    // Funcion perimetro
    public String perimetro() {
        return "No se puede calcular el perímetro sin información de los otros lados.";
    }

    // Fucnion visualitzar
    public void visualitzar() {
        System.out.println("Triángulo:");
        System.out.println("Base: " + base + ", Altura: " + altura);
        System.out.println("Área: " + area());
        System.out.println("Perímetro: " + perimetro());
    }
}
