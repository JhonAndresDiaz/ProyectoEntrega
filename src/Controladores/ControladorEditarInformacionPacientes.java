
package Controladores;

import Excepciones.CorreoRegistradoException;
import Excepciones.IdentificacionNoExisteException;
import Excepciones.MismaInformacionEnfermeraException;
import Excepciones.MismaInformacionMedicoException;
import Modelos.Consulta;
import Modelos.Enfermera;
import Modelos.Medico;
import Modelos.Paciente;
import Modelos.Persona;
import Modelos.Peticion;
import Singleton.PersonaSingleton;
import java.util.ArrayList;

/**
 *
 * @author diazje
 */
public class ControladorEditarInformacionPacientes {
   
    private ArrayList<Persona> listaPersonas;
    
    public ControladorEditarInformacionPacientes(){
        this.listaPersonas = PersonaSingleton.getInstancia().getPersonas();
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
    
    public Persona buscarInfo(String identificacion){
        for (int i = 0; i < listaPersonas.size(); i++) {
                if(listaPersonas.get(i).getIdentificacion().equals(identificacion)){
                    return listaPersonas.get(i);
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
                Singleton.PersonaSingleton.getInstancia().escribirConsultas();
                if(medicoId != null || enfermeraId != null ){
                    if(medicoId != null) {
                        medicoId.setNombres(paciente.getNombres());
                        medicoId.setApellidos(paciente.getApellidos());
                        medicoId.setEdad(paciente.getEdad());
                        medicoId.setNumTelefono(paciente.getNumTelefono());
                        medicoId.setGenero(paciente.getGenero());
                        Singleton.PersonaSingleton.getInstancia().escribirPersona();
                        Singleton.PersonaSingleton.getInstancia().escribirConsultas();
                        throw new MismaInformacionMedicoException();
                    }else if(enfermeraId != null){
                        enfermeraId.setNombres(paciente.getNombres());
                        enfermeraId.setApellidos(paciente.getApellidos());
                        enfermeraId.setEdad(paciente.getEdad());
                        enfermeraId.setNumTelefono(paciente.getNumTelefono());
                        enfermeraId.setGenero(paciente.getGenero());
                        Singleton.PersonaSingleton.getInstancia().escribirPersona();
                        throw new MismaInformacionEnfermeraException();
                    } 
                }
            }else if(correo != null){
                throw new CorreoRegistradoException(); 
            }
        }else if(pacienteId == null ){
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
