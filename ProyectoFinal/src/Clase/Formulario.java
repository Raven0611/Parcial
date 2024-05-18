/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clase;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Dialejo
 */
public class Formulario extends Componente {

    JTextField nombre;
    JTextField identificacion;
    JTextField edad;
    JTextField correo;
    JTextField telefono;
    JTextField otro;
    JComboBox<String> sexo;
    String[] s = {"M", "F"};
    JTextField[] elementos;

    public Formulario() {
        this.setLayout(null);
        this.setBackground(Color.white);
        nombre = crearCampoTexto("Nombre:", 30, 10, 150, 40);
        identificacion = crearCampoTexto("No. Identificacion:", 200, 10, 150, 40);
        edad = crearCampoTexto("Edad:", 30, 60, 150, 40);
        correo = crearCampoTexto("Correo:", 200, 60, 150, 40);
        telefono = crearCampoTexto("Telefono:", 30, 110, 150, 40);
        otro = crearCampoTexto("Especialidad:", 30, 160, 150, 40);

        sexo = new JComboBox<>(s);
        sexo.setBackground(Color.white);
        sexo.setBounds(200, 110, 150, 40);
        sexo.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Sexo:"));
        this.add(sexo);
        elementos = new JTextField[]{nombre, identificacion, edad, correo, telefono, otro};
        agregarCampoTexto();

    }

    private void agregarCampoTexto() {//agrega todos los JTextField al panel formulario

        for (JTextField elemento : elementos) {
            this.add(elemento);
        }
    }

    public String[] getInput() {//retorna un arreglo de strings con la informacion proporcionada por el usuario
        String[] input = new String[7];
        for (int i = 0; i < elementos.length; i++) {
            input[i] = elementos[i].getText();
        }
        input[6] = s[sexo.getSelectedIndex()];
        return input;
    }

    public void limpiarCampos() {
        JTextField[] campos = {nombre, telefono, identificacion, edad, correo, otro};
        for (int i = 0; i < campos.length; i++) {
            campos[i].setText("");
        }
    }

}
