
package Clase;

public class Paciente extends Persona{
    private InformacionMedica informacionMedica;

    public Paciente(String nombre, char sexo, int edad, String numeroTelefono, String identificacion, String correo) {
        super(nombre, sexo, edad, numeroTelefono, identificacion, correo);
        this.informacionMedica = new InformacionMedica();
    }

    public InformacionMedica getInformacionMedica() {
        return informacionMedica;
    }
    
    
}
