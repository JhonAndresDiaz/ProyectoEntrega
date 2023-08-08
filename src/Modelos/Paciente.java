
package Modelos;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author diazje
 */
public class Paciente extends Persona implements Serializable {
     
    private ArrayList<Consulta> historialDeConsultas;
    private ArrayList<Peticion> historialDePeticiones;
    private String nombreEps;

    public Paciente(ArrayList<Consulta> historialDeConsultas, ArrayList<Peticion> historialDePeticiones, String nombreEps, String identificacion, String nombres, String apellidos, int edad, String genero, String numTelefono, String correo, String contrasenia, String rol) {
        super(identificacion, nombres, apellidos, edad, genero, numTelefono, correo, contrasenia, rol);
        this.historialDeConsultas = historialDeConsultas;
        this.historialDePeticiones = historialDePeticiones;
        this.nombreEps = nombreEps;
    }

    public ArrayList<Consulta> getHistorialDeConsultas() {
        return historialDeConsultas;
    }

    public void setHistorialDeConsultas(ArrayList<Consulta> historialDeConsultas) {
        this.historialDeConsultas = historialDeConsultas;
    }

    public ArrayList<Peticion> getHistorialDePeticiones() {
        return historialDePeticiones;
    }

    public void setHistorialDePeticiones(ArrayList<Peticion> historialDePeticiones) {
        this.historialDePeticiones = historialDePeticiones;
    }

    public String getNombreEps() {
        return nombreEps;
    }

    public void setNombreEps(String nombreEps) {
        this.nombreEps = nombreEps;
    }
}
