
package Controladores;

import Excepciones.DiaConCitaException;
import Modelos.Consulta;
import Modelos.DiaCitaSeparada;
import Modelos.DiaDescanso;
import Modelos.Horario;
import Modelos.Medico;
import Modelos.Persona;
import Singleton.PersonaSingleton;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author diazje
 */
public class ControladorDiaDescanso {
    
    private ArrayList<Persona> listaPersonas;
    private ArrayList<Consulta> listaConsultas;

    public ControladorDiaDescanso(){
        this.listaPersonas = PersonaSingleton.getInstancia().getPersonas();
        this.listaConsultas = Singleton.PersonaSingleton.getInstancia().getConsultas();
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
    
    public ArrayList<DiaCitaSeparada> buscarCitas(String identificacion){
        Medico medico =(Medico)buscarMedicoIdentificacion(identificacion);
        if(medico.getListaCitas() != null){
            return medico.getListaCitas();
        }else{
            return new ArrayList<>();
        }     
    }
    
    public void guardarDiaLibre(LocalDate fecha , Medico medico){
        
        DiaDescanso diaLibre = new DiaDescanso("Activo", fecha);
        ArrayList<DiaDescanso> diasLibres = obtenerDiaLibre(medico);
        ArrayList<DiaCitaSeparada> dias = buscarCitas(medico.getIdentificacion());
        int medida = medico.getMedida();    
        ArrayList<Horario> horarios = new ArrayList<>();
        DiaCitaSeparada citaSeparada = new DiaCitaSeparada(horarios, fecha);
            
        if(dias.size() == 0){   
            System.out.println("111111111");  
            diasLibres.add(diaLibre);
            Singleton.PersonaSingleton.getInstancia().escribirPersona();
        }else if(dias.size() != 0){              
            boolean encontrado = false;
            int contarBloques = 0 ;
            for(int i = 0; i < dias.size(); i++) {            
                if(dias.get(i).getDia().isEqual(fecha)){
                    citaSeparada = dias.get(i);
                    encontrado = true;
                    for (int j = 0; j < citaSeparada.getHorarioCitas().size() ; j++) {
                        if(citaSeparada.getHorarioCitas().get(j).isEsDisponible() == true ){
                            System.out.println(citaSeparada.getHorarioCitas().get(j).isEsDisponible());
                            contarBloques ++;
                        } 
                    }    
                    if(contarBloques == medida){
                        System.out.println("2222222");
                        diasLibres.add(diaLibre);
                        Singleton.PersonaSingleton.getInstancia().getInstancia().escribirPersona(); 
                    } else{
                        throw new DiaConCitaException();
                    }
                }  
            }
            if(!encontrado){
                System.out.println("3333"); //Si no existe el dia lo crea y lo pone libre
                diasLibres.add(diaLibre);
                Singleton.PersonaSingleton.getInstancia().escribirPersona();               
            }    
        }    
    }
  
    public ArrayList<DiaDescanso> obtenerDiaLibre(Medico medico){
        ArrayList<DiaDescanso> diasLibre = new ArrayList<>();
        if ( medico.getDiaDeDescanso() !=null){
            diasLibre = medico.getDiaDeDescanso();
        }
        return diasLibre;
    }
    
    public void eliminar(Medico medico){
        ArrayList<DiaDescanso> libres = obtenerDiaLibre(medico);
        for (int i = 0; i < libres.size(); i++) {
            libres.remove(i);
            Singleton.PersonaSingleton.getInstancia().escribirPersona();    
        }
    }
}
