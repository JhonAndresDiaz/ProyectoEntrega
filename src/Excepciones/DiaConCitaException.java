
package Excepciones;

/**
 *
 * @author diazje
 */
public class DiaConCitaException extends RuntimeException {
    
    public DiaConCitaException() {
        super("Este día cuenta con citas.\nSeleccione otro día");
    }
}
