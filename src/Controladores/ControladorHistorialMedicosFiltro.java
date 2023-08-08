
package Controladores;

import Modelos.Consulta;
import Modelos.ConsultaInfo;
import Modelos.ConsultaInfoPaciente;
import Modelos.Medico;
import Modelos.Paciente;
import Modelos.Persona;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author diazje
 */
public class ControladorHistorialMedicosFiltro {
    
    private ArrayList<Persona> listaPersonas;
    private ArrayList<Consulta> listaConsultas;
    private ArrayList<String> listaEspecialidades;
 
    public ControladorHistorialMedicosFiltro()  {
        this.listaPersonas = Singleton.PersonaSingleton.getInstancia().getPersonas();
        this.listaConsultas = Singleton.PersonaSingleton.getInstancia().getConsultas();
        this.listaEspecialidades = Singleton.PersonaSingleton.getInstancia().getEspecialidades();
    }
    
    public ArrayList<String> getEspecialidades(){
        return Singleton.PersonaSingleton.getInstancia().leerEspecialidades();
    }
       
    public ArrayList<Medico> obtenerMedicos(String especialidad){
        ArrayList<Medico> listaMedicos = new ArrayList<>();
        listaPersonas = Singleton.PersonaSingleton.getInstancia().getPersonas();
        
        if(listaPersonas != null){
            for (int i = 0; i < listaPersonas.size(); i++) {
                if(listaPersonas.get(i).getRol().equals("Medico") ){
                    Medico medico = (Medico)listaPersonas.get(i);
                    if( medico.getEspecializacion().equals(especialidad)){
                        listaMedicos.add(medico);
                    }
                }
            }
            return listaMedicos;  
        }
        return new ArrayList<>(); 
    }
    
    
    public Persona buscarMedicoIdentificacion(String identificacion){
        for (int i = 0; i < listaPersonas.size(); i++) {
            if(listaPersonas.get(i).getRol().equals("Medico")){
                if(listaPersonas.get(i).getIdentificacion().equals(identificacion)){
                    return (Medico)listaPersonas.get(i);
                }
            }
        }
        return null;      
    }  
        
    public ArrayList<Consulta> conseguirConsultas(Medico medico){
        
        ArrayList<Consulta> lista = new ArrayList<>();
        for (int i = 0; i < listaConsultas.size(); i++) {
            if(listaConsultas.get(i).getMedico().getIdentificacion().equals(medico.getIdentificacion()) 
                    && listaConsultas.get(i).getEstado().equals("Atendida")){
                lista.add(listaConsultas.get(i));
            }
        }
        return lista;    
    }
    
    public static ConsultaInfo obtenerMedicoMasConsultas(ArrayList<Consulta> consultas, LocalDate fechaInicio, LocalDate fechaFin) {

        Map<Medico, Integer> contadorConsultas = new HashMap<>();

        for (Consulta consulta : consultas) {
            LocalDate fechaConsulta = consulta.getFechaAtencion();
            if (fechaConsulta.isEqual(fechaInicio) || fechaConsulta.isEqual(fechaFin) || (fechaConsulta.isAfter(fechaInicio) && fechaConsulta.isBefore(fechaFin))) {
                Medico medico = consulta.getMedico();
                contadorConsultas.put(medico, contadorConsultas.getOrDefault(medico, 0) + 1);
            }
        }
        Medico medicoMasConsultas = null;
        int maxConsultas = 0;
        for (Map.Entry<Medico, Integer> entry : contadorConsultas.entrySet()) {
            Medico medico = entry.getKey();
            int consultasRealizadas = entry.getValue();

            if (consultasRealizadas > maxConsultas) {
                medicoMasConsultas = medico;
                maxConsultas = consultasRealizadas;
            }
        }
        if (medicoMasConsultas != null) {
            return new ConsultaInfo(medicoMasConsultas, maxConsultas);
        }
        return null;
    }
    
    public static List<ConsultaInfoPaciente> obtenerPacientesMasConsultas(ArrayList<Consulta> consultas, LocalDate fechaInicio, LocalDate fechaFin, int cantidadPacientes) {

        //CLAVE PACIENTE Y VALOR INTEGER(CLASE) int cantidadPacientes
        Map<Paciente, Integer> contadorConsultas = new HashMap<>();

        // Iterar sobre las consultas y contar las realizadas por cada paciente en el periodo indicado
        for(Consulta consulta : consultas) {
            LocalDate fechaConsulta = consulta.getFechaAtencion();
            if (fechaConsulta.isEqual(fechaInicio) || fechaConsulta.isEqual(fechaFin)
                    || (fechaConsulta.isAfter(fechaInicio) && fechaConsulta.isBefore(fechaFin))) {
                Paciente paciente = consulta.getPaciente();   //valor asignado de el objeto especifico
                contadorConsultas.put(paciente, contadorConsultas.getOrDefault(paciente, 0) + 1);
            }
        }

        // Ordenar los pacientes según la cantidad de consultas en orden descendente
        ArrayList<ConsultaInfoPaciente> pacientesInfo = new ArrayList<>();
        for (Map.Entry<Paciente, Integer> entry : contadorConsultas.entrySet()) {
            Paciente paciente = entry.getKey();
            int consultasRealizadas = entry.getValue();
            pacientesInfo.add(new ConsultaInfoPaciente(paciente, consultasRealizadas));
        }
        pacientesInfo.sort((p1, p2) -> p2.getCantidad()- p1.getCantidad());

        // Obtener los primeros "cantidadPacientes" pacientes con más consultas
        return pacientesInfo.subList(0, Math.min(cantidadPacientes, pacientesInfo.size()));
    }
}


    


    
    

