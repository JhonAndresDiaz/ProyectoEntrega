
package Modelos;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author diazje
 */
public class Peticion implements Serializable {
    
    private Consulta consulta;
    private String codigo;
    private String motivoAtencion;
    private LocalDate fechaCreacion;
    private String detallePQRS;
    private String estado;
    private String respAdmin;
    private String respPaciente;

    public Peticion(Consulta consulta, String codigo, String motivoAtencion, LocalDate fechaCreacion, String detallePQRS, String estado, String respAdmin, String respPaciente) {
        this.consulta = consulta;
        this.codigo = codigo;
        this.motivoAtencion = motivoAtencion;
        this.fechaCreacion = fechaCreacion;
        this.detallePQRS = detallePQRS;
        this.estado = estado;
        this.respAdmin = respAdmin;
        this.respPaciente = respPaciente;
    }

    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getMotivoAtencion() {
        return motivoAtencion;
    }

    public void setMotivoAtencion(String motivoAtencion) {
        this.motivoAtencion = motivoAtencion;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getDetallePQRS() {
        return detallePQRS;
    }

    public void setDetallePQRS(String detallePQRS) {
        this.detallePQRS = detallePQRS;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getRespAdmin() {
        return respAdmin;
    }

    public void setRespAdmin(String respAdmin) {
        this.respAdmin = respAdmin;
    }

    public String getRespPaciente() {
        return respPaciente;
    }

    public void setRespPaciente(String respPaciente) {
        this.respPaciente = respPaciente;
    }

   
    
}
