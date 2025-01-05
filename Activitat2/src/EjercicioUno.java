import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class EjercicioUno {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        System.out.println("Introduce el nombre del archivo: ");
        String path = s.nextLine();
        
        System.out.println("Introduce un texto: ");
        String userText = s.nextLine();
        
        // Cambiar entre mayúsculas y minúsculas antes de escribir en el archivo
        String toggledText = toggleCase(userText);
        System.out.println("Texto transformado: " + toggledText);
        
        // Escribir en el archivo
        writeToFile(path, toggledText);
        
        // Leer del archivo y mostrar en mayúsculas
        convertCase(path);
        
        s.close();
    }
    
    // Método para cambiar entre mayúsculas y minúsculas
    public static String toggleCase(String input) {
        StringBuilder result = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (Character.isUpperCase(c)) {
                result.append(Character.toLowerCase(c));
            } else if (Character.isLowerCase(c)) {
                result.append(Character.toUpperCase(c));
            } else {
                result.append(c); // Mantener caracteres que no son letras
            }
        }
        return result.toString();
    }
    
    // Método para escribir en el archivo
    public static void writeToFile(String path, String text) {
        File f = new File(path);
        
        try (PrintStream writer = new PrintStream(f)) {
            writer.print(text);
            System.out.println("Texto escrito en el archivo con éxito.");
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error al escribir en el archivo: " + e.getMessage());
        }
    }
    
    // Método para leer del archivo y mostrar el contenido en mayúsculas
    public static void convertCase(String path) {
        File f = new File(path);
        
        if (f.exists()) {
            try (Scanner reader = new Scanner(f)) {
                System.out.println("Contenido del archivo en mayúsculas:");
                while (reader.hasNextLine()) {
                    String line = reader.nextLine();
                    System.out.println(line.toUpperCase());
                }
            } catch (IOException e) {
                System.out.println("Ha ocurrido un error al leer el archivo: " + e.getMessage());
            }
        } else {
            System.out.println("El archivo no existe.");
        }
    }
}
