package EjercicioUno;

public class ProvaFigures {
    public static void main(String[] args) {
        // Crear objetos de las figuras
        Cercle cercle = new Cercle(5);
        Rectangle rectangle = new Rectangle(4, 7);
        Triangle triangle = new Triangle(6, 3);

        // Mostrar información de cada figura
        System.out.println("=== INFORMACIÓN DE LAS FIGURAS ===");
        cercle.visualitzar();
        System.out.println("-------------------------");
        rectangle.visualitzar();
        System.out.println("-------------------------");
        triangle.visualitzar();
    }
}