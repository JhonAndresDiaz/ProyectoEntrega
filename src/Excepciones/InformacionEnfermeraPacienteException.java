
package Excepciones;

/**
 *
 * @author diazje
 */
public class InformacionEnfermeraPacienteException extends RuntimeException {
    
    public InformacionEnfermeraPacienteException() {
        super("Ingrese la misma información que registro como paciente anteriormente");
    }
}
