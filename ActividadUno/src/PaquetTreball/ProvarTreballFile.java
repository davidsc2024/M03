package PaquetTreball;
import java.util.Scanner;

//Menu para los ejercicios
public class ProvarTreballFile {

    public static void menu() {
        Scanner option = new Scanner(System.in);
        String eleccion;

        do {
            System.out.println("________________________________");
            System.out.println("Introduce un numero del 1 al 5 : \nPara salir ingresa '0'");
            System.out.println("¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨");
            eleccion = option.nextLine();

            switch (eleccion) {
                case "1":
                    TreballFile.ejercicioUno();
                    break;

                case "2":
                    TreballFile.ejercicioDos();
                    break;
    
                case "3":
                    TreballFile.ejercicioTres();
                    break;
    
                case "4":
                    TreballFile.ejercicioCuatro();
                    break;
    
                case "5":
                    TreballFile.ejercicioCinco();
                    break;

                case "0":
                    System.out.println("Hasta luego.");
                    break;

                default:
                    System.out.println("Elige un numero válido.");
                    break;
            }
        } while (!eleccion.equals("0"));
    }
}
