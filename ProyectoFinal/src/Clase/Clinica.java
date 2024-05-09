package Clase;

public class Clinica {

    private String nombreClinica;
    private Piso[] pisos;
    private Administrador[] administradores;
    int index;

    public Clinica(String nombreClinica, int[][] matrizCamilla) {
        this.administradores = new Administrador[20];
        this.index = 0;
        int[] variable = new int[4];
        this.nombreClinica = nombreClinica;
        this.pisos = new Piso[3];
        for (int i = 0; i < pisos.length; i++) {
            for (int j = 0; j < pisos.length; j++) {
                variable[i] = matrizCamilla[i][j];
            }
            pisos[i] = new Piso(i + 1, variable);
        }
    }

    public String getNombreClinica() {
        return nombreClinica;
    }

    public void setNombreClinica(String nombreClinica) {
        this.nombreClinica = nombreClinica;
    }

    public String getPisos() {
        String mostrar = "";
        for (int i = 0; i < pisos.length; i++) {
            mostrar += pisos[i].toString();
        }
        return mostrar;
    }
    
    public boolean agregarAdministrador(Administrador admin) {
        if (index < 20) {
            administradores[index] = admin;
            index++;
            return true;
        }
        
        return false;
    }
    
    public boolean verificarAdministrador(String usuario, String contrasenia) {
        for (int i = 0; i < index; i++) {
            if (administradores[i].getUsuario().equals(usuario) && 
                    administradores[i].getContrasenia().equals(contrasenia)) {
                return true;
            }
        }
        
        return false;
    }

    @Override
    public String toString() {
        return "Clinica  " + nombreClinica + "\n" + getPisos();
    }

}
