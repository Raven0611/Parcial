package Clase;

public class Clinica {

    private String nombreClinica;
    private Piso[] pisos;
    int index;
    private int[][] matrizCamilla;
    private Administrador[] administradores;

    public Clinica(String nombreClinica, int[][] matrizCamilla) {
        this.index = 0;
        int[] variable = new int[4];
        this.nombreClinica = nombreClinica;
        this.matrizCamilla = matrizCamilla;
        this.pisos = new Piso[3];
        for (int i = 0; i < pisos.length; i++) {
            for (int j = 0; j < pisos.length; j++) {
                variable[i] = this.matrizCamilla[i][j];
            }
            pisos[i] = new Piso(i + 1, variable);
        }

        administradores = new Administrador[10];
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

    @Override
    public String toString() {
        return "Clinica  " + nombreClinica + "\n" + getPisos();
    }

    public int[][] getMatrizCamilla() {
        return matrizCamilla;
    }

    public boolean verificarUsuario(String usuario, String contrasenia, String dependencia) {
        if (usuario.isEmpty() || contrasenia.isEmpty()) {
            return false;
        }
        
        if (dependencia.equals("administrador")) {
            return findAdmin(usuario, contrasenia);
        }
        
        return false;
    }

    private boolean findAdmin(String usuario, String contrasenia) {
        for (Administrador admin : administradores) {
            if (admin.getContrasenia().equals(contrasenia) && admin.getUsuario().equals(usuario)) {
                return true;
            }  
        }
        
        return false;
    }

    public boolean agregarAdministrador(Administrador admin) {
        if (index < 20) {
            administradores[index] = admin;
            index++;
            return true;
        }

        return false;
    }

    public void setMatrizCamilla(int[][] matrizCamilla) {
        System.out.println("MODIFICADO");
        this.matrizCamilla = matrizCamilla;
    }

}
