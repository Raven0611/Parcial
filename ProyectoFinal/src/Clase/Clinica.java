package Clase;

public class Clinica {

    private String nombreClinica;
    private Piso[] pisos;

    public Clinica(String nombreClinica, int[][] matrizCamilla) {
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

    @Override
    public String toString() {
        return "Clinica  " + nombreClinica + "\n" + getPisos();
    }

}
