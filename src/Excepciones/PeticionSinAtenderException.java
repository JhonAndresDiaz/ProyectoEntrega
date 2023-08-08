
package Excepciones;

/**
 *
 * @author diazje
 */
public class PeticionSinAtenderException extends RuntimeException {
    
    public PeticionSinAtenderException() {
    super("Error, el administrador aun no ha atendido su peticion");
    } 
    
}
