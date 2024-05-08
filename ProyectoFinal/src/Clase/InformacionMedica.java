/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clase;

/**
 *
 * @author Dialejo
 */
public class InformacionMedica {
    private char tipoSangre;
    private char RH;
    private double estatura;
    private double peso;
    private int tensionArterial;
    private String diagnosticoInicial;
    private int estado;

    public InformacionMedica() {
    }

    public char getTipoSangre() {
        return tipoSangre;
    }

    public void setTipoSangre(char tipoSangre) {
        this.tipoSangre = tipoSangre;
    }

    public char getRH() {
        return RH;
    }

    public void setRH(char RH) {
        this.RH = RH;
    }

    public double getEstatura() {
        return estatura;
    }

    public void setEstatura(double estatura) {
        this.estatura = estatura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public int getTensionArterial() {
        return tensionArterial;
    }

    public void setTensionArterial(int tensionArterial) {
        this.tensionArterial = tensionArterial;
    }

    public String getDiagnosticoInicial() {
        return diagnosticoInicial;
    }

    public void setDiagnosticoInicial(String diagnosticoInicial) {
        this.diagnosticoInicial = diagnosticoInicial;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "InformacionMedica{" + "tipoSangre=" + tipoSangre + ", RH=" + RH + ", estatura=" + estatura + ", peso=" + peso + ", tensionArterial=" + tensionArterial + ", diagnosticoInicial=" + diagnosticoInicial + ", estado=" + estado + '}';
    }
    
    
}
