import java.io.*;
import java.util.Scanner;

public class EjercicioTres {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Pedir el camino del archivo
        System.out.println("Introduce la ruta del archivo:");
        String rutaFitxer = scanner.nextLine();

        File fitxer = new File(rutaFitxer);

        if (!fitxer.exists()) {
            System.out.println("El archivo no existe.");
            return;
        }

        // Leer el archivo y contar las palabras
        try (BufferedReader lector = new BufferedReader(new FileReader(fitxer))) {
            String linia;
            int numLinia = 1;

            while ((linia = lector.readLine()) != null) {
                // Si la línea es "fi", terminamos
                if (linia.trim().equalsIgnoreCase("fi")) {
                    break;
                }

                // Contar palabras en la línea
                int numParaules = contarParaules(linia);
                System.out.println("La línia " + numLinia + " té " + numParaules + " paraules.");
                numLinia++;
            }

        } catch (IOException e) {
            System.out.println("Ha ocurrido un error al leer el archivo: " + e.getMessage());
        }
    }

    // Método para contar palabras en una línea
    public static int contarParaules(String linia) {
        // Dividir la línea en palabras usando espacios como separador
        String[] paraules = linia.trim().split("\\s+");
        return paraules.length;
    }
}
