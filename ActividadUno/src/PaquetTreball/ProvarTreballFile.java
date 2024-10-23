package PaquetTreball;
import java.util.Scanner;

//Menu para los ejercicios
public class ProvarTreballFile {

    public static void menu() {
        System.out.println("Introduce un numero para ver los ejercicios (1-5): ");
        Scanner option = new Scanner(System.in);
        int eleccion = option.nextInt();

        switch (eleccion) {
            case 1:
                TreballFile.ejercicioUno();
                break;

            case 2:
                TreballFile.ejercicioDos();
                break;

            case 3:
                TreballFile.ejercicioTres();
                break;

            case 4:
                TreballFile.ejercicioCuatro();
                break;

            case 5:
                TreballFile.ejercicioCinco();
                break;

            default:
                break;
        }
    }
}
