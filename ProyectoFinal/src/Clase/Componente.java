/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clase;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Dialejo
 */
public class Componente extends JPanel {

    protected JButton crearBoton(String label, int x, int y, int width, int height) {

        JButton btn = new JButton(label);
        btn.setFocusable(false);
        btn.setBounds(x, y, width, height);
        return btn;
    }

    protected JTextField crearCampoTexto(String label, int x, int y, int width, int height) {
        JTextField campo = new JTextField();
        campo.setBounds(x, y, width, height);
        campo.setBorder(getBorder(label));
        return campo;
    }

    protected JPasswordField crearCampoContrasenia(String label, int x, int y, int width, int height) {
        JPasswordField contrasenia = new JPasswordField();
        contrasenia.setBounds(x, y, width, height);
        contrasenia.setBorder(getBorder(label));

        return contrasenia;
    }

    protected TitledBorder getBorder(String label) {
        return BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), label);
    }

}
