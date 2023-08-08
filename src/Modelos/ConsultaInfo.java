
package Modelos;

/**
 *
 * @author diazje
 */
public class ConsultaInfo {
    
    private Medico medico;
    private int cantidad;

    public ConsultaInfo(Medico medico, int cantidad) {
        this.medico = medico;
        this.cantidad = cantidad;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    
    
}
