package Clase;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class InterfazGeneral extends Componente implements ActionListener {

    JLabel avisoCrearUsuario;
    JButton crearUsuario;
    JButton regresar;
    JPanel nuevoUsuario, menu;
    InterfazIniciarSesion login;
    Registro registro;
    JPanel currentDir;
    Card card;
    Card cardAdministrador;
    Card cardMedico;
    Card cardAdministrativo;
    Inicio init;
    String dependencia;
    Clinica clinica;
    CrearClinica crearClinica;
    int[][] x;
    private final String[] funcionalidadesAdministrador = {"Inhabilitar habitacion", "Generar Informe",
    "Registrar medico", "Registrar Administrativo", "Eliminar Medico", "Eliminar Administrativo", 
    "Ingresar Paciente", "Buscar Paciente"};
    private final String[] funcionalidadesMedico = {"Generar Informe", "Ingresar Paciente", 
        "Buscar Paciente", "Eliminar Paciente", "Informacion Medica Paciente"};
    private final String[] funcionalidadesAdministrativo = {"Generar Informe", "Ingresar Paciente", 
        "Buscar Paciente"};

    public InterfazGeneral(Inicio init) {
        int[][] matrizCamilla = {
            {5, 5, 5, 5},
            {4, 4, 4, 4},
            {3, 3, 3, 3}
        };
        clinica = new Clinica("HealthCare", matrizCamilla);

        this.setBounds(40, 70, 600, 500);
        this.setBackground(Color.white);
        this.setLayout(null);
        this.init = init;

        login = new InterfazIniciarSesion(this);
        currentDir = login;
        login.setBounds(100, 10, 300, 200);
        this.add(login);

        registro = new Registro(this);
        registro.setBounds(0, 0, 400, 400);
        registro.setVisible(false);
        this.add(registro);

        card = new Card(clinica, funcionalidadesAdministrativo);
        card.setVisible(false);
        cardAdministrador = new Card(clinica, funcionalidadesAdministrador);
        cardAdministrador.setVisible(false);
        this.add(cardAdministrador);
        cardMedico = new Card(clinica, funcionalidadesMedico);
        cardMedico.setVisible(false);
        this.add(cardMedico);
        cardAdministrativo = new Card(clinica, funcionalidadesAdministrativo);
        cardAdministrativo.setVisible(false);
        this.add(cardAdministrativo);

        nuevoUsuario = new JPanel();
        nuevoUsuario.setLayout(null);
        nuevoUsuario.setBounds(160, 210, 300, 200);
        nuevoUsuario.setBackground(Color.white);
        nuevoUsuario.setVisible(false);

        avisoCrearUsuario = new JLabel("O crea un nuevo usuario:");
        avisoCrearUsuario.setFont(new Font("Arial", Font.ITALIC, 15));
        avisoCrearUsuario.setBounds(0, 0, 200, 30);
        nuevoUsuario.add(avisoCrearUsuario);

        crearUsuario = crearBoton("Crear usuario", 10, 40, 150, 30);
        crearUsuario.addActionListener(this);
        nuevoUsuario.add(crearUsuario);

        this.add(nuevoUsuario);

        regresar = crearBoton("Regresar", 2, 460, 100, 30);
        regresar.addActionListener(this);
        this.add(regresar);

        // menu = new Menu(clinica);
        crearClinica = new CrearClinica(clinica, regresar);
        crearClinica.setBounds(10, 0, 500, 500);
        crearClinica.setVisible(false);
        this.add(crearClinica);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == crearUsuario) {
            setVisibility(false, true, false, false);
            currentDir = registro;

        } else if (e.getSource() == registro.registrar) {
            registrarAdministrador();
            regresar.doClick();

        } else if (e.getSource() == regresar) {
            if (currentDir == registro || currentDir == card || currentDir == crearClinica) {
                setVisibility(true, false, false, false);
                crearClinica.setVisible(false);
                currentDir = login;

            } else {
                this.setVisible(false);
                init.setVisible(true);

            }

        } else if (e.getSource() == login.iniciarSesion) {
            String usuario = login.credenciales.usuario.getText();
            String password = new String(login.credenciales.contrasenia.getPassword());

            if (clinica.verificarUsuario(usuario, password, dependencia)) {

                if (!crearClinica.clinicaCreada) { //La asignacion de camillas solo se realizara una vez
                    currentDir = crearClinica;

                    setVisibility(false, false, false, true);
                } else {
                    currentDir = card;
                    setEstadoInicialCards();
                    setVisibility(false, false, true, false);
                    //  clinica.setMatrizCamilla(crearClinica.getMatriz());
                    // card.actualizarClinica(crearClinica.getMatriz());
                }

            } else {
                JOptionPane.showMessageDialog(null, "Credenciales invalidas", "Título del mensaje", JOptionPane.WARNING_MESSAGE);
            }

            login.credenciales.limpiarCredenciales();

        }
    }

    //guarda en que modulo (administrador, medico, administrativo) ha ingresado un usuario
    public void setDependencia(String dependencia) {
        this.dependencia = dependencia;
        if (dependencia.equals("administrador")) {
            nuevoUsuario.setVisible(true);

        } else {
            nuevoUsuario.setVisible(false);
        }
    }

    private void registrarAdministrador() { //registra un nuevo usuario administrador
        String[] input = registro.formulario.getInput();
        String usuario = registro.credenciales.usuario.getText();
        String password = new String(registro.credenciales.contrasenia.getPassword());
        Administrador admin = new Administrador(usuario, password, input[0], input[6].charAt(0),
                Integer.parseInt(input[2]), input[4], input[1], input[3]);
        clinica.agregarAdministrador(admin);
        registro.limpiarRegistro();
    }

    //modifica la propiedad visibilidad de los componentes para esconderlos o mostrarlos
    private void setVisibility(boolean type1, boolean type2, boolean type3, boolean type4) {
        login.setVisible(type1);
        registro.setVisible(type2);
        crearClinica.setVisible(type4);
        
        if (dependencia.equals("administrador")) {
            cardAdministrador.setVisible(type3);
            
        } else if (dependencia.equals("medico")) {
            cardMedico.setVisible(type3);
            
        } else {
            cardAdministrativo.setVisible(type3);
        }

        if (dependencia.equals("administrador")) {
            nuevoUsuario.setVisible(type1);
        }
    }
    
    private void setEstadoInicialCards() {
        cardAdministrador.cb.setSelectedIndex(funcionalidadesAdministrador.length - 1);
        cardMedico.cb.setSelectedIndex(funcionalidadesMedico.length - 1);
        cardAdministrativo.cb.setSelectedIndex(funcionalidadesAdministrativo.length - 1);
    }

}
