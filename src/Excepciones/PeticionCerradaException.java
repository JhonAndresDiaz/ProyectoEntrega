
package Excepciones;

/**
 *
 * @author diazje
 */
public class PeticionCerradaException extends RuntimeException {
    
    public PeticionCerradaException() {
    super("La peticion fue terminada");
    } 
    
}
