package Clase;

public class Camilla {

    private String id;
    private boolean disponible;

    public Camilla(String id) {
        this.id = id;
        this.disponible = true;
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

    public void ocupar() {
        disponible = false;
    }

    public void liberar() {
        disponible = true;
    }

    @Override
    public String toString() {
        return "Camilla  " + id + " disponible= " + disponible + "\n";
    }

}
