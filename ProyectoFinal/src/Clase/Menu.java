package Clase;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Menu extends Componente {

    JButton mostrarPersona;
    JTextArea mostrar;

    public Menu(Clinica clinica) {
        setLayout(null);

        mostrarPersona = crearBoton("mostrar Personas", 20, 0, 150, 20);
        mostrarPersona.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrar.setText(clinica.getPisos());
            }
        });

        add(mostrarPersona);
        mostrar = crearTextArea("mostrar", 180, 0, 400, 300);
        JScrollPane scrollPane = new JScrollPane(mostrar);
        scrollPane.setBounds(180, 0, 400, 300);
        add(scrollPane);
    }
}

class Inicio extends JFrame {

    public Inicio() {
        setTitle("Inicio");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        int[][] matrizCamilla = {
            {2, 2, 2, 2},
            {2, 2, 2, 2},
            {2, 2, 2, 2}
        };
        Clinica clinica = new Clinica("HealthCare", matrizCamilla);

        Menu menu = new Menu(clinica);
        add(menu);

        setVisible(true);
    }

    public static void main(String[] args) {

        Inicio inicio = new Inicio();

    }
}
