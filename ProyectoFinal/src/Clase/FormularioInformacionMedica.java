/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clase;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Dialejo
 */
public class FormularioInformacionMedica extends Componente {

    JTextField tensionArterial;
    JTextField estatura;
    JTextField peso;
    JTextArea diagnosticoInicial;
    JComboBox<String> estado;
    JComboBox<String> tipoSangre;
    JComboBox<String> rh;
    String[] estadoValores = {"1", "2", "3", "4", "5"};
    String[] tipoSangreValores = {"A", "B", "O", "AB"};
    String[] rhValores = {"+", "-"};
    JTextField[] elementos;

    public FormularioInformacionMedica() {
        this.setLayout(null);
        this.setBackground(Color.white);
        tensionArterial = crearCampoTexto("Tension Arterial", 30, 10, 150, 40);
        estatura = crearCampoTexto("Estatura:", 200, 10, 150, 40);
        peso = crearCampoTexto("Peso:", 30, 60, 150, 40);
        
        estado = new JComboBox<>(estadoValores);
        estado.setBackground(Color.white);
        estado.setBounds(200, 60, 150, 40);
        estado.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Estado:"));
        this.add(estado);

        tipoSangre = new JComboBox<>(tipoSangreValores);
        tipoSangre.setBackground(Color.white);
        tipoSangre.setBounds(30, 110, 150, 40);
        tipoSangre.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Tipo sangre:"));
        this.add(tipoSangre);

        rh = new JComboBox<>(rhValores);
        rh.setBackground(Color.white);
        rh.setBounds(200, 110, 150, 40);
        rh.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "RH:"));
        this.add(rh);
        
        elementos = new JTextField[]{tensionArterial, estatura, peso};
        agregarCampoTexto();
        
        diagnosticoInicial = new JTextArea();
        diagnosticoInicial.setBounds(30, 160, 300, 100);
        diagnosticoInicial.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Diagnostico inicial:"));
        diagnosticoInicial.setLineWrap(true);
        diagnosticoInicial.setWrapStyleWord(true);
        this.add(diagnosticoInicial);
    }

    private void agregarCampoTexto() {//agrega todos los JTextField al panel formulario

        for (JTextField elemento : elementos) {
            this.add(elemento);
        }
    }

}
