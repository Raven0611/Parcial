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
        this.matrizCamilla = matrizCamilla;
        this.index = 0;
        this.indexMedico = 0;
        this.indexAdmin = 0;
        this.nombreClinica = nombreClinica;
        this.pisos = new Piso[3];
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

    public Piso[] getPiso() {
        return this.pisos;
    }

    public Medico[] getMedicos() {
        return medicos;
    }

    public Administrativo[] getAdmins() {
        return admins;
    }

    @Override
    public String toString() {
        return getPisos();
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
//ingresa un paciente a la primera camilla disponible 

    public String ingresarPaciente(Paciente paciente) {
        for (int i = 0; i < pisos.length; i++) {
            for (int j = 0; j < pisos[i].getHabitacion().length; j++) {
                if (pisos[i].getHabitacion()[j].obtenerEstado()) {
                    for (int k = 0; k < pisos[i].getHabitacion()[j].getCamilla().length; k++) {
                        if (pisos[i].getHabitacion()[j].getCamilla()[k].isDisponible()) {
                            pisos[i].getHabitacion()[j].getCamilla()[k].ocupar(paciente);
                            return pisos[i].getHabitacion()[j].getCamilla()[k].getId();
                        }
                    }
                }

            }
        }

        return "";

    }

    //busca un paciente y retorna una arreglo que contiene el piso, sala y camilla en donde esta el paciente
    public String[] buscarPaciente(String pacienteInfo) {
        String piso, sala, camilla;
        String[] respuesta = new String[3];
        for (int i = 0; i < pisos.length; i++) {
            for (int j = 0; j < pisos[i].getHabitacion().length; j++) {
                for (int k = 0; k < pisos[i].getHabitacion()[j].getCamilla().length; k++) {
                    if (!pisos[i].getHabitacion()[j].getCamilla()[k].isDisponible()) {
                        Paciente paciente = pisos[i].getHabitacion()[j].getCamilla()[k].getPaciente();
                        if (paciente.getNombre().equals(pacienteInfo)
                                || paciente.getIdentificacion().equals(pacienteInfo)) {
                            piso = pisos[i].getNumero() + "";
                            sala = pisos[i].getHabitacion()[j].getId();
                            camilla = pisos[i].getHabitacion()[j].getCamilla()[k].getId();
                            respuesta[0] = piso;
                            respuesta[1] = sala;
                            respuesta[2] = camilla;
                            return respuesta;
                        }

                    }
                }
            }
        }
        respuesta[0] = "";
        return respuesta;
    }

    public InformacionMedica getInformacionMedicaPaciente(String pacienteInfo) {
        for (int i = 0; i < pisos.length; i++) {
            for (int j = 0; j < pisos[i].getHabitacion().length; j++) {
                for (int k = 0; k < pisos[i].getHabitacion()[j].getCamilla().length; k++) {
                    if (!pisos[i].getHabitacion()[j].getCamilla()[k].isDisponible()) {
                        Paciente paciente = pisos[i].getHabitacion()[j].getCamilla()[k].getPaciente();
                        if (paciente.getNombre().equals(pacienteInfo)
                                || paciente.getIdentificacion().equals(pacienteInfo)) {
                            return paciente.getInformacionMedica();
                        }

                    }
                }
            }
        }

        return null;
    }

    public Paciente[] getPacientes() {
        Paciente[] pacientes = new Paciente[70];
        int pos = 0;
        for (int i = 0; i < pisos.length; i++) {
            for (int j = 0; j < pisos[i].getHabitacion().length; j++) {
                for (int k = 0; k < pisos[i].getHabitacion()[j].getCamilla().length; k++) {
                    if (!pisos[i].getHabitacion()[j].getCamilla()[k].isDisponible()) {
                        pacientes[pos] = pisos[i].getHabitacion()[j].getCamilla()[k].getPaciente();
                        pos++;

                    }
                }
            }
        }

        return pacientes;
    }

    public boolean eliminarPaciente(String identificacion) {
        for (int i = 0; i < pisos.length; i++) {
            for (int j = 0; j < pisos[i].getHabitacion().length; j++) {
                for (int k = 0; k < pisos[i].getHabitacion()[j].getCamilla().length; k++) {
                    if (!pisos[i].getHabitacion()[j].getCamilla()[k].isDisponible()) {
                        if (pisos[i].getHabitacion()[j].getCamilla()[k].getPaciente().getIdentificacion().equals(identificacion)) {
                            pisos[i].getHabitacion()[j].getCamilla()[k].liberar();
                            return true;
                        }

                    }
                }
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

    public String getHabitacionId(int piso, int habitacion) {
        return pisos[piso].getHabitacion(habitacion).getId();
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

    public boolean getEstadoHabitacion(int piso, int habitacion) {
        return pisos[piso].getHabitacion()[habitacion].obtenerEstado();
    }

    public void setMatrizCamilla(int[][] matrizCamilla) {
        System.out.println("MODIFICADO");
        this.matrizCamilla = matrizCamilla;
        for (int i = 0; i < 3; i++) {
            int[] cantCamillas = this.matrizCamilla[i];
            pisos[i] = new Piso(i + 1, cantCamillas);
        }
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
                outer:  for (int i = 0; i < pisos[piso].getHabitacion().length; i++) {
                            Habitacion habitacionDestino = pisos[piso].getHabitacion(i);
                            if (habitacionDestino.obtenerEstado()) { // Verificar si la habitación está activa
                                Camilla[] camillasDestino = habitacionDestino.getCamilla();
                                for (Camilla camillaDestino : camillasDestino) {
                                    if (camillaDestino.isDisponible()) { // Verificar si la camilla está disponible
                                        camillaDestino.ocupar(paciente);
                                        camilla.liberar(); // Liberar la camilla de la habitación desactivada
                                        break outer;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

    }

    public String generarInformePacientes() {
        int totalPacientes = 0;
        int totalHombres = 0;
        int totalMujeres = 0;

        for (Piso piso : pisos) {
            for (Habitacion habitacion : piso.getHabitacion()) {
                for (Camilla camilla : habitacion.getCamilla()) {
                    if (!camilla.isDisponible()) {
                        totalPacientes++;
                        char sexo = camilla.getPaciente().getSexo();
                        if (sexo == 'M') {
                            totalHombres++;
                        } else if (sexo == 'F') {
                            totalMujeres++;
                        }
                    }
                }
            }
        }

        double porcentajeHombres = (totalPacientes == 0) ? 0 : ((double) totalHombres / totalPacientes) * 100;
        double porcentajeMujeres = (totalPacientes == 0) ? 0 : ((double) totalMujeres / totalPacientes) * 100;

        return String.format("Informe de Pacientes:\n"
                + "Total de Pacientes: %d\n"
                + "Total de Hombres: %d (%.2f%%)\n"
                + "Total de Mujeres: %d (%.2f%%)",
                totalPacientes, totalHombres, porcentajeHombres,
                totalMujeres, porcentajeMujeres);
    }

}
