
package Controladores;

import Modelos.Consulta;
import Modelos.Medico;
import Modelos.Paciente;
import Modelos.Persona;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author diazje
 */
public class ControladorHistorialPaciente {
    
    private ArrayList<Persona> listaPersonas;
    private ArrayList<Consulta> listaConsultas;
    
    public ControladorHistorialPaciente()  {
        this.listaPersonas = Singleton.PersonaSingleton.getInstancia().getPersonas();
        this.listaConsultas = Singleton.PersonaSingleton.getInstancia().getConsultas();
    }
    
    
    public ArrayList<Consulta> conseguirConsultasTodas(Paciente paciente){
        
        ArrayList<Consulta> lista = new ArrayList<>();
        for (int i = 0; i < listaConsultas.size(); i++) {
            if(listaConsultas.get(i).getPaciente().getIdentificacion().equals(paciente.getIdentificacion()) 
                    && listaConsultas.get(i).getEstado().equals("Atendida")){          
                    lista.add(listaConsultas.get(i));   
            }
        }
        return lista;    
    }
    
   public ArrayList<Consulta> conseguirConsultasFecha(Paciente paciente, LocalDate datoFecha){
        
        ArrayList<Consulta> lista = new ArrayList<>();
        for (int i = 0; i < listaConsultas.size(); i++) {
            if(listaConsultas.get(i).getPaciente().getIdentificacion().equals(paciente.getIdentificacion()) 
                    && listaConsultas.get(i).getEstado().equals("Atendida")){
                if(listaConsultas.get(i).getFechaAtencion().equals(datoFecha)) {
                    lista.add(listaConsultas.get(i));
                }
            }
        }
        return lista;    
    }
   
   public ArrayList<Consulta> conseguirConsultasMedicoN(String nombre, Paciente paciente){
        
        ArrayList<Consulta> lista = new ArrayList<>();
        for (int i = 0; i < listaConsultas.size(); i++) {
            if(listaConsultas.get(i).getPaciente().getIdentificacion().equals(paciente.getIdentificacion()) 
                    && listaConsultas.get(i).getEstado().equals("Atendida")){
                if(listaConsultas.get(i).getMedico().getNombres().equals(nombre)) {
                    lista.add(listaConsultas.get(i));
                }
            }
        }
        return lista;    
    }
   
    public Consulta buscarConsulta(String codigo){
        for (int i = 0; i < listaConsultas.size(); i++) {
            if(listaConsultas.get(i).getCodigo().equals(codigo)){
                return listaConsultas.get(i);
            }
        }
        return null; 
    }
    
    public Consulta buscarConsultaFecha(LocalDate fecha){
        for (int i = 0; i < listaConsultas.size(); i++) {
            if(listaConsultas.get(i).getFechaAtencion().equals(fecha)){
                return listaConsultas.get(i);
            }
        }
        return null; 
    }
    
    public Consulta buscarConsultaMedico(String nombre){
        for (int i = 0; i < listaConsultas.size(); i++) {
            if(listaConsultas.get(i).getMedico().getNombres().equals(nombre)){
                return listaConsultas.get(i);
            }
        }
        return null; 
    }
    
}
