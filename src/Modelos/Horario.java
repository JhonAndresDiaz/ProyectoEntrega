
package Modelos;

import java.io.Serializable;
import java.time.LocalTime;

/**
 *
 * @author diazje
 */
public class Horario implements Serializable {
    
    private Paciente paciente;
    private LocalTime hora;
    private boolean esDisponible;

    public Horario(Paciente paciente, LocalTime hora, boolean esDisponible) {
        this.paciente = paciente;
        this.hora = hora;
        this.esDisponible = esDisponible;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public boolean isEsDisponible() {
        return esDisponible;
    }

    public void setEsDisponible(boolean esDisponible) {
        this.esDisponible = esDisponible;
    }   
}
