
package Controladores;

import Excepciones.CorreoRegistradoException;
import Excepciones.RegistradoException;
import Excepciones.IdentificacionNoExisteException;
import Excepciones.InformacionPacienteMedicoException;
import Excepciones.InformacionPacienteEnfermeraException;
import Excepciones.MismaInformacionMedicoException;
import Excepciones.MismaInformacionEnfermeraException;
import Modelos.Consulta;
import Modelos.Enfermera;
import Modelos.Medico;
import Modelos.Paciente;
import Modelos.Persona;
import Modelos.Peticion;
import Singleton.PersonaSingleton;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author diazje
 */
public class ControladorRegistroPacienteAdmi {
    
private ArrayList<Persona> listaPersonas;
    
    public ControladorRegistroPacienteAdmi(){
        this.listaPersonas = PersonaSingleton.getInstancia().getPersonas();
    }
    
    public ArrayList<Paciente> obtenerPacientes(){
        ArrayList<Paciente> listaPacientes = new ArrayList<>();
        listaPersonas = Singleton.PersonaSingleton.getInstancia().getPersonas();
        if(listaPersonas != null){         
            for (int i = 0; i < listaPersonas.size(); i++) {
                if(listaPersonas.get(i).getRol().equals("Paciente")){
                    Paciente paciente = (Paciente)listaPersonas.get(i);
                    listaPacientes.add(paciente);
                }
            }
            return listaPacientes;  
        }
        return new ArrayList<>();
    }
    
    public Persona buscarPacienteId(String identificacion){
        for (int i = 0; i < listaPersonas.size(); i++) {
            if(listaPersonas.get(i).getRol().equals("Paciente") ){
                if(listaPersonas.get(i).getIdentificacion().equals(identificacion)){
                    return (Paciente)listaPersonas.get(i);
                }
            }
        }
        return null;    
    }
       
    public Persona buscarCorreo(String correo) {
        for (int i = 0; i < listaPersonas.size(); i++) {
            if (listaPersonas.get(i).getCorreo().equals(correo)) {
                    return listaPersonas.get(i);              
            }
        }
        return null;
    }
    
    public Persona buscarInfo(String identificacion){
        for (int i = 0; i < listaPersonas.size(); i++) {
                if(listaPersonas.get(i).getIdentificacion().equals(identificacion)){
                    return listaPersonas.get(i);
                }
            }
        return null;    
    }
     
    public Persona buscarMedicoId(String identificacion){
        for (int i = 0; i < listaPersonas.size(); i++) {
            if(listaPersonas.get(i).getRol().equals("Medico") ){
                if(listaPersonas.get(i).getIdentificacion().equals(identificacion)){
                    return (Medico)listaPersonas.get(i);
                }
            }
        }
        return null;    
    }

    public Persona buscarEnfermeraId(String identificacion){
        for (int i = 0; i < listaPersonas.size(); i++) {
            if(listaPersonas.get(i).getRol().equals("Enfermera") ){
                if(listaPersonas.get(i).getIdentificacion().equals(identificacion)){
                    return (Enfermera)listaPersonas.get(i);
                }
            }
        }
        return null;    
    }
    
    public boolean validarMismaInfoPaciente(Paciente persona) {
        
        Persona buscarInformacion = buscarInfo(persona.getIdentificacion());
        
        if(persona.getNombres().equals(buscarInformacion.getNombres()) && persona.getApellidos().equals(buscarInformacion.getApellidos())
            && persona.getEdad() == buscarInformacion.getEdad() && persona.getGenero().equals(buscarInformacion.getGenero()) 
            && persona.getNumTelefono().equals(buscarInformacion.getNumTelefono()) ) {
            return true;
        }
        return false;
    }
     
    public void guardarPaciente(Paciente persona) {
        
        Paciente personaBuscada = (Paciente) buscarPacienteId(persona.getIdentificacion());
        Persona correoBuscado = buscarCorreo(persona.getCorreo());
        Medico buscarIdMedico = (Medico) buscarMedicoId(persona.getIdentificacion());
        Enfermera buscarIdEnfermera = (Enfermera) buscarEnfermeraId(persona.getIdentificacion());
        
        if (personaBuscada != null || buscarIdMedico != null|| buscarIdEnfermera != null || correoBuscado!= null) {
            if(personaBuscada != null) {
                throw new RegistradoException(); 
            }else if(correoBuscado != null) {
                throw new CorreoRegistradoException();
            }else if(buscarIdMedico != null) {
                if(buscarIdMedico.getIdentificacion().equals(persona.getIdentificacion())){
                    if(validarMismaInfoPaciente(persona)) {
                            listaPersonas.add(persona);
                            Singleton.PersonaSingleton.getInstancia().escribirPersona(); 
                    }else {
                        throw new InformacionPacienteMedicoException();
                    }
                }
            }else if(buscarIdEnfermera != null) {
                if(buscarIdEnfermera.getIdentificacion().equals(persona.getIdentificacion())){
                    if(validarMismaInfoPaciente(persona)) {
                            listaPersonas.add(persona);
                            Singleton.PersonaSingleton.getInstancia().escribirPersona(); 
                    }else {
                        throw new InformacionPacienteEnfermeraException();
                    }
                }
            }
        }else {
            listaPersonas.add(persona);
            Singleton.PersonaSingleton.getInstancia().escribirPersona();
        }
    }
    
    public void editarPaciente(Paciente paciente){
        Persona pacienteId = buscarPacienteId(paciente.getIdentificacion());
        Persona correo = buscarCorreo(paciente.getCorreo());
        Persona medicoId = buscarMedicoId(paciente.getIdentificacion());
        Persona enfermeraId = buscarEnfermeraId(paciente.getIdentificacion());
        
        if(pacienteId != null) {
            if(correo == null || paciente.getIdentificacion().equals(correo.getIdentificacion()) && correo.getRol().equals("Paciente")){
                pacienteId.setNombres(paciente.getNombres());
                pacienteId.setApellidos(paciente.getApellidos());
                pacienteId.setEdad(paciente.getEdad());
                pacienteId.setNumTelefono(paciente.getNumTelefono());
                pacienteId.setGenero(paciente.getGenero());
                pacienteId.setCorreo(paciente.getCorreo());
                pacienteId.setContrasenia(paciente.getContrasenia());
                Singleton.PersonaSingleton.getInstancia().escribirPersona();
                if(medicoId != null || enfermeraId != null){
                    if(medicoId != null) {
                        medicoId.setNombres(paciente.getNombres());
                        medicoId.setApellidos(paciente.getApellidos());
                        medicoId.setEdad(paciente.getEdad());
                        medicoId.setNumTelefono(paciente.getNumTelefono());
                        medicoId.setGenero(paciente.getGenero());
                        Singleton.PersonaSingleton.getInstancia().escribirPersona();
                    }else if(enfermeraId != null){
                        enfermeraId.setNombres(paciente.getNombres());
                        enfermeraId.setApellidos(paciente.getApellidos());
                        enfermeraId.setEdad(paciente.getEdad());
                        enfermeraId.setNumTelefono(paciente.getNumTelefono());
                        enfermeraId.setGenero(paciente.getGenero());
                        Singleton.PersonaSingleton.getInstancia().escribirPersona();
                    } 
                }
            }else if(correo != null){
                throw new CorreoRegistradoException(); 
            }
        }else if(pacienteId == null ){
            throw new IdentificacionNoExisteException();
        }
    }
    
    public void eliminarPaciente(String identificacion){
        
        Persona aux = buscarPacienteId(identificacion);
    	
        if (aux != null) {
            for (int i = 0; i < listaPersonas.size(); i++) {
                if(listaPersonas.get(i).getIdentificacion().equals(aux.getIdentificacion()) && listaPersonas.get(i).getCorreo().equals(aux.getCorreo())){
                    listaPersonas.remove(i);
                    Singleton.PersonaSingleton.getInstancia().escribirPersona();                   
                } 
            }
        }else {
            throw new IdentificacionNoExisteException();
        }      
    }
 
    public ArrayList<Consulta> obtenerConsultas(String identificacion) {
        Paciente aux = (Paciente)buscarPacienteId(identificacion);
        if( aux != null){
            if(aux.getHistorialDeConsultas() != null){
                return aux.getHistorialDeConsultas();
            }
            
        }
        return new ArrayList<>();
    }
    
    public ArrayList<Peticion> obtenerPeticiones(String identificacion) {
        Paciente aux = (Paciente)buscarPacienteId(identificacion);
        if( aux != null){
            if(aux.getHistorialDePeticiones() != null){
                return aux.getHistorialDePeticiones();
            }
            
        }
        return new ArrayList<>();
    }  
}
