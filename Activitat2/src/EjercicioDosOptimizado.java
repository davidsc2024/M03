import java.io.*;
import java.util.Scanner;

public class EjercicioDosOptimizado {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Pedir rutas de los dos archivos de texto
        System.out.println("Introduce la ruta del primer archivo:");
        String rutaArchivo1 = scanner.nextLine();

        System.out.println("Introduce la ruta del segundo archivo:");
        String rutaArchivo2 = scanner.nextLine();

        // Pedir la ruta de destino
        System.out.println("Introduce la ruta de destino (solo la carpeta):");
        String rutaDestino = scanner.nextLine();

        // Intentar combinar los archivos
        try {
            combinarArchivos(rutaArchivo1, rutaArchivo2, rutaDestino);
        } catch (IOException e) {
            System.out.println("Error al combinar archivos: " + e.getMessage());
        }

        scanner.close();
    }

    public static void combinarArchivos(String ruta1, String ruta2, String rutaDestino) throws IOException {
        File archivo1 = new File(ruta1);
        File archivo2 = new File(ruta2);

        // Comprobar si ambos archivos existen
        if (!archivo1.exists() || !archivo2.exists()) {
            System.out.println("Uno o ambos archivos no existen.");
            return;
        }

        // Crear el nombre combinado del archivo de destino
        String nombreCombinado = archivo1.getName().replace(".txt", "") + "_" + archivo2.getName().replace(".txt", "") + ".txt";
        File archivoDestino = new File(rutaDestino, nombreCombinado);

        // Verificar si el archivo de destino ya existe
        if (archivoDestino.exists()) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("El archivo destino ya existe. ¿Deseas sobreescribirlo? (sí/no)");
            String respuesta = scanner.nextLine();

            if (!respuesta.equalsIgnoreCase("sí")) {
                System.out.println("No se realizará ninguna operación.");
                return;
            }
        }

        // Copiar el contenido de los dos archivos en el archivo destino
        copiarContenido(archivo1, archivoDestino);
        copiarContenido(archivo2, archivoDestino);

        System.out.println("Archivos combinados exitosamente en: " + archivoDestino.getAbsolutePath());
    }

    public static void copiarContenido(File origen, File destino) throws IOException {
        // Usar FileWriter en modo append para combinar contenido
        try (BufferedReader reader = new BufferedReader(new FileReader(origen));
             BufferedWriter writer = new BufferedWriter(new FileWriter(destino, true))) {

            String linea;
            while ((linea = reader.readLine()) != null) {
                writer.write(linea);
                writer.newLine(); // Añade salto de línea después de cada línea escrita
            }
        }
    }
}
