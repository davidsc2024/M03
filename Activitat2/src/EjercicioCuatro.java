import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class EjercicioCuatro {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nomFitxer;

        // Paso 1: Pedir un nombre de archivo que no exista
        while (true) {
            System.out.println("Escriu el nom del fitxer: ");
            nomFitxer = scanner.nextLine();

            File fitxer = new File(nomFitxer);
            if (fitxer.exists()) {
                System.out.println("El fitxer ja existeix. Escriu un altre nom.");
            } else {
                break;
            }
        }

        // Paso 2: Crear el archivo y comenzar a escribir en él
        try (FileWriter escriptor = new FileWriter(nomFitxer)) {
            System.out.println("Comença a escriure. Escriu un punt (.) per finalitzar.");

            while (true) {
                String linia = scanner.nextLine();

                // Si el usuario escribe solo un punto, termina el programa
                if (linia.equals(".")) {
                    System.out.println("S'ha finalitzat l'escriptura al fitxer.");
                    break;
                }

                // Escribir la línea en el archivo con un salto de línea
                escriptor.write(linia + System.lineSeparator());
            }
        } catch (IOException e) {
            System.out.println("Hi ha hagut un error: " + e.getMessage());
        }
    }
}
