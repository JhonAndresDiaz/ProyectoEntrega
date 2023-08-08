
package Modelos;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author diazje
 */
public class DiaDescanso implements Serializable {
    
    private String estadoDia;
    private LocalDate diaSeleccionado;

    public DiaDescanso(String estadoDia, LocalDate diaSeleccionado) {
        this.estadoDia = estadoDia;
        this.diaSeleccionado = diaSeleccionado;
    }

    public String getEstadoDia() {
        return estadoDia;
    }

    public void setEstadoDia(String estadoDia) {
        this.estadoDia = estadoDia;
    }

    public LocalDate getDiaSeleccionado() {
        return diaSeleccionado;
    }

    public void setDiaSeleccionado(LocalDate diaSeleccionado) {
        this.diaSeleccionado = diaSeleccionado;
    }
}
