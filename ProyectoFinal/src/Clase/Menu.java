package Clase;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Menu extends Componente {

    JButton mostrarPersona, InformePaciente;
    JTextArea mostrar;

    public Menu(Clinica clinica) {
        setLayout(null);

        mostrarPersona = crearBoton("Mostrar Camillas", 20, 20, 150, 20);
        mostrarPersona.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrar.setText(clinica.getPisos());
            }
        });
        add(mostrarPersona);
        mostrar = crearTextArea("mostrar", 20, 200, 400, 300);
        JScrollPane scrollPane = new JScrollPane(mostrar);
        scrollPane.setBounds(50, 100, 400, 300);
        add(scrollPane);

        InformePaciente = crearBoton("Cantidad Pacientes", 300, 20, 150, 20);
        InformePaciente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrar.setText(clinica.generarInformePacientes());
            }
        });
        add(InformePaciente);
    }

}
