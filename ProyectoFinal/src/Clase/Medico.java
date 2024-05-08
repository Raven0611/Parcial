/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clase;

/**
 *
 * @author Dialejo
 */
public class Medico extends Persona{
    private String especialidad;
    private String usuario;
    private String contrasenia;

    public Medico(String especialidad, String nombre, char sexo, int edad, int numeroTelefono, int identificacion, String correo,
            String usuario, String contrasenia) {
        super(nombre, sexo, edad, numeroTelefono, identificacion, correo);
        this.especialidad = especialidad;
        this.usuario = usuario;
        this.contrasenia = contrasenia;
    }

    public Medico() {
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
    
    
    
    

    @Override
    public String toString() {
        return super.toString() + " " + "Medico{" + "especialidad=" + especialidad + '}';
    }
    
    
    
    
    
}
