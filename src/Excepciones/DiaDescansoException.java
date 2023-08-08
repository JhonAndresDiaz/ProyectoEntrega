
package Excepciones;

import java.time.LocalDate;

/**
 *
 * @author diazje
 */
public class DiaDescansoException extends RuntimeException {
    
    public DiaDescansoException (LocalDate dia){
        super("En la fecha " +dia+ " el médico descansa, seleccione otro día");
    }
}
