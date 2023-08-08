
package Controladores;

import Modelos.Consulta;
import Modelos.Medico;
import java.util.ArrayList;

/**
 *
 * @author diazje
 */
public class ControladorAtencionesRealizadasMedico {
    
    private ArrayList<Consulta> listaConsultas;
    
    public ControladorAtencionesRealizadasMedico()  {
        this.listaConsultas = Singleton.PersonaSingleton.getInstancia().getConsultas();
    }
       
    public ArrayList<Consulta> conseguirConsultas(Medico medico){
        
        ArrayList<Consulta> lista = new ArrayList<>();
        for (int i = 0; i < listaConsultas.size(); i++) {
            if(listaConsultas.get(i).getMedico().getIdentificacion().equals(medico.getIdentificacion()) 
                    && listaConsultas.get(i).getEstado().equals("Atendida")){
                lista.add(listaConsultas.get(i));
            }
        }
        return lista;    
    }
    
}
