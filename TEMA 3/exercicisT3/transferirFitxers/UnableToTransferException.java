package transferirFitxers;

/**
 * Classe UnableToTransferException - excepcio llançada per 
 * CopyViaFTP quan no es pot fer la transferencia.
 * 
 * @author PRG 
 * @version Curs 2019/20
 */
public class UnableToTransferException extends Exception {
    /** Crea una excepcio UnableToTransferException sense cap missatge. */
    public UnableToTransferException() { super(); }
    
    /** Crea una excepcio UnableToTransferException amb el missatge especificat. 
     *  @param msg String, el missatge.  
     */
    public UnableToTransferException(String msg) { super(msg); }
}
