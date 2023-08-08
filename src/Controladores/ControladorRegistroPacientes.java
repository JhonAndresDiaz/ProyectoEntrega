
package Controladores;

import Excepciones.CorreoRegistradoException;
import Excepciones.InformacionPacienteEnfermeraException;
import Excepciones.InformacionPacienteMedicoException;
import Excepciones.RegistradoException;
import Modelos.Enfermera;
import Modelos.Medico;
import Modelos.Paciente;
import Modelos.Persona;
import Singleton.PersonaSingleton;
import java.util.ArrayList;

/**
 *
 * @author diazje
 */
public class ControladorRegistroPacientes {
    
    private ArrayList<Persona> listaPersonas;
    
    public ControladorRegistroPacientes(){
        this.listaPersonas = PersonaSingleton.getInstancia().getPersonas();
    }
    
    public ArrayList<Persona> obtenerPacientes(){
        return PersonaSingleton.getInstancia().leerPersona();
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
       
    public Persona validarCorreo(String correo) {
        for (int i = 0; i < listaPersonas.size(); i++) {
            if (listaPersonas.get(i).getCorreo().equals(correo)) {
                return listaPersonas.get(i);
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
    
    public void guardarPaciente(Paciente persona) {
        
        Paciente personaBuscada = (Paciente) buscarPacienteId(persona.getIdentificacion());
        Persona correoBuscado = validarCorreo(persona.getCorreo());
        Medico buscarIdMedico = (Medico) buscarMedicoId(persona.getIdentificacion());
        Enfermera buscarIdEnfermera = (Enfermera) buscarEnfermeraId(persona.getIdentificacion());
        
        if (personaBuscada != null || buscarIdMedico != null|| buscarIdEnfermera != null || correoBuscado!= null) {
            if(personaBuscada != null) {
                throw new RegistradoException(); 
            }else if(correoBuscado != null) {
                throw new CorreoRegistradoException();
            }else if(buscarIdMedico != null) {
                if(buscarIdMedico.getIdentificacion().equals(persona.getIdentificacion())){
                    if(validarMismaInfoPaciente(persona) ) {
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
}
