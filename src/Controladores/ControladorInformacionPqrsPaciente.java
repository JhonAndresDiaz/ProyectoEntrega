
package Controladores;

import Excepciones.NoExistePeticionException;
import Excepciones.PeticionSinAtenderException;
import Excepciones.PeticionCerradaException;
import Modelos.Consulta;
import Modelos.Paciente;
import Modelos.Persona;
import Modelos.Peticion;
import java.util.ArrayList;

/**
 *
 * @author diazje
 */
public class ControladorInformacionPqrsPaciente {
    
    private ArrayList<Persona> listaPersonas;
    private ArrayList<Consulta> listaConsultas;
    private ArrayList<Peticion> listaPeticiones;
    
    public ControladorInformacionPqrsPaciente()  {
        this.listaPersonas = Singleton.PersonaSingleton.getInstancia().getPersonas();
        this.listaConsultas = Singleton.PersonaSingleton.getInstancia().getConsultas();
        this.listaPeticiones = Singleton.PersonaSingleton.getInstancia().getPeticiones();
    }
    
    public ArrayList<Peticion> conseguirPeticiones(Paciente paciente){
        
        ArrayList<Peticion> lista = new ArrayList<>();
        for (int i = 0; i < listaPeticiones.size(); i++) {
            if(listaPeticiones.get(i).getConsulta().getPaciente().getIdentificacion().equals(paciente.getIdentificacion())){               
                lista.add(listaPeticiones.get(i));               
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
    
    public Peticion buscarPeticion(String codigo){
        for (int i = 0; i < listaPeticiones.size(); i++) {
            if(listaPeticiones.get(i).getCodigo().equals(codigo)){
                return listaPeticiones.get(i);
            }
        }
        return null; 
    } 
    
    public void actualizarPeticion(Peticion peticion){
        Peticion aux = buscarPeticion(peticion.getCodigo());
        if(aux != null){
            aux.setRespPaciente(peticion.getRespPaciente());
            aux.setEstado(peticion.getEstado());
            Singleton.PersonaSingleton.getInstancia().escribirPeticiones();
            Singleton.PersonaSingleton.getInstancia().escribirPersona();
        }
    }
    
    public void actualizar(Peticion peticion) {
        Peticion aux = buscarPeticion(peticion.getCodigo());

        for (int i = 0; i < listaPeticiones.size(); i++) {
            if(aux == null || aux.getEstado().equals("Activo") || aux.getEstado().equals("Cerrado")) {
                if(aux == null) {
                    throw new NoExistePeticionException();
                }else if(aux.getEstado().equals("Activo")) {
                    throw new PeticionSinAtenderException();
                }else if(aux.getEstado().equals("Cerrado")) {
                    throw new PeticionCerradaException();
                }
            }else {
                aux.setRespAdmin(peticion.getRespAdmin());
                aux.setRespPaciente(peticion.getRespPaciente());
                aux.setEstado(peticion.getEstado());
                Singleton.PersonaSingleton.getInstancia().escribirPeticiones();
                Singleton.PersonaSingleton.getInstancia().escribirPersona();
            }
        } 
    }
    
}
