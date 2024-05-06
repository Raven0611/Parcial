package Clase;

public class Camilla {

    private int id;
    private boolean disponible;

    public Camilla(int id) {
        this.id = id;
        this.disponible=true;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void ocupar(){
            disponible=false;
    }
    public void liberar(){
    disponible=true;
    }

}
