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
    private int numeroTelefono;
    private int identificacion;
    private String correo;

    public Persona(String nombre, char sexo, int edad, int numeroTelefono, int identificacion, String correo) {
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

    public void setNumeroTelefono(int numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    public void setIdentificacion(int identificacion) {
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

    public int getNumeroTelefono() {
        return numeroTelefono;
    }

    public int getIdentificacion() {
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
