
package Excepciones;

/**
 *
 * @author diazje
 */
public class PeticionCodigoExisteException extends RuntimeException {
    
    public PeticionCodigoExisteException() {
        super("El codigo de consulta que desea crear petición ya fue registrado");
    } 
}
