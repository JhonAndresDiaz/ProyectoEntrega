
package Controladores;

import Excepciones.CorreoRegistradoException;
import Excepciones.RegistradoException;
import Excepciones.IdentificacionNoExisteException;
import Excepciones.InformacionMedicoPacienteException;
import Excepciones.MismaInformacionMedicoException;
import Modelos.Consulta;
import Modelos.DiaCitaSeparada;
import Modelos.DiaDescanso;
import Modelos.Medico;
import Modelos.Paciente;
import Modelos.Persona;
import Singleton.PersonaSingleton;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 *
 * @author diazje
 */
public class ControladorRegistroMedicoAdmi {
    
    private ArrayList<Persona> listaPersonas;
    private ArrayList<String> listaEspecialidades;
    
    public ControladorRegistroMedicoAdmi(){
        this.listaPersonas = PersonaSingleton.getInstancia().getPersonas();
        this.listaEspecialidades = PersonaSingleton.getInstancia().getEspecialidades();
    }
    
    public ArrayList<String> getEspecialidades(){
        return listaEspecialidades;
    }
    
    public ArrayList<Medico> obtenerMedicos( ){
        
        ArrayList<Medico> listaMedicos = new ArrayList<>();
        listaPersonas = Singleton.PersonaSingleton.getInstancia().getPersonas();
        
        if(listaPersonas != null){
            for (int i = 0; i < listaPersonas.size(); i++) {
                if(listaPersonas.get(i).getRol().equals("Medico")){
                    Medico medico = (Medico)listaPersonas.get(i);
                    listaMedicos.add(medico);
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
    
        
    public Persona validarCorreo(String correo) {
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
    
    public boolean validarMismaInfoMedico(Medico persona) {
        
        Persona buscarInformacion = buscarInfo(persona.getIdentificacion());
        
        if(persona.getNombres().equals(buscarInformacion.getNombres()) && persona.getApellidos().equals(buscarInformacion.getApellidos())
            && persona.getEdad() == buscarInformacion.getEdad() && persona.getGenero().equals(buscarInformacion.getGenero()) 
            && persona.getNumTelefono().equals(buscarInformacion.getNumTelefono()) ) {
            return true;
        }
        return false;
    }
    
    public Persona buscarId(String identificacion) {
        for (int i = 0; i < listaPersonas.size(); i++) {
            if (listaPersonas.get(i).getIdentificacion().equals(identificacion)) {
                return listaPersonas.get(i);
            }
        }
        return null;
    }
    
    public void guardarMedico(Medico persona) {
        
        Paciente personaBuscada = (Paciente) buscarPacienteId(persona.getIdentificacion());
        Persona correoBuscado = validarCorreo(persona.getCorreo());
        Medico buscarIdMedico = (Medico) buscarMedicoIdentificacion(persona.getIdentificacion());
        
        if (personaBuscada != null || buscarIdMedico != null|| correoBuscado!= null) {
            if(personaBuscada != null) {
                throw new RegistradoException(); 
            }else if(correoBuscado != null) {
                throw new CorreoRegistradoException();
            }else if(buscarIdMedico != null) {
                if(buscarIdMedico.getIdentificacion().equals(persona.getIdentificacion())){
                    if(validarMismaInfoMedico(persona)) {
                        listaPersonas.add(persona);
                        Singleton.PersonaSingleton.getInstancia().escribirPersona(); 
                    }else {
                        throw new InformacionMedicoPacienteException();
                    }
                }
            }
        }else {
            listaPersonas.add(persona);
            Singleton.PersonaSingleton.getInstancia().escribirPersona();
        }
    }
    
    public void editarMedico(Medico medico){
        Medico medicoId = (Medico) buscarMedicoIdentificacion(medico.getIdentificacion());
        Persona correo = validarCorreo(medico.getCorreo());
        Persona pacienteId = buscarPacienteId(medico.getIdentificacion());
        
        if(medicoId != null) {
            if(correo == null || medico.getIdentificacion().equals(correo.getIdentificacion()) && correo.getRol().equals("Medico")){   
                medicoId.setNombres(medico.getNombres());
                medicoId.setApellidos(medico.getApellidos()); 
                medicoId.setEdad(medico.getEdad());
                medicoId.setNumTelefono(medico.getNumTelefono());
                medicoId.setGenero(medico.getGenero());
                medicoId.setHoraInicio(medico.getHoraInicio());
                medicoId.setHoraFinal(medico.getHoraFinal());
                medicoId.setCorreo(medico.getCorreo());
                medicoId.setContrasenia(medico.getContrasenia());
                Singleton.PersonaSingleton.getInstancia().escribirPersona();    
                if(pacienteId != null){
                    pacienteId.setNombres(medico.getNombres());
                    pacienteId.setApellidos(medico.getApellidos()); 
                    pacienteId.setEdad(medico.getEdad());
                    pacienteId.setNumTelefono(medico.getNumTelefono());
                    pacienteId.setGenero(medico.getGenero());
                    Singleton.PersonaSingleton.getInstancia().escribirPersona();
                }
            }else if(correo != null){
                throw new CorreoRegistradoException();      
            }
        }else if(medicoId == null){
            throw new IdentificacionNoExisteException();  
        }
    }
       
    public void eliminarMedico(String identificacion) {
        
        Persona aux = buscarMedicoIdentificacion(identificacion);
        
        if(aux != null) {
            for (int i = 0; i < listaPersonas.size(); i++) {
                if(listaPersonas.get(i).getIdentificacion().equals(identificacion) && listaPersonas.get(i).getCorreo().equals(aux.getCorreo())) {
                    listaPersonas.remove(i);
                    Singleton.PersonaSingleton.getInstancia().escribirPersona(); 
                }   
            }
        } else {
            throw new IdentificacionNoExisteException();           
        }
    }
     
    public String buscarEspecialidad (String especialidad) {
        for (int i = 0; i < listaEspecialidades.size(); i++) {
            if(listaEspecialidades.get(i) != null && listaEspecialidades.get(i).equals(especialidad)) {
                return listaEspecialidades.get(i);
            }  
        }
        return null;
    }
    
    public boolean guardarEspecialidad(String especialidad){
        
        String aux = buscarEspecialidad(especialidad);
        
        if(aux == null){
            for (int i = 0; i < listaEspecialidades.size(); i++) {
                if (listaEspecialidades.get(i).equals("Añadir Especialidad Nueva")){
                    listaEspecialidades.remove(i);
                    listaEspecialidades.add(especialidad);
                    listaEspecialidades.add("Añadir Especialidad Nueva");                  
                    Singleton.PersonaSingleton.getInstancia().escribirEspecialidades();
                    for (int j = 0; j < listaEspecialidades.size(); j++) {
                    System.out.println(listaEspecialidades.get(j));
                    }
                    return true;
                }                
            }
        }
        return false;
    }   
    
    public ArrayList<Consulta> obtenerConsultas(String identificacion) {
        
        Medico aux = (Medico) buscarMedicoIdentificacion(identificacion);
        
        if(aux != null){
            if(aux.getHistorialConsultas() != null){
                return aux.getHistorialConsultas();
            }
            return new ArrayList<>();
        }
        return new ArrayList<>();
    }
    
    public ArrayList<DiaDescanso> obtenerDiaLibre(String identificacion) {
        Medico aux = (Medico)buscarMedicoIdentificacion(identificacion);
        if(aux != null){
            if(aux.getDiaDeDescanso() != null){
                return aux.getDiaDeDescanso();
            }
            return new ArrayList<>();
        }
        return new ArrayList<>();
    }
    
    public ArrayList<DiaCitaSeparada> obtenerCitas(String identificacion) {
        
        Medico aux = (Medico) buscarMedicoIdentificacion(identificacion);
        
        if(aux != null){
            if(aux.getListaCitas() != null){
                return aux.getListaCitas();
            }
            return new ArrayList<>();
        }
        return new ArrayList<>();
    }
    
    public int gererarMedida(LocalTime horaInicio, LocalTime horaFin){
        
        int medida = 0;
        int horaInii = horaInicio.getHour();
        int minIni = horaInicio.getMinute();
        int horaFinn = horaFin.getHour();
        int minFinn = horaFin.getMinute();
        int resta = 0;
        int resta1 = 0;

        int  x = 0 ;
        
        if(horaFinn<horaInii){
            x = (horaFinn+24) - horaInii;   
        }else if (horaFinn > horaInii){
            x = horaFinn - horaInii;   
        }
        
        if(minIni == 30){
           resta = 1;  
        }else if (minIni == 0) {
            resta = 0;
        }
        
        if(minFinn == 30){
            resta1 = 1;
        }else if(minFinn == 0 ){
            resta1 = 0;
        }
        
        medida = (x*2)  - resta + resta1;
        return medida;   
        }
}
    
    
    

