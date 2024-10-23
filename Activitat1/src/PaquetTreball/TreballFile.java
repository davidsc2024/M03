package PaquetTreball;
import java.io.File;
import java.util.Scanner;

public class TreballFile {
    public static void primerPunto() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Por favor introduce el nombre de un fichero o una carpeta: ");
        String ruta = scanner.nextLine();
        //Creamos una variable de tipo File donde guardaremos la ruta que introducimos mediante el Scanner
        File archivocarpeta = new File(ruta); 

        /* La primera condición (if) se asegura de que exista la ruta que introducimos, en caso contrario (else) nos arroja un mensaje.
         * Dentro de esta condición hay dos más, que nos dice si es un archivo o un directorio.
         */
        if (archivocarpeta.exists()) {
            if (archivocarpeta.isFile()) {
                System.out.println("Es un archivo.");
            } else if (archivocarpeta.isDirectory()) {
                System.out.println("Es un directorio");
            }
        } else {
            System.out.println("El archivo o directorio no existe.");
        }
    }

    public static void segundoPunto() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce la ruta de un directorio: ");
        String ruta = scanner.nextLine();

        File directorio = new File(ruta);

        if (directorio.isDirectory()) {
            File[] archivoscarpetas = directorio.listFiles();

            if (archivoscarpetas != null) {
                for (File file : archivoscarpetas) {
                    if (file.isDirectory()) {
                        System.out.println("Carpeta: " + file.getName());
                    } else {
                        System.out.println("Archivo: " + file.getName());
                    }
                }
            } else {
                System.out.println("No hay archivos o carpetas en esta ruta.");
            }
        } else {
            System.out.println("La ruta introducida no existe.");
        }

    }
    /*
    public void tercerPunto() {

    } */

    public static void cuartoPunto() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escribe un directorio de origen:");
        String ruta = scanner.nextLine();

        File directorio = new File(ruta);
        
        if (directorio.exists() && directorio.isDirectory()) {
            while (directorio != null) {
                long espacioLibre = directorio.getUsableSpace();
                long espacioTotal = directorio.getTotalSpace();

                System.out.println("Directorio: " + directorio.getAbsolutePath());
                System.out.println("Espacio libre: " + espacioLibre + " bytes");
                System.out.println("Espacio total: " + espacioTotal + " bytes");
                System.out.println("-----------------------------------");


                directorio = directorio.getParentFile();
            }
        } else {
            System.out.println("El directorio no existe.");
        }

        public static void quintoPunto() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Introduce el nombre de un fichero y una ruta de carpeta: ");


        }
    }
}