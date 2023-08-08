
package Modelos;

/**
 *
 * @author diazje
 */
public class ConsultaInfoPaciente {
    
    private Paciente paciente;
    private int cantidad;

    public ConsultaInfoPaciente(Paciente paciente, int cantidad) {
        this.paciente = paciente;
        this.cantidad = cantidad;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    
}
