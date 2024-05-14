package Clase;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class InterfazGeneral extends Componente implements ActionListener {

    JLabel avisoCrearUsuario;
    JButton crearUsuario;
    JButton regresar;
    JPanel nuevoUsuario;
    InterfazIniciarSesion login;
    Registro registro;
    JPanel currentDir;
    Card card;
    Inicio init;
    String dependencia;
    Clinica clinica;

    int[][] x;

    public InterfazGeneral(Inicio init) {
        x = new int[][]{{2, 3, 2, 5}, {3, 3, 2, 5}, {1, 4, 3, 2}};
        clinica = new Clinica("HealthCare", x);

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

        card = new Card(clinica);
        card.setVisible(false);
        this.add(card);

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

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == crearUsuario) {
            setVisibility(false, true, false);
            currentDir = registro;

        } else if (e.getSource() == registro.registrar) {
            registrarAdministrador();
            regresar.doClick();

        } else if (e.getSource() == regresar) {
            if (currentDir == registro || currentDir == card) {
                setVisibility(true, false, false);
                currentDir = login;

            } else {
                this.setVisible(false);
                init.setVisible(true);

            }

        } else if (e.getSource() == login.iniciarSesion) {
            String usuario = login.credenciales.usuario.getText();
            String password = new String(login.credenciales.contrasenia.getPassword());
            
            if (clinica.verificarUsuario(usuario, password, dependencia)) {
                setVisibility(false, false, true);
                currentDir = card;
            } else {
                JOptionPane.showMessageDialog(null, "Credenciales invalidas", "Título del mensaje", JOptionPane.WARNING_MESSAGE);
            }
            
            login.credenciales.limpiarCredenciales();
            
        }
    }

    public void setDependencia(String dependencia) {
        this.dependencia = dependencia;
        if (dependencia.equals("administrador")) {
            nuevoUsuario.setVisible(true);

        } else {
            nuevoUsuario.setVisible(false);
        }
    }

    private void registrarAdministrador() {
        String[] input = registro.formulario.getInput();
        String usuario = registro.credenciales.usuario.getText();
        String password = new String(registro.credenciales.contrasenia.getPassword());
        Administrador admin = new Administrador(usuario, password, input[0], input[6].charAt(0),
                Integer.parseInt(input[2]), input[4], input[1], input[3]);
        clinica.agregarAdministrador(admin);
        registro.limpiarRegistro();
    }

    private void setVisibility(boolean type1, boolean type2, boolean type3) {
        login.setVisible(type1);
        registro.setVisible(type2);
        card.setVisible(type3);

        if (dependencia.equals("administrador")) {
            nuevoUsuario.setVisible(type1);
        }
    }

}