
package Excepciones;

/**
 *
 * @author diazje
 */
public class CitaRegistradaException extends RuntimeException {
    public CitaRegistradaException() {
    super("La cita ha sido registrada correctamente");
    }  
}
