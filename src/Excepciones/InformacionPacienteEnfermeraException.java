
package Excepciones;

/**
 *
 * @author diazje
 */
public class InformacionPacienteEnfermeraException extends RuntimeException {
    
    public InformacionPacienteEnfermeraException() {
        super("Ingrese la misma información que registro como enfermer@ anteriormente");
    } 
}
