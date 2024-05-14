/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clase;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Dialejo
 */
public class Card extends Componente implements ItemListener, ActionListener{
    JPanel cards;
    JPanel registrarMedicoCard;
    JPanel registro;
    JButton registrarMedicoBtn;
    Formulario formulario;
    Credenciales credenciales;
    private final String registrarMedico = "Registrar medico";
    Clinica clinica;
    
    public Card(Clinica clinica) {
        this.clinica = clinica;
        
        this.setBounds(0, 0, 500, 450);
        this.setLayout(new BorderLayout());
        this.setBackground(Color.white);
        
        formulario = new Formulario();
        formulario.setBounds(50,0,400, 200);
        credenciales = new Credenciales();
        credenciales.setBounds(100, 200, 300, 140);
        
        cards = new JPanel(new CardLayout());
        cards.setBackground(Color.yellow);
        cards.setBorder(BorderFactory.createLineBorder(Color.black));
        
        registro = new JPanel();
        registro.setLayout(null);
        registro.add(formulario);
        registro.add(credenciales);
        registro.setBackground(Color.white);
        
        registrarMedicoCard = new JPanel(new BorderLayout());
        registrarMedicoBtn = new JButton("Registrar medico");
        registrarMedicoBtn.addActionListener(this);
        
        registrarMedicoCard.add(registro, BorderLayout.CENTER);
        registrarMedicoCard.add(registrarMedicoBtn, BorderLayout.SOUTH);
        cards.add(registrarMedicoCard, registrarMedico);

        JPanel panel2 = new JPanel();
        panel2.add(new JLabel("Contenido panel 2"));
        cards.add(panel2, "Panel 2");

        JPanel panel3 = new JPanel();
        panel3.add(new JLabel("Contenido panel 3"));
        cards.add(panel3, "Panel 3");

        JPanel comboBoxPane = new JPanel();
        comboBoxPane.setBackground(Color.white);
        String comboBoxItems[] = {registrarMedico, "Panel 2", "Panel 3"};
        JComboBox cb = new JComboBox(comboBoxItems);
        cb.setEditable(false);
        cb.addItemListener(this);
        comboBoxPane.add(cb);
        
        this.add(comboBoxPane, BorderLayout.PAGE_START);
        this.add(cards, BorderLayout.CENTER);

    }

    @Override
    public void itemStateChanged(ItemEvent evt) {
        CardLayout cl = (CardLayout)(cards.getLayout());
        cl.show(cards, (String)evt.getItem());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == registrarMedicoBtn) {
            String[] input = formulario.getInput();
            
        }
    }

}
