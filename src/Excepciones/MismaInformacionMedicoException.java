
package Excepciones;

/**
 *
 * @author diazje
 */
public class MismaInformacionMedicoException extends RuntimeException {
    
    public MismaInformacionMedicoException() {
        super("Se ha cambiado su informacion correctamente, en su cuenta de Paciente y Medico");
    } 
}
