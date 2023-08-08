
package Controladores;

import Modelos.Consulta;
import Modelos.Medico;
import java.util.ArrayList;

/**
 *
 * @author diazje
 */
public class ControladorGestionarCitas {
    
    private ArrayList<Consulta> listaConsultas;

    public ControladorGestionarCitas() {
        this.listaConsultas = Singleton.PersonaSingleton.getInstancia().getConsultas();
    }
    
    public ArrayList<Consulta> conseguirConsultas(Medico medico){
        
        ArrayList<Consulta> lista = new ArrayList<>();
        for (int i = 0; i < listaConsultas.size(); i++) {
            if(listaConsultas.get(i).getMedico().getIdentificacion().equals(medico.getIdentificacion()) && listaConsultas.get(i).getEstado().equals("Agendada")){
                lista.add(listaConsultas.get(i));
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
    
    public void actulizarConsulta(Consulta consulta){
        Consulta aux = buscarConsulta(consulta.getCodigo());
        if( aux != null){
            aux.setDiagnostico(consulta.getDiagnostico());
            aux.setValoracion(consulta.getValoracion());
            aux.setNotas(consulta.getNotas());
            aux.setEstado(consulta.getEstado());
            Singleton.PersonaSingleton.getInstancia().escribirConsultas();
            Singleton.PersonaSingleton.getInstancia().escribirPersona();
        }
    }
}
