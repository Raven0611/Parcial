package Clase;

public class Piso {

    private int numero;
    private Habitacion[] habitaciones;

    public Piso(int numero, int[] cantCamillas) {
        this.numero = numero;
        this.habitaciones = new Habitacion[4];
        for (int i = 0; i < habitaciones.length; i++) {
            habitaciones[i] = new Habitacion(String.valueOf(numero) + " 0 " + (i + 1), cantCamillas[i]);
        }
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getHabitaciones() {
        String mostrar = "";
        for (int i = 0; i < habitaciones.length; i++) {
            mostrar += habitaciones[i].toString();
        }
        return mostrar;
    }

    public Habitacion getHabitacion(int a) {
        return this.habitaciones[a];
    }

    public Habitacion[] getHabitacion() {
        return this.habitaciones;
    }

    public boolean desactivarHabitacionPiso(int posicionHabitacion) {
        for (int i = 0; i < 4; i++) {
            if (i == posicionHabitacion) {
                habitaciones[i].desactivarHabitacion();
                return true;
            }
        }
        return false;
    }

    public boolean activarHabitacionPiso(int posicionHabitacion) {
        for (int i = 0; i < 4; i++) {
            if (i == posicionHabitacion) {
                habitaciones[i].activarHabitacion();
                return true;
            }
        }
        return false;
    }

    public boolean liberarPacienteHabitacionPiso(int posHabitacion, int camilla) {
        if (habitaciones[posHabitacion].obtenerEstado()) {
            return habitaciones[posHabitacion].liberarPacienteHabitacion(camilla);

        }
        return false;
    }

    @Override
    public String toString() {
        return "Piso " + numero + "\n" + getHabitaciones();
    }

}
