
package Controladores;

import Excepciones.DiaDescansoException;
import Modelos.Consulta;
import Modelos.DiaCitaSeparada;
import Modelos.DiaDescanso;
import Modelos.Horario;
import Modelos.Medico;
import Modelos.Paciente;
import Modelos.Persona;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Random;


/**
 *
 * @author diazje
 */
public class ControladorAgendarCitaPacientes {
    
    private ArrayList<Persona> listaPersonas;
    private ArrayList<Consulta> listaConsultas;
    private ArrayList<String> listaEspecialidades;

    public ControladorAgendarCitaPacientes()  {
        this.listaPersonas = Singleton.PersonaSingleton.getInstancia().getPersonas();
        this.listaEspecialidades = Singleton.PersonaSingleton.getInstancia().getEspecialidades();
        this.listaConsultas = Singleton.PersonaSingleton.getInstancia().getConsultas();
    }
    
    public ArrayList<String> getEspecialidades(){
        return Singleton.PersonaSingleton.getInstancia().leerEspecialidades();
    }
    
    public ArrayList<Consulta> getConsultas() {
        return Singleton.PersonaSingleton.getInstancia().leerConsultas();
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

    public ArrayList<DiaCitaSeparada> buscarCitas(String identificacion){
        Medico medico =(Medico)buscarMedicoIdentificacion(identificacion);
        if(medico.getListaCitas() != null){
            return medico.getListaCitas();
        }else{
            return new ArrayList<>();
        }     
    }
    
    public ArrayList<Consulta> validarMaximoCitas(Paciente paciente) {
        
        ArrayList<Consulta> contador = new ArrayList<> ();
        ArrayList<Consulta> listaConsultas = paciente.getHistorialDeConsultas();
        
        for (int i = 0; i < listaConsultas.size(); i++) {
            if(listaConsultas.get(i).getEstado().equals("Agendada")) {
                contador.add(listaConsultas.get(i));
            }
        }
        return contador;
    }
       
    public Consulta buscarConsulta(String codigo){
        for (int i = 0; i < listaConsultas.size(); i++) {
            if(listaConsultas.get(i).getCodigo().equals(codigo)){
                return listaConsultas.get(i);
            }
        }
        return null;
        
    }
    
    public DiaCitaSeparada ObtenerCitasDia(LocalDate dia, String identificacion){
        
        ArrayList<Horario> horarioCitas = new ArrayList<>();
        ArrayList<DiaCitaSeparada> buscarCitas = buscarCitas(identificacion);
        Medico medico =(Medico)buscarMedicoIdentificacion(identificacion);
        int medida = medico.getMedida();
        ArrayList<DiaDescanso> diaLibre = medico.getDiaDeDescanso();
        LocalTime horaInicio = medico.getHoraInicio();
        DiaCitaSeparada diaDeCita = new DiaCitaSeparada(horarioCitas, dia);
        LocalTime horaFin = medico.getHoraFinal();
        
        for (int i = 0; i < diaLibre.size(); i++) {
            if(diaLibre.get(i).getDiaSeleccionado().isEqual(dia) && diaLibre.get(i).getEstadoDia().equals("Activo")){
                throw new  DiaDescansoException(dia); 
            }
        }  
        if(buscarCitas.size() == 0){
            LocalTime hora = horaInicio;
            int horaInicioHora = horaInicio.getHour();
            int horaInicioMinuto = horaInicio.getMinute();
            int horaFinHora = horaFin.getHour();
            for (int i = 0; i < medida; i++) {
                Horario horarios = new Horario(null, hora, true);
                horarioCitas.add(horarios );
                if(horaInicioMinuto == 30){
                    horaInicioHora++ ;
                    horaInicioMinuto = 0;
                    if(horaInicioHora == 24){
                        horaInicioHora = 0; 
                    }
                    if(horaInicioHora == horaFinHora){
                        break;
                    } 
                }else if (horaInicioMinuto == 0){
                    horaInicioMinuto = horaInicioMinuto + 30;
                }
                hora = LocalTime.of(horaInicioHora, horaInicioMinuto);                      
            }
            buscarCitas.add(diaDeCita);
            Singleton.PersonaSingleton.getInstancia().escribirPersona();
        }else if(buscarCitas.size() != 0){  
            boolean diaEncontrado = false;
            for (int i = 0; i < buscarCitas.size(); i++) {            
                if(buscarCitas.get(i).getDia().isEqual(dia)){
                    diaDeCita = buscarCitas.get(i);
                    diaEncontrado = true;
                }
            }                      
            if(!diaEncontrado){
                LocalTime hora = horaInicio;
                int horaInicioHora = horaInicio.getHour();
                int horaInicioMinuto = horaInicio.getMinute();
                int horaFinHora = horaFin.getHour();
                for (int j = 0; j < medida; j++) {
                    Horario horarios = new Horario(null, hora, true);
                    horarioCitas.add(horarios);
                    if(horaInicioMinuto == 30){
                    horaInicioHora++ ;
                    horaInicioMinuto = 0;
                    if(horaInicioHora == 24){
                        horaInicioHora = 0; 
                    }
                    if(horaInicioHora == horaFinHora){
                        break;
                    } 
                }else if (horaInicioMinuto == 0){
                    horaInicioMinuto = horaInicioMinuto + 30;
                }
                    hora = LocalTime.of(horaInicioHora, horaInicioMinuto);                      
                }
                buscarCitas.add(diaDeCita);
                Singleton.PersonaSingleton.getInstancia().escribirPersona(); 
            }
        }
        return diaDeCita;
    }
    
    public ArrayList<Consulta> obtenerConsultas(String identificacion) {
        Paciente aux = (Paciente) buscarPacienteIdentificacion(identificacion);
        if(aux != null){
            if(aux.getHistorialDeConsultas()!= null){
                return aux.getHistorialDeConsultas();
            }
        }
        return new ArrayList<>();
    }
    
    public ArrayList<Consulta> obtenerConsultasMedico(Medico medico) {
         ArrayList<Consulta> listaConsultasMedico = medico.getHistorialConsultas();
         if(listaConsultasMedico == null){
             return new ArrayList<>();
             
         }
         return listaConsultasMedico;
    }
    
    public void agendarCita(Consulta consulta, Paciente paciente, Medico medico, LocalTime  hora){
            
        ArrayList<DiaCitaSeparada> citasSeparadas = medico.getListaCitas();
        LocalDate fecha = consulta.getFechaAtencion();
        
        for (int i = 0; i < citasSeparadas.size()  ; i++) {
            if(citasSeparadas.get(i).getDia().isEqual(fecha)){
                for (int j = 0; j < citasSeparadas.get(i).getHorarioCitas().size(); j++) {
                    if( citasSeparadas.get(i).getHorarioCitas().get(j).getHora().equals(hora)) {
                        Horario horario = new Horario(paciente, hora, false);
                        citasSeparadas.get(i).getHorarioCitas().set(j, horario);
                        Singleton.PersonaSingleton.getInstancia().escribirPersona();
                    }
                }
            }  
        }
        ArrayList <Consulta> consultasPaciente = obtenerConsultas(paciente.getIdentificacion());
        consultasPaciente.add(consulta);
        ArrayList<Consulta> consultasMedico = obtenerConsultasMedico(medico);
        consultasMedico.add(consulta);
        Singleton.PersonaSingleton.getInstancia().escribirPersona(); 
        listaConsultas.add( consulta) ;
        Singleton.PersonaSingleton.getInstancia().escribirConsultas();  
    }
    
    public String generarCodigo(){
        String banco = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        Random z = new Random();
        String codigo = "";

        for (int i = 0; i < 5; i++) {
            int posicion = z.nextInt(banco.length());
            char caracter = banco.charAt(posicion);
            codigo += caracter;
        } 
        Consulta aux = buscarConsulta(codigo);     
        if(aux != null){
            for (int i = 0; i < 5; i++) {
                int posicion = z.nextInt(banco.length());
                char caracter = banco.charAt(posicion);
                codigo += caracter;
            }
        }else{
            codigo = codigo;
        }
        return  codigo;
    } 
}
   
    

