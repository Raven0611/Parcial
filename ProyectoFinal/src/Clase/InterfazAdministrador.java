package Clase;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class InterfazAdministrador extends Componente implements ActionListener {

    JLabel avisoCrearUsuario;
    JButton crearUsuario;
    JButton regresar;
    JPanel nuevoUsuario;
    InterfazIniciarSesion login;
    Registro registro;
    Administrador[] administradores;
    JPanel currentDir;
    int index;
    Card card;
    Inicio init;

    public InterfazAdministrador(Inicio init) {
        this.setBounds(40, 70, 600, 500);
        this.setBackground(Color.white);
        this.setLayout(null);
        this.init = init;
        this.index = 0;

        administradores = new Administrador[10];

        login = new InterfazIniciarSesion(this, "administrador");
        currentDir = login;
        login.setBounds(100, 10, 300, 200);
        this.add(login);

        registro = new Registro(this, "administrador");
        registro.setBounds(0, 0, 400, 400);
        registro.setVisible(false);
        this.add(registro);

        card = new Card();
        card.setVisible(false);
        this.add(card);

        nuevoUsuario = new JPanel();
        nuevoUsuario.setLayout(null);
        nuevoUsuario.setBounds(160, 210, 300, 200);
        nuevoUsuario.setBackground(Color.white);

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
            setVisibility(false, false, true);
            currentDir = card;
        }
    }

    private boolean agregarAdministrador(Administrador admin) {
        if (index < 20) {
            administradores[index] = admin;
            index++;
            return true;
        }

        return false;
    }

    private void registrarAdministrador() {
        String[] input = registro.formulario.getInput();
        String usuario = registro.credenciales.usuario.getText();
        String password = new String(registro.credenciales.contrasenia.getPassword());
        Administrador admin = new Administrador(usuario, password, input[0], input[6].charAt(0),
                Integer.parseInt(input[2]), input[4], input[1], input[3]);
        agregarAdministrador(admin);
        registro.limpiarRegistro();
    }

    private boolean verificarAdministrador(String usuario, String contrasenia) {
        for (int i = 0; i < index; i++) {
            if (administradores[i].getUsuario().equals(usuario)
                    && administradores[i].getContrasenia().equals(contrasenia)) {
                return true;
            }
        }

        return false;
    }

    private void setVisibility(boolean type1, boolean type2, boolean type3) {
        login.setVisible(type1);
        nuevoUsuario.setVisible(type1);
        registro.setVisible(type2);
        card.setVisible(type3);
    }

}
