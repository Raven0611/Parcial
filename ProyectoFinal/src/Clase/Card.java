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
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Card extends Componente implements ItemListener, ActionListener {

    JPanel cards, eliminarUsuarioPanel;
    JPanel registrarMedicoCard;
    JPanel registroMedicoPanel, registroAdministrativoPanel;
    JButton registrarMedicoBtn, registrarAdministrativoBtn;
    Formulario formularioMedico, formularioAdministrativo;
    Credenciales credencialesMedico, credencialesAdministrativo;
    private final String registrarMedicoLabel = "Registrar medico";
    private final String registrarAdministrativoLabel = "Registrar Administrativo";
    private final String menuLabel = "Generar Informe";
    Clinica clinica;
    JComboBox cb;
    String comboBoxItems[];

    public Card(Clinica clinica, String[] funcionalidades) {
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

        eliminarUsuarioPanel = new JPanel();
        cards.add(eliminarUsuarioPanel, "Eliminar Medico");

        Menu menuPanel = new Menu(clinica);
        cards.add(menuPanel, menuLabel);

        JPanel comboBoxPane = new JPanel();
        comboBoxPane.setBackground(Color.white);
        cb = new JComboBox(funcionalidades);
        cb.setEditable(false);
        cb.addItemListener(this);
        comboBoxPane.add(cb);

        this.add(comboBoxPane, BorderLayout.PAGE_START);
        this.add(cards, BorderLayout.CENTER);

    }

    public void actualizarClinica(int[][] matriz) {
        this.clinica.setMatrizCamilla(matriz);
    }

    @Override
    public void itemStateChanged(ItemEvent evt) {
        CardLayout cl = (CardLayout) (cards.getLayout());
        if (((String) evt.getItem()).equals("Eliminar Medico")) {
            cards.add(eliminarUsuario(clinica.getMedicos(), "medico"), "Eliminar Medico");

        } else if (((String) evt.getItem()).equals("Eliminar Administrativo")) {
            cards.add(eliminarUsuario(clinica.getAdmins(), "administrativo"), "Eliminar Administrativo");

        } else if (((String) evt.getItem()).equals("Ingresar Paciente")) {
            cards.add(ingresarPaciente(), "Ingresar Paciente");

        } else if (((String) evt.getItem()).equals("Buscar Paciente")) {
            cards.add(buscarPaciente(), "Buscar Paciente");

        } else if (((String) evt.getItem()).equals("Eliminar Paciente")) {
            cards.add(eliminarPaciente(), "Eliminar Paciente");

        } else if (((String) evt.getItem()).equals("Informacion Medica Paciente")) {
            cards.add(informacionMedicaPaciente(), "Informacion Medica Paciente");

        } else if (((String) evt.getItem()).equals("Generar Informe")) {
            cards.add(new Menu(clinica), "Generar Informe");
            
        } else if (((String) evt.getItem()).equals("Inhabilitar habitacion")) {
            cards.add(inhabilitarHabitacion(), "Inhabilitar habitacion");
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
    
    

    private void registrarMedico() { //registra personal medico
        String[] input = formularioMedico.getInput();
        String usuario = credencialesMedico.usuario.getText();
        String contrasenia = new String(credencialesMedico.contrasenia.getPassword());
        Medico medico = new Medico(input[5], input[0], input[6].charAt(0), Integer.parseInt(input[2]),
                input[4], input[1], input[3], usuario, contrasenia);
        clinica.agregarMedico(medico);
        formularioMedico.limpiarCampos();
        credencialesMedico.limpiarCredenciales();
    }

    private void registrarAdministrativo() { //Registra personal administrativo
        String[] input = formularioAdministrativo.getInput();
        String usuario = credencialesAdministrativo.usuario.getText();
        String contrasenia = new String(credencialesAdministrativo.contrasenia.getPassword());
        Administrativo administrativo = new Administrativo(input[5], input[0], input[6].charAt(0), Integer.parseInt(input[2]),
                input[4], input[1], input[3], usuario, contrasenia);
        clinica.agregarAdministrativo(administrativo);
        formularioAdministrativo.limpiarCampos();
        credencialesAdministrativo.limpiarCredenciales();
    }

    private Formulario crearFormulario() {//retorna un JPanel con campos para ingresar informacion basica
        Formulario formulario = new Formulario();
        formulario.setBounds(50, 0, 400, 200);
        return formulario;
    }

    private Credenciales crearCredenciales() { //retorna un JPanel con campos para ingresar credenciales
        Credenciales credenciales = new Credenciales();
        credenciales.setBounds(100, 200, 300, 140);
        return credenciales;
    }

    //retorna un JScrollPane que contiene el listado de los usuarios(admins o medicos) y un boton para eliminarlos
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

    private JPanel ingresarPaciente() { //retorna un panel con un formulario para ingresar a un paciente
        Formulario formulario = new Formulario();
        formulario.otro.setVisible(false);
        JPanel ingresarPacienteFormulario = new JPanel(new BorderLayout());
        ingresarPacienteFormulario.add(formulario, BorderLayout.CENTER);
        JButton ingresarPacienteBtn = new JButton("Ingresar paciente");
        ingresarPacienteBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] input = formulario.getInput();
                Paciente paciente = new Paciente(input[0], input[6].charAt(0), Integer.parseInt(input[2]),
                        input[4], input[1], input[3]);
                formulario.limpiarCampos();
                String camillaIngresado = clinica.ingresarPaciente(paciente);
                if (!camillaIngresado.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Paciente ingresado a camilla " + camillaIngresado, "Título del mensaje", JOptionPane.PLAIN_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Paciente no ingresado, no hay camillas disponibles", "Título del mensaje", JOptionPane.WARNING_MESSAGE);
                }

            }
        });
        ingresarPacienteFormulario.add(ingresarPacienteBtn, BorderLayout.SOUTH);
        return ingresarPacienteFormulario;
    }

    private JPanel buscarPaciente() { //retorna un JPanel con campos para poder buscar un paciente
        JPanel panel = new JPanel(new BorderLayout());
        JPanel panelBuscar = new JPanel();
        panelBuscar.setLayout(new BoxLayout(panelBuscar, BoxLayout.X_AXIS));

        JLabel label = new JLabel("Ingrese id o nombre del paciente: ");
        JButton buscarBtn = new JButton("Buscar");
        JTextField campoTexto = new JTextField();
        JTextArea informacionPaciente = new JTextArea();
        informacionPaciente.setEditable(false);
        buscarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String pacienteInfo = campoTexto.getText();
                String[] resultado = clinica.buscarPaciente(pacienteInfo);
                JPanel r = new JPanel();
                r.setLayout(new BoxLayout(r, BoxLayout.Y_AXIS));
                if (resultado[0].isEmpty()) {
                    informacionPaciente.setText("Paciente no encontrado");
                } else {
                    informacionPaciente.setText("Piso: " + resultado[0] + "\nHabitacion: "
                            + resultado[1] + "\nCamilla: " + resultado[2]);
                }
            }
        });

        panelBuscar.add(label);
        panelBuscar.add(Box.createHorizontalGlue());
        panelBuscar.add(campoTexto);
        panelBuscar.add(Box.createHorizontalGlue());
        panelBuscar.add(buscarBtn);
        panel.add(panelBuscar, BorderLayout.NORTH);
        panel.add(informacionPaciente, BorderLayout.CENTER);
        return panel;
    }

    //retorna un jpanel que contiene nombre e identificacion de todos los pacientes y un boton para eliminarlos
    private JPanel eliminarPaciente() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(Color.white);
        Paciente[] pacientes = clinica.getPacientes();
        for (int i = 0; i < pacientes.length; i++) {
            if (pacientes[i] == null) {
                break;
            }
            JPanel celda = new JPanel();
            celda.setLayout(new BoxLayout(celda, BoxLayout.X_AXIS));
            String[] info = {"No. Identificacion: " + pacientes[i].getIdentificacion(),
                "Nombre: " + pacientes[i].getNombre()};
            for (int j = 0; j < info.length; j++) {
                JLabel label = new JLabel(info[j]);
                label.setFont(new Font("Arial", Font.PLAIN, 12));
                celda.add(label);
                celda.add(Box.createHorizontalGlue());
            }
            JButton eliminar = new JButton("Eliminar");
            eliminar.setActionCommand(pacientes[i].getIdentificacion());
            eliminar.setBackground(Color.red);
            eliminar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    clinica.eliminarPaciente(e.getActionCommand());
                    JButton btn = (JButton) e.getSource();
                    btn.setEnabled(false);
                }
            });
            celda.add(eliminar);
            panel.add(celda);

        }

        return panel;
    }

    //retorna un panel con campos para actualizar/ingresar la informacion medica de un paciente
    private JPanel informacionMedicaPaciente() {
        FormularioInformacionMedica form = new FormularioInformacionMedica();
        form.setVisible(false);
        JPanel panel = new JPanel(new BorderLayout());
        JPanel panelBuscar = new JPanel();
        panelBuscar.setLayout(new BoxLayout(panelBuscar, BoxLayout.X_AXIS));
        JButton ingresarBtn = new JButton("Ingresar Informacion");
        ingresarBtn.setVisible(false);
        JLabel label = new JLabel("Ingrese id o nombre del paciente: ");
        JButton buscarBtn = new JButton("Buscar");
        JTextField campoTexto = new JTextField();
        buscarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String pacienteInfo = campoTexto.getText();
                InformacionMedica infoMedica = clinica.getInformacionMedicaPaciente(pacienteInfo);
                if (infoMedica == null) {
                    cb.setSelectedIndex(0);
                    JOptionPane.showMessageDialog(null, "Paciente no encontrado", "Título del mensaje", JOptionPane.WARNING_MESSAGE);
                } else {
                    form.diagnosticoInicial.setText(infoMedica.getDiagnosticoInicial());
                    form.tensionArterial.setText(infoMedica.getTensionArterial());
                    form.peso.setText(infoMedica.getPeso());
                    form.estatura.setText(infoMedica.getEstatura());
                    form.estado.setSelectedIndex(infoMedica.getEstado() != 0 ? infoMedica.getEstado() - 1 : 0);
                    form.rh.setSelectedItem(infoMedica.getRH());
                    form.tipoSangre.setSelectedItem(infoMedica.getTipoSangre() + "");
                    form.setVisible(true);
                    ingresarBtn.setVisible(true);
                    ingresarBtn.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            infoMedica.setEstado(Integer.parseInt((String) form.estado.getSelectedItem()));
                            infoMedica.setDiagnosticoInicial(form.diagnosticoInicial.getText());
                            infoMedica.setTensionArterial(form.tensionArterial.getText());
                            infoMedica.setPeso(form.peso.getText());
                            infoMedica.setEstatura(form.estatura.getText());
                            infoMedica.setRH(((String) form.rh.getSelectedItem()).charAt(0));
                            infoMedica.setTipoSangre(((String) form.tipoSangre.getSelectedItem()).charAt(0));
                            cb.setSelectedIndex(0);
                        }
                    });
                }

            }
        });

        panelBuscar.add(label);
        panelBuscar.add(Box.createHorizontalGlue());
        panelBuscar.add(campoTexto);
        panelBuscar.add(Box.createHorizontalGlue());
        panelBuscar.add(buscarBtn);
        panel.add(panelBuscar, BorderLayout.NORTH);
        panel.add(form, BorderLayout.CENTER);
        panel.add(ingresarBtn, BorderLayout.SOUTH);
        return panel;
    }

    //retorna un panel 
    private JScrollPane inhabilitarHabitacion() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        for (int i = 0; i < 3; i++) {
            panel.add(new JLabel("Piso " + (i + 1)));
            JPanel botones = new JPanel();
            botones.setLayout(new BoxLayout(botones, BoxLayout.X_AXIS));
            for (int j = 0; j < 4; j++) {
                boolean estado = clinica.getEstadoHabitacion(i, j);
                JButton inhabilitarBtn = new JButton((estado ? "Inhabilitar" : "Habilitar") + "Habitacion\n" + clinica.getHabitacionId(i, j));
                inhabilitarBtn.setActionCommand(clinica.getHabitacionId(i, j));
                inhabilitarBtn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String habitacionId = e.getActionCommand();
                        int piso = habitacionId.charAt(0) - 49;
                        int habitacion = habitacionId.charAt(4) - 49;
                        if (estado) {
                            clinica.desactivarHabitacion(piso, habitacion);
                            clinica.desplazarPacientesHabitacionDesactivada(piso, habitacion);
                        } else {
                            clinica.activarHabitacion(piso, habitacion);
                        }
                        
                        JButton btn = (JButton) e.getSource();
                        btn.setEnabled(false);
                    }
                });
                botones.add(inhabilitarBtn);
            }
            panel.add(botones);
        }

        return new JScrollPane(panel);
    }

}
