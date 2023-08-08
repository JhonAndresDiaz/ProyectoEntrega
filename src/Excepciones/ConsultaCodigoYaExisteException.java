
package Excepciones;

/**
 *
 * @author diazje
 */
public class ConsultaCodigoYaExisteException extends RuntimeException  {
    
    public ConsultaCodigoYaExisteException() {
    super("Solo puede crear un PQRS por consulta atendida");
    }  
}
