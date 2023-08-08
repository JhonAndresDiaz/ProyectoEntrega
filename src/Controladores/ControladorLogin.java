 
package Controladores;

import Modelos.Persona;
import Singleton.PersonaSingleton;
import java.util.ArrayList;

/**
 *
 * @author diazje
 */
public class ControladorLogin {
    
    private ArrayList<Persona> listaPersonas;
    
    public ControladorLogin(){
        this.listaPersonas = PersonaSingleton.getInstancia().getPersonas();
    }
    
    public ArrayList<Persona> obtenerPersonas(){
        return PersonaSingleton.getInstancia().leerPersona();
    }
    
    public Persona BuscarPersonaCorreo(String correo){
        for (int i = 0; i < listaPersonas.size(); i++) {
            if(listaPersonas.get(i).getCorreo().equals(correo)){
                return listaPersonas.get(i);
            }
        }
        return null;  
    }
    
    public Persona  crearAdministrador (){
        Persona persona = new Persona("52535115","Jhon" , "Cano", 18, "Masculino", "313", "Admin", "123", "Administrador"); 
        return persona;
    }   
}
