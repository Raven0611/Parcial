/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clase;

/**
 *
 * @author Dialejo
 */
public class Paciente extends Persona{
    private InformacionMedica informacionMedica;

    public Paciente(String nombre, char sexo, int edad, int numeroTelefono, int identificacion, String correo) {
        super(nombre, sexo, edad, numeroTelefono, identificacion, correo);
        this.informacionMedica = new InformacionMedica();
    }

    public InformacionMedica getInformacionMedica() {
        return informacionMedica;
    }
    
    
}
