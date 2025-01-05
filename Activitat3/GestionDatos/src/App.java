public class App {
    public static void main(String[] args) {
        // Crear fechas usando diferentes constructores
        CalcularDatos data1 = new CalcularDatos();
        CalcularDatos data2 = new CalcularDatos(31, 12, 2025);
        CalcularDatos data3 = new CalcularDatos(data2);

        // Mostrar las fechas creadas
        System.out.println("Data 1: " + data1.getDia() + "-" + data1.getMes() + "-" + data1.getAny());
        System.out.println("Data 2: " + data2.getDia() + "-" + data2.getMes() + "-" + data2.getAny());
        System.out.println("Data 3 (copia de Data 2): " + data3.getDia() + "-" + data3.getMes() + "-" + data3.getAny());

        // Sumar días
        CalcularDatos dataFutura = data2.sumarDies(10);
        System.out.println("Data 2 + 10 dies: " + dataFutura.getDia() + "-" + dataFutura.getMes() + "-" + dataFutura.getAny());

        // Comparar fechas
        System.out.println("Comparació Data 1 i Data 2: " + data1.comparar(data2));

        // Calcular días entre fechas
        System.out.println("Dies entre Data 1 i Data 2: " + data1.diesEntre(data2));
    }
}
