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
public class Registro extends Componente {
    JButton registrar;
    Formulario formulario;
    Credenciales credenciales;
    Object listener;
    String tipoRegistro;
    
    public Registro(Object listener, String tipoRegistro) {
        this.setLayout(null);
        this.setBackground(Color.white);
        this.listener = (InterfazAdministrador) listener;
        this.tipoRegistro = tipoRegistro;
        
        formulario = new Formulario();
        formulario.setBounds(50,0,400, 200);
        formulario.otro.setVisible(false);
        this.add(formulario);
        
        credenciales = new Credenciales();
        credenciales.setBounds(100, 200, 300, 140);
        this.add(credenciales);
        
        registrar = crearBoton("Registrar", 200, 350, 100, 30);
        agregarListener();
        this.add(registrar);
        
    }
    
    public void agregarListener() {
        if (tipoRegistro.equals("administrador")) {
            InterfazAdministrador i = (InterfazAdministrador) listener;
            registrar.addActionListener(i);
        }
        
    }
    
    public void limpiarRegistro() {
        formulario.limpiarCampos();
        credenciales.limpiarCredenciales();
    }
    
}
