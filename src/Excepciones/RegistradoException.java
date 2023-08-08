
package Excepciones;

/**
 *
 * @author diazje
 */
public class RegistradoException extends RuntimeException {
    
    public RegistradoException() {
        super("Ya existe en el sistema el número de identificación");
    }   
}
