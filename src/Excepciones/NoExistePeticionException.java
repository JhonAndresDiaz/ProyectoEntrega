
package Excepciones;

/**
 *
 * @author diazje
 */
public class NoExistePeticionException extends RuntimeException {
    
    public NoExistePeticionException() {
        super("No se encontro ninguna peticion con este numero de codigo");
    }
}
