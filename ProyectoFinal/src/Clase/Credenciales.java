/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clase;

import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Dialejo
 */
public class Credenciales extends Componente{
    JPasswordField contrasenia;
    JTextField usuario;
    
    public Credenciales() {
        this.setLayout(null);
        this.setBackground(Color.white);
        usuario = crearCampoTexto("Ingrese su usuario:", 70, 20, 150, 45);
        contrasenia = crearCampoContrasenia("Ingrese su contraseña:", 70, 80, 150, 45);
        this.add(usuario);
        this.add(contrasenia);
    }
    
    public void limpiarCredenciales() {
        usuario.setText("");
        contrasenia.setText("");
    }
}
