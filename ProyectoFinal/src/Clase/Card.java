/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clase;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author Dialejo
 */
public class Card extends Componente implements ItemListener, ActionListener {
    
    JPanel cards, panel3;
    JPanel registrarMedicoCard;
    JPanel registroMedicoPanel, registroAdministrativoPanel;
    JButton registrarMedicoBtn, registrarAdministrativoBtn;
    Formulario formularioMedico, formularioAdministrativo;
    Credenciales credencialesMedico, credencialesAdministrativo;
    private final String registrarMedicoLabel = "Registrar medico";
    private final String registrarAdministrativoLabel = "Registrar Administrativo";
    Clinica clinica;
    
    public Card(Clinica clinica) {
        this.clinica = clinica;
        
        this.setBounds(0, 0, 500, 450);
        this.setLayout(new BorderLayout());
        this.setBackground(Color.white);
        
        formularioMedico = crearFormulario();
        credencialesMedico = crearCredenciales();
        formularioAdministrativo = crearFormulario();
        credencialesAdministrativo = crearCredenciales();
        
        cards = new JPanel(new CardLayout());
        cards.setBackground(Color.yellow);
        cards.setBorder(BorderFactory.createLineBorder(Color.black));
        
        registroMedicoPanel = new JPanel();
        registroMedicoPanel.setLayout(null);
        registroMedicoPanel.add(formularioMedico);
        registroMedicoPanel.add(credencialesMedico);
        registroMedicoPanel.setBackground(Color.white);
        
        registroAdministrativoPanel = new JPanel();
        registroAdministrativoPanel.setLayout(null);
        registroAdministrativoPanel.add(formularioAdministrativo);
        registroAdministrativoPanel.add(credencialesAdministrativo);
        registroAdministrativoPanel.setBackground(Color.white);
        
        registrarMedicoCard = new JPanel(new BorderLayout());
        registrarMedicoBtn = new JButton("Registrar medico");
        registrarMedicoBtn.addActionListener(this);
        
        registrarMedicoCard.add(registroMedicoPanel, BorderLayout.CENTER);
        registrarMedicoCard.add(registrarMedicoBtn, BorderLayout.SOUTH);
        cards.add(registrarMedicoCard, registrarMedicoLabel);
        
        JPanel registrarAdministrativoCard = new JPanel(new BorderLayout());
        registrarAdministrativoBtn = new JButton("Registrar Administrativo");
        registrarAdministrativoBtn.addActionListener(this);
        registrarAdministrativoCard.add(registroAdministrativoPanel, BorderLayout.CENTER);
        registrarAdministrativoCard.add(registrarAdministrativoBtn, BorderLayout.SOUTH);
        cards.add(registrarAdministrativoCard, registrarAdministrativoLabel);
        
        panel3 = new JPanel();
        panel3.add(new JButton("Contenido panel 3"));
        cards.add(panel3, "Eliminar Medico");
        
        JPanel comboBoxPane = new JPanel();
        comboBoxPane.setBackground(Color.white);
        String comboBoxItems[] = {registrarMedicoLabel, registrarAdministrativoLabel, "Eliminar Medico",
        "Eliminar Administrativo"};
        JComboBox cb = new JComboBox(comboBoxItems);
        cb.setEditable(false);
        cb.addItemListener(this);
        comboBoxPane.add(cb);
        
        this.add(comboBoxPane, BorderLayout.PAGE_START);
        this.add(cards, BorderLayout.CENTER);
        
    }
    
    @Override
    public void itemStateChanged(ItemEvent evt) {
        CardLayout cl = (CardLayout) (cards.getLayout());
        System.out.println((String) evt.getItem());
        if (((String) evt.getItem()).equals("Eliminar Medico")) {
            cards.add(eliminarUsuario(clinica.getMedicos(), "medico"), "Eliminar Medico");
            
        } else if (((String) evt.getItem()).equals("Eliminar Administrativo")) {
            cards.add(eliminarUsuario(clinica.getAdmins(), "administrativo"), "Eliminar Administrativo");
        }
        cl.show(cards, (String) evt.getItem());
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == registrarMedicoBtn) {
            registrarMedico();
            
        } else if (e.getSource() == registrarAdministrativoBtn) {
            registrarAdministrativo();
        }
    }
    
    private void registrarMedico() {
        String[] input = formularioMedico.getInput();
        String usuario = credencialesMedico.usuario.getText();
        String contrasenia = new String(credencialesMedico.contrasenia.getPassword());
        Medico medico = new Medico(input[5], input[0], input[6].charAt(0), Integer.parseInt(input[2]),
                input[4], input[1], input[3], usuario, contrasenia);
        clinica.agregarMedico(medico);
        formularioMedico.limpiarCampos();
        credencialesMedico.limpiarCredenciales();
    }
    
    private void registrarAdministrativo() {
        String[] input = formularioAdministrativo.getInput();
        String usuario = credencialesAdministrativo.usuario.getText();
        String contrasenia = new String(credencialesAdministrativo.contrasenia.getPassword());
        Administrativo administrativo = new Administrativo(input[5], input[0], input[6].charAt(0), Integer.parseInt(input[2]),
                input[4], input[1], input[3], usuario, contrasenia);
        clinica.agregarAdministrativo(administrativo);
        formularioAdministrativo.limpiarCampos();
        credencialesAdministrativo.limpiarCredenciales();
    }
    
    private Formulario crearFormulario() {
        Formulario formulario = new Formulario();
        formulario.setBounds(50, 0, 400, 200);
        return formulario;
    }
    
    private Credenciales crearCredenciales() {
        Credenciales credenciales = new Credenciales();
        credenciales.setBounds(100, 200, 300, 140);
        return credenciales;
    }
    
    private JScrollPane eliminarUsuario(Persona[] usuarios, String tipoUsuario) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(Color.white);
        
        for (int i = 0; i < usuarios.length; i++) {
            if (usuarios[i] != null) {
                JPanel celda = new JPanel();
                celda.setLayout(new BoxLayout(celda, BoxLayout.X_AXIS));
                String[] info = {"No. Identificacion: " + usuarios[i].getIdentificacion(),
                    "Nombre: " + usuarios[i].getNombre()};
                for (int j = 0; j < info.length; j++) {
                    JLabel label = new JLabel(info[j]);
                    label.setFont(new Font("Arial", Font.PLAIN, 12));
                    celda.add(label);
                    celda.add(Box.createHorizontalGlue());
                }
                JButton eliminar = new JButton("Eliminar");
                eliminar.setActionCommand(usuarios[i].getIdentificacion());
                eliminar.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        boolean ans;
                        if (tipoUsuario.equals("medico")) {
                            ans = clinica.eliminarMedico(e.getActionCommand());
                        } else {
                            ans = clinica.eliminarAdministrativo(e.getActionCommand());
                        }
                        
                        JButton btn = (JButton) e.getSource();
                        btn.setEnabled(false);
                        System.out.println(ans);
                    }
                });
                eliminar.setBackground(Color.red);
                celda.add(eliminar);
                panel.add(celda);
            }
        }
        
        return new JScrollPane(panel);
    }
    
}
