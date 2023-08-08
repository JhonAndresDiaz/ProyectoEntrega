
package Controladores;

import Excepciones.CorreoRegistradoException;
import Excepciones.IdentificacionNoExisteException;
import Excepciones.InformacionEnfermeraPacienteException;
import Excepciones.InformacionPacienteEnfermeraException;
import Excepciones.MismaInformacionEnfermeraException;
import Excepciones.RegistradoException;
import Modelos.Enfermera;
import Modelos.Paciente;
import Modelos.Persona;
import java.util.ArrayList;

/**
 *
 * @author diazje
 */
public class ControladorRegistroEnfermeraAdmi {
    
    private ArrayList<Persona> listaPersonas;
 
    public ControladorRegistroEnfermeraAdmi() {
        this.listaPersonas = Singleton.PersonaSingleton.getInstancia().getPersonas();
    }
    
    public ArrayList<Enfermera> obtenerEnfermeras(){
        
        ArrayList<Enfermera> listaMedicos = new ArrayList<>();
        listaPersonas = Singleton.PersonaSingleton.getInstancia().getPersonas();
        
        if(listaPersonas != null){
            for (int i = 0; i < listaPersonas.size(); i++) {
                if(listaPersonas.get(i).getRol().equals("Enfermera")){
                    Enfermera enfermera = (Enfermera)listaPersonas.get(i);
                    listaMedicos.add(enfermera);
                }
            }
            return listaMedicos;  
        }
        return new ArrayList<>(); 
    }
    
    public Persona buscarEnfermeraId(String identificacion){
        for (int i = 0; i < listaPersonas.size(); i++) {
            if(listaPersonas.get(i).getRol().equals("Enfermera")){
                if(listaPersonas.get(i).getIdentificacion().equals(identificacion)){
                    return (Enfermera)listaPersonas.get(i);
                }
            }
        }
        return null;  
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
    
    public Persona buscarInfo(String identificacion){
        for (int i = 0; i < listaPersonas.size(); i++) {
                if(listaPersonas.get(i).getIdentificacion().equals(identificacion)){
                    return listaPersonas.get(i);
                }
            }
        return null;    
    }
    
    public boolean validarMismaInfoPaciente(Enfermera persona) {
        
        Persona buscarInformacion = buscarInfo(persona.getIdentificacion());
        
        if(persona.getNombres().equals(buscarInformacion.getNombres()) && persona.getApellidos().equals(buscarInformacion.getApellidos())
            && persona.getEdad() == buscarInformacion.getEdad() && persona.getGenero().equals(buscarInformacion.getGenero()) 
            && persona.getNumTelefono().equals(buscarInformacion.getNumTelefono()) ) {
            return true;
        }
        return false;
    }
    
    public Persona buscarCorreo(String correo){
        for (int i = 0; i < listaPersonas.size(); i++) {
            if(listaPersonas.get(i).getCorreo().equals(correo)){
                return listaPersonas.get(i);
            }
        }
        return null;
    }
    
    public Persona buscarId(String identificacion) {
        for (int i = 0; i < listaPersonas.size(); i++) {
            if (listaPersonas.get(i).getIdentificacion().equals(identificacion)) {
                return listaPersonas.get(i);
            }
        }
        return null;
    }
    
    public void guardarEnfermera(Enfermera persona) {
        
        Paciente personaBuscada =  (Paciente) buscarPacienteId(persona.getIdentificacion());
        Persona correoBuscado = buscarCorreo(persona.getCorreo());
        Enfermera buscarIdEnfermera = (Enfermera) buscarEnfermeraId(persona.getIdentificacion());
        
        if (personaBuscada != null || buscarIdEnfermera != null|| correoBuscado!= null) {
            if(personaBuscada != null) {
                throw new RegistradoException(); 
            }else if(correoBuscado != null) {
                throw new CorreoRegistradoException();
            }else if(buscarIdEnfermera != null) {
                if(buscarIdEnfermera.getIdentificacion().equals(persona.getIdentificacion())){
                    if(validarMismaInfoPaciente(persona)) {
                            listaPersonas.add(persona);
                            Singleton.PersonaSingleton.getInstancia().escribirPersona(); 
                    }else {
                        throw new InformacionEnfermeraPacienteException();
                    }
                }
            }
        }else {
            listaPersonas.add(persona);
            Singleton.PersonaSingleton.getInstancia().escribirPersona();
        }
    }
    
    public void editarEnfermera(Enfermera enfermera){
        Persona enfermeraId = buscarEnfermeraId(enfermera.getIdentificacion());
        Persona correo = buscarCorreo(enfermera.getCorreo());
        Persona pacienteId = buscarPacienteId(enfermera.getIdentificacion());
        
        if (enfermeraId != null  ) {
            if(correo == null || enfermera.getIdentificacion().equals(correo.getIdentificacion()) && correo.getRol().equals("Enfermero")){
                enfermeraId.setNombres(enfermera.getNombres());
                enfermeraId.setApellidos(enfermera.getApellidos());
                enfermeraId.setEdad(enfermera.getEdad());
                enfermeraId.setNumTelefono(enfermera.getNumTelefono());
                enfermeraId.setGenero(enfermera.getGenero());
                enfermeraId.setCorreo(enfermera.getCorreo());
                enfermeraId.setContrasenia(enfermera.getContrasenia());
                Singleton.PersonaSingleton.getInstancia().escribirPersona();                
                if(pacienteId != null){
                    pacienteId.setNombres(enfermera.getNombres());
                    pacienteId.setApellidos(enfermera.getApellidos()); 
                    pacienteId.setEdad(enfermera.getEdad());
                    pacienteId.setNumTelefono(enfermera.getNumTelefono());
                    pacienteId.setGenero(enfermera.getGenero());
                    Singleton.PersonaSingleton.getInstancia().escribirPersona();
                }       
            }else if(correo != null){
                throw new CorreoRegistradoException();            
            }
        }else if(enfermeraId == null ){
            throw new IdentificacionNoExisteException();           
        }      
    }
 
    public void eliminarEnfermera(String identificacion){
        
        Persona aux = buscarEnfermeraId(identificacion);
        
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
}
