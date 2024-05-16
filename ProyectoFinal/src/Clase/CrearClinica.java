package Clase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class CrearClinica extends JPanel {
    
    public JButton botonCrearClinica;
    JLabel titulo;
    JLabel[] texto;
    JTextField[] habitaciones;
    private int[][] matriz;
    
    public CrearClinica(Clinica clinica, JPanel panel) {
        setLayout(null);
        
        titulo = new JLabel("Asigna camillas a cada habitacion");
        
        titulo.setFont(new Font("Calibri", Font.BOLD, 20));
        titulo.setBounds(150, 30, 300, 20);
        add(titulo);
        
        texto = new JLabel[3];
        for (int i = 0; i < texto.length; i++) {
            texto[i] = new JLabel("Piso " + (i + 1));
            texto[i].setFont(new Font("Calibri", Font.ITALIC, 17));
            texto[i].setBounds(90, ((i + 1) * 130), 50, 17);
            add(texto[i]);
        }
        
        habitaciones = new JTextField[12];
        for (int i = 0; i < habitaciones.length; i++) {
            habitaciones[i] = new JTextField();
            if (i < 4) {
                habitaciones[i].setBounds((i + 1) * 100, 170, 40, 40);
                habitaciones[i].setBorder(BorderFactory.createTitledBorder("H" + (i + 1)));
            } else if (i < 8) {
                habitaciones[i].setBounds((i - 3) * 100, 300, 40, 40);
                habitaciones[i].setBorder(BorderFactory.createTitledBorder("H" + (i - 3)));
            } else if (i >= 8) {
                habitaciones[i].setBounds((i - 7) * 100, 450, 40, 40);
                habitaciones[i].setBorder(BorderFactory.createTitledBorder("H" + (i - 7)));
            }
            limitar(habitaciones[i]);
            add(habitaciones[i]);
        }
        botonCrearClinica = new JButton("CREAR CLINICA");
        botonCrearClinica.setBounds(400, 500, 150, 40);
        
        botonCrearClinica.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                arreglo(habitaciones);
                clinica.setMatrizCamilla(getMatriz());
                panel.setVisible(true);
                setVisible(false);
            }
        });
        add(botonCrearClinica);
    }
    
    private JTextField limitar(JTextField entrada) {
        
        entrada.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c) || (c == '0' && entrada.getText().isEmpty())) {
                    e.consume(); // Ignorar caracteres no numéricos
                } else {
                    int value = Integer.parseInt(entrada.getText() + c);
                    if (value < 1 || value > 5) {
                        e.consume(); // Ignorar entrada si el valor supera 5
                    }
                }
            }
        });
        return entrada;
    }
    
    private void arreglo(JTextField[] entrada) {
        this.matriz = new int[3][4];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                int index = i * 4 + j;
                if (!entrada[i].getText().isEmpty()) {
                    matriz[i][j] = Integer.parseInt(entrada[index].getText());
                } else {
                    matriz[i][j] = 4;//Si el usuario no puso nada por defecto se asigna 4 camillas
                }
            }
        }
    }
    
    public int[][] getMatriz() {
        return matriz;
    }
    
    public JButton getCrearClinica() {
        return botonCrearClinica;
    }
}
