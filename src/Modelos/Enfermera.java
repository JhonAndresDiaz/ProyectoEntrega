
package Modelos;

import java.io.Serializable;

/**
 *
 * @author diazje
 */
public class Enfermera extends Persona implements Serializable {
    
    private String tarjetaProfesional;
    private int aniosExperiencia;

    public Enfermera(String tarjetaProfesional, int aniosExperiencia, String identificacion, String nombres, String apellidos, int edad, String genero, String numTelefono, String correo, String contrasenia, String rol) {
        super(identificacion, nombres, apellidos, edad, genero, numTelefono, correo, contrasenia, rol);
        this.tarjetaProfesional = tarjetaProfesional;
        this.aniosExperiencia = aniosExperiencia;
    }

    public String getTarjetaProfesional() {
        return tarjetaProfesional;
    }

    public void setTarjetaProfesional(String tarjetaProfesional) {
        this.tarjetaProfesional = tarjetaProfesional;
    }

    public int getAniosExperiencia() {
        return aniosExperiencia;
    }

    public void setAniosExperiencia(int aniosExperiencia) {
        this.aniosExperiencia = aniosExperiencia;
    }  
}
