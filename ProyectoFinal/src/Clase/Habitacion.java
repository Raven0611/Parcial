package Clase;

public class Habitacion {

    private String id;
    private int capacidadMaxima;
    private Camilla[] camillas;

    public Habitacion(String id, int capacidadMaxima) {
        this.id = id;
        this.capacidadMaxima = capacidadMaxima;
        this.camillas = new Camilla[capacidadMaxima];
        for (int i = 0; i < capacidadMaxima; i++) {
            if (i < 10) {
                this.camillas[i] = new Camilla(id + "0" + i);
            } else {
                this.camillas[i] = new Camilla(id + i);
            }
        };
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public void setCapacidadMaxima(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }

    public String getCamillas() {
        String mostrar = "";
        for (int i = 0; i < capacidadMaxima; i++) {
            mostrar += camillas[i].toString();
        }
        return mostrar;
    }

    @Override
    public String toString() {
        return "Habitacion  " + id + "\ncapacidadMaxima=" + capacidadMaxima + "\n"
                + getCamillas();
    }

}
