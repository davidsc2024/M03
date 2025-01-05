package EjercicioUno;

public class FiguraGeometrica {
    private int codigo;
    private String nom;
    private String color;

    // Constructor
    public FiguraGeometrica(int codigo, String nom, String color) {
        this.codigo = codigo;
        this.nom = nom;
        this.color = color;
    }

    // Getter y Setter de codigo
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    // Getter y Setter de nom
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    // Getter y Setter de color
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

}
