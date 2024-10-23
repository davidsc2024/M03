package PaquetTreball;
import java.util.Scanner;
import java.io.File;

public class ProvarTreballFile {
    public static void menuActividad() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escribe un numero correspondiente al ejercicio: ");
        int input = scanner.nextInt();

        switch (input) {
            case 1:
                TreballFile.primerPunto();
                break;
            case 2:
                TreballFile.segundoPunto();
                break;
            case 3:
                TreballFile.tercerPunto();
                break;
            case 4:
                TreballFile.cuartoPunto();
                break;
            case 5:
                TreballFile.quintoPunto();
        }
    }
}