
package Excepciones;

/**
 *
 * @author diazje
 */
public class InformacionMedicoPacienteException extends RuntimeException {
    
    public InformacionMedicoPacienteException() {
        super("Ingrese la misma información que registro como paciente anteriormente");
    }
}
