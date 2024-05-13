/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clase;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Dialejo
 */
public class Card extends Componente implements ItemListener{
    JPanel cards;

    public Card() {

        this.setBounds(0, 0, 500, 450);
        this.setLayout(new BorderLayout());
        this.setBackground(Color.white);
        
        cards = new JPanel(new CardLayout());
        cards.setBackground(Color.yellow);
        cards.setBorder(BorderFactory.createLineBorder(Color.black));
        
        JPanel panel1 = new JPanel();
        
        panel1.add(new JLabel("Contenido panel 1"));
        cards.add(panel1, "Panel 1");

        JPanel panel2 = new JPanel();
        panel2.add(new JLabel("Contenido panel 2"));
        cards.add(panel2, "Panel 2");

        JPanel panel3 = new JPanel();
        panel3.add(new JLabel("Contenido panel 3"));
        cards.add(panel3, "Panel 3");

        JPanel comboBoxPane = new JPanel();
        comboBoxPane.setBackground(Color.white);
        String comboBoxItems[] = {"Panel 1", "Panel 2", "Panel 3"};
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

}
