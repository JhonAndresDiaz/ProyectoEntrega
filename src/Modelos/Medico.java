
package Modelos;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author diazje
 */
public class Medico extends Persona implements Serializable {
    
    private ArrayList<Consulta> historialConsultas;
    private ArrayList<DiaCitaSeparada> listaCitas;
    private ArrayList<DiaDescanso> diaDeDescanso;
    private String especializacion;
    private LocalTime horaInicio;
    private LocalTime horaFinal;
    public int medida; //Bloques que tiene el medico por dia

    public Medico(ArrayList<Consulta> historialConsultas, ArrayList<DiaCitaSeparada> listaCitas, ArrayList<DiaDescanso> diaDeDescanso, String especializacion, LocalTime horaInicio, LocalTime horaFinal, int medida, String identificacion, String nombres, String apellidos, int edad, String genero, String numTelefono, String correo, String contrasenia, String rol) {
        super(identificacion, nombres, apellidos, edad, genero, numTelefono, correo, contrasenia, rol);
        this.historialConsultas = historialConsultas;
        this.listaCitas = listaCitas;
        this.diaDeDescanso = diaDeDescanso;
        this.especializacion = especializacion;
        this.horaInicio = horaInicio;
        this.horaFinal = horaFinal;
        this.medida = medida;
    }

    public ArrayList<Consulta> getHistorialConsultas() {
        return historialConsultas;
    }

    public void setHistorialConsultas(ArrayList<Consulta> historialConsultas) {
        this.historialConsultas = historialConsultas;
    }

    public ArrayList<DiaCitaSeparada> getListaCitas() {
        return listaCitas;
    }

    public void setListaCitas(ArrayList<DiaCitaSeparada> listaCitas) {
        this.listaCitas = listaCitas;
    }

    public ArrayList<DiaDescanso> getDiaDeDescanso() {
        return diaDeDescanso;
    }

    public void setDiaDeDescanso(ArrayList<DiaDescanso> diaDeDescanso) {
        this.diaDeDescanso = diaDeDescanso;
    }

    public String getEspecializacion() {
        return especializacion;
    }

    public void setEspecializacion(String especializacion) {
        this.especializacion = especializacion;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalTime getHoraFinal() {
        return horaFinal;
    }

    public void setHoraFinal(LocalTime horaFinal) {
        this.horaFinal = horaFinal;
    }

    public int getMedida() {
        return medida;
    }

    public void setMedida(int medida) {
        this.medida = medida;
    }
}
