
package Controladores;

import Modelos.Consulta;
import Modelos.Paciente;
import Modelos.Persona;
import java.util.ArrayList;

/**
 *
 * @author diazje
 */
public class ControladorHistorialMedicoPaciente {
    
    private ArrayList<Persona> listaPersonas;
    private ArrayList<Consulta> listaConsultas;
    
    public ControladorHistorialMedicoPaciente()  {
        this.listaPersonas = Singleton.PersonaSingleton.getInstancia().getPersonas();
        this.listaConsultas = Singleton.PersonaSingleton.getInstancia().getConsultas();
    }
    
    
    
   public ArrayList<Consulta> conseguirConsultas(Paciente paciente){
        
        ArrayList<Consulta> lista = new ArrayList<>();
        for (int i = 0; i < listaConsultas.size(); i++) {
            if(listaConsultas.get(i).getPaciente().getIdentificacion().equals(paciente.getIdentificacion()) 
                    && listaConsultas.get(i).getEstado().equals("Atendida")){
                lista.add(listaConsultas.get(i));
            }
        }
        return lista;    
    }
}
