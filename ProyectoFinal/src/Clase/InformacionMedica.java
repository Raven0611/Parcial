
package Clase;

public class InformacionMedica {
    private char tipoSangre;
    private char RH;
    private String estatura;
    private String peso;
    private String tensionArterial;
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

    public String getEstatura() {
        return estatura;
    }

    public void setEstatura(String estatura) {
        this.estatura = estatura;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getTensionArterial() {
        return tensionArterial;
    }

    public void setTensionArterial(String tensionArterial) {
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
