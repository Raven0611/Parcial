package Clase;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class MenuPrincipal extends JFrame {
    JLabel titulo;
    Inicio inicio;
    InterfazGeneral interfaz;
    
    public MenuPrincipal() {
        this.setLayout(null);
        this.setBackground(Color.white);
        this.setSize(600, 600);
        this.setLocationRelativeTo(null);
        this.setTitle("HealthCare");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.white);
        this.setResizable(false);
        
        inicio = new Inicio(this);
        interfaz = new InterfazGeneral(inicio);
        interfaz.setVisible(false);
        
        titulo = new JLabel("CLINICA HEALTHCARE");
        titulo.setFont(new Font("Calibri", Font.BOLD, 40));
        titulo.setBounds(115, 30, 400, 40);
        this.add(titulo);
        this.add(inicio);
        this.add(interfaz);
        
        
        this.setVisible(true);
    }
    
    public void mostrarComponente(String componente) {
        interfaz.setVisible(true);
        interfaz.setDependencia(componente);
        
    }
    
   

    
    
}