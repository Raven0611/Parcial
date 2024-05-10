package Clase;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class InterfazAdministrador extends JFrame implements ActionListener {

    JButton iniciarSesion, crearAdmin, crearUsuario;
    JTextField usuario;
    JLabel avisoCrearUsuario;
    JPasswordField contrasenia;
    JLabel titulo;
    JPanel login;
    Clinica clinica;
    JPanel signup;
    JTextField nombre;
    JTextField identificacion;
    JTextField edad;
    JTextField nuevoUsuario;
    JPasswordField nuevaContrasenia;
    JTextField correo;
    JTextField telefono;
    JComboBox<String> sexo;
    JPanel crearClinica;
    int[][] xClase = {{2, 3, 2, 5}, {3, 3, 2, 5}, {1, 4, 3, 2}};

    public InterfazAdministrador() {
        this.setSize(600, 600);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setTitle("Iniciar sesion");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.white);
        this.setResizable(false);

        titulo = new JLabel("CLINICA HEALTHCARE");
        titulo.setFont(new Font("Calibri", Font.BOLD, 40));
        titulo.setBounds(115, 50, 400, 40);
        this.add(titulo);

        avisoCrearUsuario = new JLabel("O crea un nuevo usuario:");
        avisoCrearUsuario.setFont(new Font("Arial", Font.ITALIC, 15));
        avisoCrearUsuario.setBounds(210, 365, 200, 30);
        this.add(avisoCrearUsuario);
        crearAdmin = new JButton("Crear administrador");
        crearAdmin.setBounds(220, 400, 150, 30);
        crearAdmin.setFocusable(false);
        crearAdmin.addActionListener(this);
        this.add(crearAdmin);

        login = new JPanel();
        login.setLayout(null);
        login.setBounds(150, 140, 300, 300);

        login.setBackground(Color.white);
        this.add(login);
        iniciarSesion = new JButton("Iniciar sesion");
        iniciarSesion.setBounds(70, 150, 150, 30);
        iniciarSesion.setFocusable(false);
        iniciarSesion.addActionListener(this);
        login.add(iniciarSesion);

        usuario = new JTextField();
        usuario.setBounds(70, 20, 150, 45);
        TitledBorder borde = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Ingrese su usuario");
        usuario.setBorder(borde);
        login.add(usuario);

        contrasenia = new JPasswordField();
        contrasenia.setBounds(70, 80, 150, 45);
        TitledBorder bordeContrasenia = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Ingrese su contraseña");
        contrasenia.setBorder(bordeContrasenia);
        login.add(contrasenia);

        signup = new JPanel();
        signup.setLayout(null);
        signup.setBounds(150, 95, 300, 460);
        signup.setBorder(BorderFactory.createLineBorder(Color.black));
        signup.setBackground(Color.white);
        signup.setVisible(false);
        nombre = new JTextField();
        nombre.setBounds(70, 10, 150, 40);
        nombre.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Nombre:"));
        identificacion = new JTextField();
        identificacion.setBounds(70, 60, 150, 40);
        identificacion.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "No. Identificacion:"));
        edad = new JTextField();
        edad.setBounds(70, 110, 150, 40);
        edad.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Edad:"));
        String[] s = {"M", "F"};
        sexo = new JComboBox<>(s);
        sexo.setBackground(Color.white);
        sexo.setBounds(70, 160, 150, 40);
        sexo.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Sexo:"));
        correo = new JTextField();
        correo.setBounds(70, 210, 150, 40);
        correo.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Correo:"));
        telefono = new JTextField();
        telefono.setBounds(70, 260, 150, 40);
        telefono.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Telefono:"));
        nuevoUsuario = new JTextField();
        nuevoUsuario.setBounds(70, 310, 150, 40);
        nuevoUsuario.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Usuario:"));
        nuevaContrasenia = new JPasswordField();
        nuevaContrasenia.setBounds(70, 360, 150, 40);
        nuevaContrasenia.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Contraseña:"));
        crearUsuario = new JButton("Crear Usuario");
        crearUsuario.setBounds(70, 420, 150, 30);
        crearUsuario.setFocusable(false);
        crearUsuario.addActionListener(this);
        signup.add(nuevaContrasenia);
        signup.add(nuevoUsuario);
        signup.add(edad);
        signup.add(identificacion);
        signup.add(nombre);
        signup.add(sexo);
        signup.add(crearUsuario);
        signup.add(correo);
        signup.add(telefono);
        this.add(signup);

        this.setVisible(true);

        clinica = new Clinica("HealthCare", xClase);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == crearAdmin) {
            avisoCrearUsuario.setVisible(false);
            crearAdmin.setVisible(false);
            login.setVisible(false);
            signup.setVisible(true);

        } else if (e.getSource() == iniciarSesion) {
            String usuarioInput = usuario.getText();
            String contraseniaInput = new String(contrasenia.getPassword());
            if (clinica.verificarAdministrador(usuarioInput, contraseniaInput)) {
                JOptionPane.showMessageDialog(null, "Ha ingresado exitosamente", "Bienvenido", JOptionPane.PLAIN_MESSAGE);
                CrearClinica x = new CrearClinica();
                x.setBounds(0, 0, getWidth(), getHeight());
                this.getContentPane().add(x);
                setSize(600, 600);
                x.setVisible(true);

                //  clinica.setMatrizCamilla(x.getMatriz());
                
                
                signup.setVisible(false);
                crearAdmin.setVisible(false);
                login.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(null, "Credenciales invalidas", "Título del mensaje", JOptionPane.WARNING_MESSAGE);
            }
        } else if (e.getSource() == crearUsuario) {
            String userNombre = nombre.getText();
            String userIdentificacion = identificacion.getText();
            int userEdad = Integer.parseInt(edad.getText());
            char userSexo = sexo.getSelectedIndex() == 0 ? 'M' : 'F';
            String userCorreo = correo.getText();
            String userUsuario = nuevoUsuario.getText();
            String userContrasenia = new String(nuevaContrasenia.getPassword());
            String userTelefono = telefono.getText();
            Administrador admin = new Administrador(userUsuario, userContrasenia, userNombre, userSexo, userEdad,
                    userTelefono, userIdentificacion, userCorreo);
            clinica.agregarAdministrador(admin);
            signup.setVisible(false);
            avisoCrearUsuario.setVisible(true);
            crearAdmin.setVisible(true);
            login.setVisible(true);
            limpiarCampos();
        }
    }

    public void limpiarCampos() {
        JTextField[] campos = {usuario, nombre, telefono, identificacion, edad, correo, nuevoUsuario};
        for (int i = 0; i < campos.length; i++) {
            campos[i].setText("");
        }
        contrasenia.setText("");
        nuevaContrasenia.setText("");
    }

}
