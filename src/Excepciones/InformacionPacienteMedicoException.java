
package Excepciones;

/**
 *
 * @author diazje
 */
public class InformacionPacienteMedicoException extends RuntimeException {
    
    public InformacionPacienteMedicoException() {
        super("Ingrese la misma información que registro como médico anteriormente");
    }  
}
