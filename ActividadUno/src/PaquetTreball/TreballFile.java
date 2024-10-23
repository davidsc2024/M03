package PaquetTreball;
import java.util.Scanner;
import java.io.File;

//Ejercicios
public class TreballFile {
    public static Scanner userInput = new Scanner(System.in); //Scanner para usar en todos los metodos

    //Ejercicio uno
    public static void ejercicioUno() {
        System.out.println("Introduce el nombre de un archivo o una carpeta: ");
        File f = new File(userInput.nextLine()); //Guardamos lo que ingresa el usuario en un objeto tipo File

        /*Nos aseguramos de que exista, en caso contrario nos arroja un mensaje de error.
        Si existe entra en otra condición para saber si es directorio o archivo y nos da su ruta absoluta y su nombre.*/
        if (f.exists()) {
            if (f.isDirectory()) {
                System.out.println("Es un directorio.\nRuta absoluta: " + f.getAbsolutePath() + "\nNombre del directorio: " + f.getName());
            } else if (f.isFile()) {
                System.out.println("Es un archivo.\nRuta absoluta: " + f.getAbsolutePath() + "\nNombre del archivo: " + f.getName());
                
            }
        } else {
            System.out.println("El directorio o archivo que has introducido no existe.");
        }
    }

    //Ejercicio dos
    public static void ejercicioDos() {
        System.out.println("Introduce un directorio: ");
        File f = new File(userInput.nextLine()); //Guardamos lo que ingresa el usuario en un objeto tipo File

        if (f.isDirectory()) {      //Primera condición donde verificamos que sea un directorio, en caso contrario un mensaje de error.
            File[] arrayF = f.listFiles();      //Si es un directorio se crea un array tipo File donde guardamos la lista de archivos y directorios
            if (arrayF != null && arrayF.length > 0) {      //Si arrayF no es nulo y tiene más de 1 directorio/archivo, entra en un bucle
                for (int i = 0; i < arrayF.length; i++) {       //Iteramos sobre la longitud del arrayF
                    File archivoCarpeta = arrayF[i];            //Guardamos cada iteración en un objeto tipo File para manipular mejor los datos
                    if (archivoCarpeta.isDirectory()) {         //Si la iteración es un directorio, se crea un mensaje con su nombre y su tipo
                        System.out.println(archivoCarpeta.getName() + " Es un directorio.");
                    } else if (archivoCarpeta.isFile()) {       //Si la iteración es un archivo, se crea un mensaje con su nombre y su tipo
                        System.out.println(archivoCarpeta.getName() + " Es un archivo.");
                    }
                }
            } else {
                System.out.println("El directorio está vacio.");
            }

        } else {
            System.out.println("No es un directorio.");
        }
    }

    //Ejercicio tres
    public static void ejercicioTres() {
        System.out.println("Escribe dos extensiones separadas por espacio. (Ej: jpg txt):  ");
        String entrada = userInput.nextLine();
        String[] extensiones = entrada.split(" ");

        if (extensiones.length != 2) {
            System.out.println("Debes ingresar dos extensiones separadas por un espacio");
        }

        String extAntigua = extensiones[0];
        String extNueva = extensiones[1];

        File dirTrabajo = new File(System.getProperty("user.dir"), "pruebas");
        File[] archivosCambio = dirTrabajo.listFiles();

        for (int i = 0; i < archivosCambio.length; i++) {
            if (archivosCambio[i].isFile()) {
                String nombreArchivo = archivosCambio[i].getName();
                if (nombreArchivo.endsWith("." + extAntigua)) {
                    String nuevoArchivo = nombreArchivo.substring(0, nombreArchivo.length() - extAntigua.length()) + extNueva;
                    File archivoRenombrado = new File(archivosCambio[i].getParent(), nuevoArchivo);

                    if (archivosCambio[i].renameTo(archivoRenombrado)) {
                        System.out.println("El archivo fue renombrado: " + archivoRenombrado.getName());
                    } else {
                        System.out.println("Error al renombrar el archivo: " + nombreArchivo);
                    }
                }
            }
        }

    }

    

}
