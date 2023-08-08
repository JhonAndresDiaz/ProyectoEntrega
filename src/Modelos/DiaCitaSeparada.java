
package Modelos;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author diazje
 */
public class DiaCitaSeparada implements Serializable {
    
    private ArrayList<Horario> horariosCitas;
    private LocalDate dia;

    public DiaCitaSeparada(ArrayList<Horario> horarioCitas, LocalDate dia) {
        this.horariosCitas = horarioCitas;
        this.dia = dia;
    }

    public ArrayList<Horario> getHorarioCitas() {
        return horariosCitas;
    }

    public void setHorarioCitas(ArrayList<Horario> horarioCitas) {
        this.horariosCitas = horarioCitas;
    }

    public LocalDate getDia() {
        return dia;
    }

    public void setDia(LocalDate dia) {
        this.dia = dia;
    }  
}
