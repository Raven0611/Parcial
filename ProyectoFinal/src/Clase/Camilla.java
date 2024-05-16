package Clase;

public class Camilla {

    private String id;
    private boolean disponible;
    private Paciente paciente;

    public Camilla(String id) {
        this.id = id;
        this.disponible = true;
        this.paciente = null;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void ocupar(Paciente paciente) {
        disponible = false;
        this.paciente = paciente;
    }

    public void liberar() {
        disponible = true;
        this.paciente = null;
    }

    public Paciente getPaciente() {
        return this.paciente;
    }

    @Override
    public String toString() {
        if (paciente == null) {
            return "   Camilla No :  " + id + "      Vacia \n";
        } else {
            return "    Camilla No :  " + id + "    Id =    " + paciente.getIdentificacion()
                    + "    nombre =    " + paciente.getNombre() + "\n";
        }
    }

}
