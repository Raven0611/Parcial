package Clase;

public class Piso {

    private int numero;
    private Habitacion[] habitaciones;

    public Piso(int[] cantCamillas) {

        this.habitaciones = new Habitacion[4];
        for (int i = 0; i < habitaciones.length; i++) {
            this.numero = i;
            habitaciones[i] = new Habitacion(String.valueOf(numero), cantCamillas[i]);
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

    @Override
    public String toString() {
        return "Numero de pisos   " + numero + "\n" + getHabitaciones();
    }

}
