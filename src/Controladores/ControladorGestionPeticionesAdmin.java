
package Controladores;

import Excepciones.NoExistePeticionException;
import Excepciones.PeticionCerradaException;
import Modelos.Consulta;
import Modelos.Persona;
import Modelos.Peticion;
import java.util.ArrayList;

/**
 *
 * @author diazje
 */
public class ControladorGestionPeticionesAdmin {
    
    private ArrayList<Consulta> listaConsultas;
    private ArrayList<Peticion> listaPeticiones;
    
    public ControladorGestionPeticionesAdmin()  {
        this.listaConsultas = Singleton.PersonaSingleton.getInstancia().getConsultas();
        this.listaPeticiones = Singleton.PersonaSingleton.getInstancia().getPeticiones();
    }
    
    public ArrayList<Peticion> conseguirPeticiones(){
        
        ArrayList<Peticion> lista = new ArrayList<>();
        for (int i = 0; i < listaPeticiones.size(); i++) {
            if(listaPeticiones.get(i).getEstado().equals("Activo") || listaPeticiones.get(i).getEstado().equals("En progreso")){               
                lista.add(listaPeticiones.get(i));               
            }                          
        } 
        return lista;    
    }
    
    public ArrayList<Peticion> conseguirPeticionesTerminadas(){
        
        ArrayList<Peticion> lista = new ArrayList<>();
        for (int i = 0; i < listaPeticiones.size(); i++) {
            if(listaPeticiones.get(i).getEstado().equals("Cerrado")){               
                lista.add(listaPeticiones.get(i));               
            }                          
        } 
        return lista;    
    }
    
    public Peticion buscarPeticion(String codigo){
        for (int i = 0; i < listaPeticiones.size(); i++) {
            if(listaPeticiones.get(i).getCodigo().equals(codigo)){
                return listaPeticiones.get(i);
            }
        }
        return null; 
    }
    
    public Consulta buscarConsulta(String codigo){
        for (int i = 0; i < listaConsultas.size(); i++) {
            if(listaConsultas.get(i).getCodigo().equals(codigo)){
                return listaConsultas.get(i);
            }
        }
        return null; 
    }
    
    public void actulizarPeticion(Peticion peticion){
        
        Peticion aux = buscarPeticion(peticion.getCodigo());
        
        for (int i = 0; i < listaPeticiones.size(); i++) {
            if(aux == null || aux.getEstado().equals("Cerrado")) {
                if(aux == null){
                    throw new NoExistePeticionException();
                }else if(aux == null || aux.getEstado().equals("Cerrado")) {
                    throw new PeticionCerradaException();
                }
            }else {
                aux.setRespAdmin(peticion.getRespAdmin());
                aux.setEstado(peticion.getEstado());
                Singleton.PersonaSingleton.getInstancia().escribirPeticiones();
                Singleton.PersonaSingleton.getInstancia().escribirConsultas();
                Singleton.PersonaSingleton.getInstancia().escribirPersona();
            }
        }   
    }
    
    
}
