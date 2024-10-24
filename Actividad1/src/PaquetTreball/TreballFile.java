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
        //Guardamos la entrada del usuario en un array tipo String y lo dividiremos con un split
        String[] extensiones = entrada.split(" ");

        //Si la entrada no son 2 extensiones separadas por espacio, dará error
        if (extensiones.length != 2) {
            System.out.println("Debes ingresar dos extensiones separadas por un espacio");
        }

        //Guardamos las palabras divididas en dos variables String
        String extAntigua = extensiones[0];
        String extNueva = extensiones[1];

        //Asignamos la ruta de trabajo que será la dirección actual, en la carpeta'pruebas'
        File dirTrabajo = new File(System.getProperty("user.dir"), "pruebas");
        //Hacemos una lista de los archivos en esta dirección en un objeto File
        File[] archivosCambio = dirTrabajo.listFiles();

        //Hacemos un bucle para iterar sobre los archivos listados
        for (int i = 0; i < archivosCambio.length; i++) {
            //Si el indice donde nos encontramos es un archivo
            if (archivosCambio[i].isFile()) {
                String nombreArchivo = archivosCambio[i].getName(); //Guardamos el nombre del archivo en un String
                //Si el archivo acaba con '.' y la extension antigua
                if (nombreArchivo.endsWith("." + extAntigua)) {
                    //Guardamos el nombre del archivo en un string con la extension nueva
                    String nuevoArchivo = nombreArchivo.substring(0, nombreArchivo.length() - extAntigua.length()) + extNueva;
                    //Renombramos el archivo usando el String anterior
                    File archivoRenombrado = new File(archivosCambio[i].getParent(), nuevoArchivo);

                    //Si el archivo se renombra correctamente entonces nos dará un mensaje de confirmación, sino nos dará un mensaje de error
                    if (archivosCambio[i].renameTo(archivoRenombrado)) {
                        System.out.println("El archivo fue renombrado: " + archivoRenombrado.getName());
                    } else {
                        System.out.println("Error al renombrar el archivo: " + nombreArchivo);
                    }
                }
            }
        }

    }

    //Ejercicio cuatro
    public static void ejercicioCuatro() {
        System.out.println("Escribe un directorio de origen: ");
        //Guardamos en un objeto de tipo File el string que introduce el usuario
        File dirOrigen = new File(userInput.nextLine());
        //Si el directorio existe y es una carpeta entrará en un while
        if (dirOrigen.exists() && dirOrigen.isDirectory()) {
            //Mientras la carpeta no sea nula, osea, tenga carpetas 'padre', se ejecturán los mensajes
            while (dirOrigen != null) {
                System.out.println("Dirección absoluta: " + dirOrigen.getAbsolutePath());

                //Obtenemos en un tipo long el espacio libre y el espacio disponible
                long espLibre = dirOrigen.getFreeSpace();
                long espDisp = dirOrigen.getUsableSpace();

                System.out.println("Espacio libre: " + espLibre);
                System.out.println("Espacio disponible: " + espDisp);
                
                //la variable donde almacenamos la ruta se actualiza con el directorio padre
                dirOrigen = dirOrigen.getParentFile();
            }
        } else {
            System.out.println("El directorio no existe.");
        }
    }

    //Ejercicio cinco
    public static void ejercicioCinco() {
        System.out.println("Introduce el nombre de una carpeta: ");
        String rutaCarpeta = userInput.nextLine();
        System.out.println("Introduce el nombre de un archivo: ");
        String nomArchivo = userInput.nextLine();
        
        //Guardamos en un objeto file la ruta de la carpeta
        File d = new File(rutaCarpeta);

        //Si la carpeta existe y es un directorio, iniciará la función de busqueda de archivos
        if (d.exists() && d.isDirectory()) {
            buscarArchivos(d, nomArchivo);
        } else {
            System.out.println("Escribe una carpeta valida.");
        }   
    }

    //Funcion de busqueda de archivos para el ejercico cinco
    public static void buscarArchivos(File carpeta, String archivo) {
        //obtenemos una lista de archivos y lo guardamos en un objeto tipo File
        File[] archivosCarpetas = carpeta.listFiles();

        //Verificar si la carpeta no es nula
        if (archivosCarpetas != null) {
            //Se hará un bucle para iterar las carpetas y archivos, que se guardará en archivoOcarpeta
            for (File archivoOcarpeta : archivosCarpetas) {
                //Si es un archivo y tiene el mismo nombre que dimos, lo imprimirá con su ruta absoluta
                if (archivoOcarpeta.isFile() && archivoOcarpeta.getName().equals(archivo)) {
                    System.out.println("Archivo encontrado: " + archivoOcarpeta.getAbsolutePath());
                } else if (archivoOcarpeta.isDirectory()) { //Si encuentra una carpeta, ingresa en ella y busca de manera recursiva
                    System.out.println("Entrando en subcarpeta: " + archivoOcarpeta.getAbsolutePath());
                    buscarArchivos(archivoOcarpeta, archivo);
                }
            }
        }
    }

}