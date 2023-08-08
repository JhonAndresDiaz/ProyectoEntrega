
package Modelos;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author diazje
 */
public class Consulta implements Serializable {
    
    private Medico medico;
    private Paciente paciente;
    private LocalTime hora;
    private LocalDate fechaAtencion;
    private String estado;
    private String codigo;
    private String tipoConsulta;
    private String motivo;
    private String notas;
    private String diagnostico;
    private String valoracion;

    public Consulta(Medico medico, Paciente paciente, LocalTime hora, LocalDate fechaAtencion, String estado, String codigo, String tipoConsulta, String motivo, String notas, String diagnostico, String valoracion) {
        this.medico = medico;
        this.paciente = paciente;
        this.hora = hora;
        this.fechaAtencion = fechaAtencion;
        this.estado = estado;
        this.codigo = codigo;
        this.tipoConsulta = tipoConsulta;
        this.motivo = motivo;
        this.notas = notas;
        this.diagnostico = diagnostico;
        this.valoracion = valoracion;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
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

    public LocalDate getFechaAtencion() {
        return fechaAtencion;
    }

    public void setFechaAtencion(LocalDate fechaAtencion) {
        this.fechaAtencion = fechaAtencion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTipoConsulta() {
        return tipoConsulta;
    }

    public void setTipoConsulta(String tipoConsulta) {
        this.tipoConsulta = tipoConsulta;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getValoracion() {
        return valoracion;
    }

    public void setValoracion(String valoracion) {
        this.valoracion = valoracion;
    }
}
