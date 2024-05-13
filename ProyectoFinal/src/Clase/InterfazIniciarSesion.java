/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clase;

import java.awt.Color;
import javax.swing.JButton;

/**
 *
 * @author Dialejo
 */
public class InterfazIniciarSesion extends Componente{
    JButton iniciarSesion;
    Credenciales credenciales;
    Object listener;
    String tipoInicioSesion;
    
    public InterfazIniciarSesion(Object listener, String tipoInicioSesion) {
        this.listener = listener;
        this.tipoInicioSesion = tipoInicioSesion;
        
        this.setLayout(null);
        this.setBackground(Color.white);
        
        iniciarSesion = crearBoton("Iniciar sesion", 70, 150, 150, 30);
        agregarListener();
        
        credenciales = new Credenciales();
        credenciales.setBounds(0, 5, 300, 150);
        this.add(iniciarSesion);
        this.add(credenciales);
    }
    
    public void agregarListener() {
        if (tipoInicioSesion.equals("administrador")) {
            InterfazAdministrador i = (InterfazAdministrador) listener;
            iniciarSesion.addActionListener(i);
        }
    }
}
