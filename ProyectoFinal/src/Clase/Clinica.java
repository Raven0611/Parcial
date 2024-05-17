package Clase;

public class Clinica {

    private String nombreClinica;
    private Piso[] pisos;
    int index, indexMedico, indexAdmin;
    private int[][] matrizCamilla;
    private Administrador[] administradores;
    private Medico[] medicos;
    private Administrativo[] admins;

    public Clinica(String nombreClinica, int[][] matrizCamilla) {
        this.matrizCamilla = new int[3][4];
        this.index = 0;
        this.indexMedico = 0;
        this.indexAdmin = 0;
        this.nombreClinica = nombreClinica;
        this.pisos = new Piso[3];
        for (int i = 0; i < 3; i++) {
            int[] cantCamillas = matrizCamilla[i];
            pisos[i] = new Piso(i + 1, cantCamillas);
        }

        administradores = new Administrador[10];
        medicos = new Medico[10];
        admins = new Administrativo[10];
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

    public Medico[] getMedicos() {
        return medicos;
    }

    public Administrativo[] getAdmins() {
        return admins;
    }

    @Override
    public String toString() {
        return "Clinica  " + nombreClinica + "\n" + getPisos();
    }

    public boolean verificarUsuario(String usuario, String contrasenia, String dependencia) {
        if (usuario.isEmpty() || contrasenia.isEmpty()) {
            return false;
        }

        if (dependencia.equals("administrador")) {
            return findAdmin(usuario, contrasenia);

        } else if (dependencia.equals("medico")) {
            return findMedico(usuario, contrasenia);

        } else if (dependencia.equals("administrativo")) {
            return findAdministrativo(usuario, contrasenia);
        }

        return false;
    }

    private boolean findAdmin(String usuario, String contrasenia) {
        for (Administrador admin : administradores) {
            if (admin != null && admin.getContrasenia().equals(contrasenia) && admin.getUsuario().equals(usuario)) {
                return true;
            }
        }

        return false;
    }

    private boolean findMedico(String usuario, String contrasnia) {
        for (Medico medico : medicos) {
            if (medico != null && medico.getContrasenia().equals(contrasnia) && medico.getUsuario().equals(usuario)) {
                return true;
            }
        }
        return false;
    }

    private boolean findAdministrativo(String usuario, String contrasnia) {
        for (Administrativo admin : admins) {
            if (admin != null && admin.getContrasenia().equals(contrasnia) && admin.getUsuario().equals(usuario)) {
                return true;
            }
        }
        return false;
    }

    public boolean agregarMedico(Medico medico) {
        if (indexMedico < 10) {
            medicos[indexMedico] = medico;
            indexMedico++;
            return true;
        }
        return false;
    }

    public boolean agregarAdministrativo(Administrativo adminis) {
        if (indexAdmin < 10) {
            admins[indexAdmin] = adminis;
            indexAdmin++;
            return true;
        }
        return false;
    }

    public boolean eliminarAdministrativo(String identificacion) {
        for (int i = 0; i < admins.length; i++) {
           if (admins[i] != null && admins[i].getIdentificacion().equals(identificacion)) {
                admins[i] = null;
                return true;
            } 
        }
        
        return false;
    }

    public boolean eliminarMedico(String identificacion) {
        for (int i = 0; i < medicos.length; i++) {
            if (medicos[i] != null && medicos[i].getIdentificacion().equals(identificacion)) {
                medicos[i] = null;
                return true;
            }
        }
        return false;
    }

    public boolean agregarAdministrador(Administrador admin) {
        if (index < 10) {
            administradores[index] = admin;
            index++;
            return true;
        }

        return false;
    }

    public boolean desactivarHabitacion(int piso, int habitacion) {
        return this.pisos[piso].desactivarHabitacionPiso(habitacion);
    }

    public boolean activarHabitacion(int piso, int habitacion) {
        return this.pisos[piso].activarHabitacionPiso(habitacion);
    }

    public boolean liberarPaciente(int piso, int habitacion, int camilla) {
        if (piso <= pisos.length) {
            return pisos[piso].liberarPacienteHabitacionPiso(habitacion, camilla);
        }
        return false;
    }

    public void setMatrizCamilla(int[][] matrizCamilla) {
        System.out.println("MODIFICADO");
        this.matrizCamilla = matrizCamilla;
    }

    public void desplazarPacientesHabitacionDesactivada(int piso, int habitacion) {

        if (piso >= 0 && piso < pisos.length && habitacion >= 0 && habitacion < 4) {
            Habitacion habitacionDesactivada = pisos[piso].getHabitacion(habitacion);
            if (!habitacionDesactivada.obtenerEstado()) { // Verificar si la habitación está desactivada
                Camilla[] camillasDesactivada = habitacionDesactivada.getCamilla();
                for (Camilla camilla : camillasDesactivada) {
                    if (!camilla.isDisponible()) { // Verificar si la camilla está ocupada
                        Paciente paciente = camilla.getPaciente();
                        // Buscar una habitación activa con espacio disponible en el mismo piso
                        for (int i = 0; i < pisos[piso].getHabitacion().length; i++) {
                            Habitacion habitacionDestino = pisos[piso].getHabitacion(i);
                            if (habitacionDestino.obtenerEstado()) { // Verificar si la habitación está activa
                                Camilla[] camillasDestino = habitacionDestino.getCamilla();
                                for (Camilla camillaDestino : camillasDestino) {
                                    if (camillaDestino.isDisponible()) { // Verificar si la camilla está disponible
                                        camillaDestino.ocupar(paciente);
                                        camilla.liberar(); // Liberar la camilla de la habitación desactivada
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

    }

}
