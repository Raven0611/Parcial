/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clase;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author Dialejo
 */
public class Inicio extends Componente implements ActionListener{
    JButton moduloMedicos;
    JButton moduloPersonalAdmin;
    JButton moduloAdmin;
    MenuPrincipal menu;
    
    
    public Inicio(MenuPrincipal menu) {
        this.setLayout(null);
        this.setBounds(110, 140, 400, 300);
        this.setBackground(Color.white);
        moduloMedicos = crearBoton("Medicos", 10, 10, 160, 60);
        moduloPersonalAdmin = crearBoton("Administrativo", 200, 10, 160, 60);
        moduloAdmin = crearBoton("Administrador", 110, 100, 160, 60);
        this.add(moduloMedicos);
        this.add(moduloPersonalAdmin);
        this.add(moduloAdmin);
        this.menu = menu;
    }
    
    @Override
    protected JButton crearBoton(String title, int x, int y, int width, int height) {
        
        String label = "<html><p style='font-size: 15px; text-align: center;'>Modulo <br> %s</p></html>";
        JButton btn = new JButton(String.format(label, title));
        btn.addActionListener(this);
        btn.setFocusable(false);
        btn.setBounds(x, y, width, height);
        return btn;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.setVisible(false);
        
        if (e.getSource() == moduloAdmin) {
            menu.mostrarComponente("administrador");
            
        } else if (e.getSource() == moduloMedicos) {
            menu.mostrarComponente("medico");
            
        } else {
            menu.mostrarComponente("administrativo");
        }
    }
}
