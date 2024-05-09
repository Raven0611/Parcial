/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clase;

/**
 *
 * @author Dialejo
 */
public class Administrativo extends Persona{
    private String usuario;
    private String contrasenia;
    private String cargo;

    public Administrativo(String usuario, String contrasenia, String cargo, String nombre, char sexo, int edad, String numeroTelefono, String identificacion, String correo) {
        super(nombre, sexo, edad, numeroTelefono, identificacion, correo);
        this.usuario = usuario;
        this.contrasenia = contrasenia;
        this.cargo = cargo;
    }

    public Administrativo() {
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
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
        return super.toString() + " " + "Administrativo{" + "cargo=" + cargo + '}';
    }
    
    
    
    
    
}
