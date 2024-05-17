/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clase;

/**
 *
 * @author Dialejo
 */
public class Persona {
    private String nombre;
    private char sexo;
    private int edad;
    private String numeroTelefono;
    private String identificacion;
    private String correo;

    public Persona(String nombre, char sexo, int edad, String numeroTelefono, String identificacion, String correo) {
        this.nombre = nombre;
        this.sexo = sexo;
        this.edad = edad;
        this.numeroTelefono = numeroTelefono;
        this.identificacion = identificacion;
        this.correo = correo;
    }

    public Persona() {
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    public String getNombre() {
        return nombre;
    }

    public char getSexo() {
        return sexo;
    }

    public int getEdad() {
        return edad;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public String getCorreo() {
        return correo;
    }
    

    @Override
    public String toString() {
        return "{" + "nombre=" + nombre + ", sexo=" + sexo + ", edad=" + edad + ", numeroTelefono=" + numeroTelefono + ", identificacion=" + identificacion + ", correo=" + correo + '}';
    }
    
    
    
    
}
