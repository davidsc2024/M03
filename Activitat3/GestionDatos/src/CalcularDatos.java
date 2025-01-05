public class CalcularDatos {
    private int dia;
    private int mes;
    private int any;

    // Constructor por defecto
    public CalcularDatos() {
        this.dia = 1;
        this.mes = 1;
        this.any = 1980;
    }

    // Constructor con parámetros
    public CalcularDatos(int dia, int mes, int any) {
        if (esDataValida(dia, mes, any)) {
            this.dia = dia;
            this.mes = mes;
            this.any = any;
        } else {
            this.dia = 1;
            this.mes = 1;
            this.any = 1980;
        }
    }

    // Constructor copia
    public CalcularDatos(CalcularDatos altraData) {
        this.dia = altraData.dia;
        this.mes = altraData.mes;
        this.any = altraData.any;
    }

    // Métodos getter
    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public int getAny() {
        return any;
    }

    // Métodos setter
    public void setDia(int dia) {
        if (esDataValida(dia, this.mes, this.any)) {
            this.dia = dia;
        }
    }

    public void setMes(int mes) {
        if (esDataValida(this.dia, mes, this.any)) {
            this.mes = mes;
        }
    }

    public void setAny(int any) {
        if (esDataValida(this.dia, this.mes, any)) {
            this.any = any;
        }
    }

    // Método para sumar días
    public CalcularDatos sumarDies(int dies) {
        int nouDia = this.dia;
        int nouMes = this.mes;
        int nouAny = this.any;

        // Sumar o restar días
        nouDia += dies;

        while (nouDia > diesDelMes(nouMes, nouAny)) {
            nouDia -= diesDelMes(nouMes, nouAny);
            nouMes++;
            if (nouMes > 12) {
                nouMes = 1;
                nouAny++;
            }
        }

        while (nouDia < 1) {
            nouMes--;
            if (nouMes < 1) {
                nouMes = 12;
                nouAny--;
            }
            nouDia += diesDelMes(nouMes, nouAny);
        }

        return new CalcularDatos(nouDia, nouMes, nouAny);
    }

    // Método para comparar fechas
    public int comparar(CalcularDatos altraData) {
        if (this.any != altraData.any) {
            return this.any - altraData.any;
        } else if (this.mes != altraData.mes) {
            return this.mes - altraData.mes;
        } else {
            return this.dia - altraData.dia;
        }
    }

    // Método para calcular días entre dos fechas
    public int diesEntre(CalcularDatos altraData) {
        int diesTotals = 0;
        CalcularDatos dataMenor = this.comparar(altraData) <= 0 ? this : altraData;
        CalcularDatos dataMajor = this.comparar(altraData) > 0 ? this : altraData;

        while (!dataMenor.equals(dataMajor)) {
            dataMenor = dataMenor.sumarDies(1);
            diesTotals++;
        }

        return diesTotals;
    }

    // Método auxiliar: comprobar si una fecha es válida
    private boolean esDataValida(int dia, int mes, int any) {
        if (mes < 1 || mes > 12 || dia < 1) {
            return false;
        }
        return dia <= diesDelMes(mes, any);
    }

    // Método auxiliar: calcular los días de un mes
    private int diesDelMes(int mes, int any) {
        switch (mes) {
            case 4: case 6: case 9: case 11:
                return 30;
            case 2:
                return (esAnyDeTraspas(any)) ? 29 : 28;
            default:
                return 31;
        }
    }

    // Método auxiliar: comprobar si un año es bisiesto
    private boolean esAnyDeTraspas(int any) {
        return (any % 4 == 0 && any % 100 != 0) || (any % 400 == 0);
    }
}
