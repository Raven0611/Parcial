/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clase;

/**
 *
 * @author Dialejo
 */
public class Administrador extends Persona{
    private String usuario;
    private String contrasenia;

    public Administrador(String usuario, String contrasenia, String nombre, char sexo, int edad, int numeroTelefono, int identificacion, String correo) {
        super(nombre, sexo, edad, numeroTelefono, identificacion, correo);
        this.usuario = usuario;
        this.contrasenia = contrasenia;
    }

    public Administrador() {
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    
    
    
}
