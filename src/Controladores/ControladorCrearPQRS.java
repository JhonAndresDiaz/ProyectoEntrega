
package Controladores;

import Excepciones.PeticionCodigoExisteException;
import Excepciones.ConsultaCodigoYaExisteException;
import Modelos.Consulta;
import Modelos.Paciente;
import Modelos.Persona;
import Modelos.Peticion;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author diazje
 */
public class ControladorCrearPQRS {
    
    private ArrayList<Persona> listaPersonas;
    private ArrayList<Consulta> listaConsultas;
    private ArrayList<Peticion> listaPeticiones;
    
    public ControladorCrearPQRS()  {
        this.listaPersonas = Singleton.PersonaSingleton.getInstancia().getPersonas();
        this.listaConsultas = Singleton.PersonaSingleton.getInstancia().getConsultas();
        this.listaPeticiones = Singleton.PersonaSingleton.getInstancia().getPeticiones();
    }
    
    public ArrayList<Peticion> getPeticiones() {
        return Singleton.PersonaSingleton.getInstancia().getPeticiones();
    }
    
    public ArrayList<Consulta> conseguirConsultas(Paciente paciente){
        
        ArrayList<Consulta> lista = new ArrayList<>();
        for (int i = 0; i < listaConsultas.size(); i++) {
            if(listaConsultas.get(i).getPaciente().getIdentificacion().equals(paciente.getIdentificacion()) 
                    && listaConsultas.get(i).getEstado().equals("Atendida")){
                        Peticion peticion = buscarPeticionExistente(listaConsultas.get(i).getCodigo());
                        if(peticion == null) {
                        lista.add(listaConsultas.get(i));              
                        }   
            }
        }
        return lista;    
    }
    
    public Persona buscarPacienteIdentificacion(String identificacion){
        for (int i = 0; i < listaPersonas.size(); i++) {
            if(listaPersonas.get(i).getRol().equals("Paciente")){
                if(listaPersonas.get(i).getIdentificacion().equals(identificacion)){
                    return (Paciente)listaPersonas.get(i);
                }
            }
        }
        return null; 
    }
    
    public ArrayList<Peticion> obtenerPeticiones(String identificacion) {
        Paciente aux = (Paciente) buscarPacienteIdentificacion(identificacion);
        if(aux != null){
            if(aux.getHistorialDePeticiones()!= null){
                return aux.getHistorialDePeticiones();
            }
        }
        return new ArrayList<>();
    }
    
    public Consulta buscarCodigo(String codigo){
        for (int i = 0; i < listaConsultas.size(); i++) {
            if(listaConsultas.get(i).getCodigo().equals(codigo)){
                return  listaConsultas.get(i);
            }
        }
        return null;           
    }
    
    public Peticion buscarPeticionExistente(String codigo){
        for (int i = 0; i < listaPeticiones.size(); i++) {
            if(listaPeticiones.get(i).getCodigo().equals(codigo)) {
                return listaPeticiones.get(i);
            }
        }
        return null;
    }
    
    public void agendarPeticion(Peticion peticion) {
        
        Consulta codigoValidar = buscarCodigo(peticion.getConsulta().getCodigo());
        Peticion buscarPeticion = buscarPeticionExistente(peticion.getCodigo());
        
        if(codigoValidar == null || buscarPeticion != null) {
            if(codigoValidar == null) {
                throw new PeticionCodigoExisteException();
            }else if(buscarPeticion != null) {
                throw new ConsultaCodigoYaExisteException();
            }  
        }else {
            ArrayList <Peticion> peticionesPaciente = obtenerPeticiones(peticion.getConsulta().getPaciente().getIdentificacion());
            peticionesPaciente.add(peticion);
            Singleton.PersonaSingleton.getInstancia().escribirPersona(); 
            listaPeticiones.add(peticion);
            Singleton.PersonaSingleton.getInstancia().escribirPeticiones();
        }
    }
    
    public ArrayList<Peticion> validarMaximoPeticiones(Paciente paciente) {
        
        ArrayList<Peticion> contador = new ArrayList<> ();
        ArrayList<Peticion> listaPeticiones = paciente.getHistorialDePeticiones();
        
        for (int i = 0; i < listaPeticiones.size(); i++) {
            if(listaPeticiones.get(i).getEstado().equals("Activo") || listaPeticiones.get(i).getEstado().equals("En progreso")) {
                contador.add(listaPeticiones.get(i));
            }
        }
        return contador;
    }
        
}
