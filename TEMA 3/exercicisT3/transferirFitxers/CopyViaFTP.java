package transferirFitxers;

/**
 * Classe CopyViaFTP - permet realitzar la transferencia 
 * d'un arxiu a un altra maquina mitjançant FTP. 
 * 
 * @author PRG 
 * @version Curs 2019/20
 */
public class CopyViaFTP {
    /** No hi ha objectes d'aquesta classe. */
    private CopyViaFTP() { }
    
    /**
     * Realitza la transferencia d'un arxiu donat a una maquina donada.
     * @param hostName String amb el nom de la màquina.
     * @param localFilePath String amb el nom de l'arxiu.
     * @throws UnableToTransferException quan no es pot fer la transferencia.
     */
    public static void copyTo(String hostName, String localFilePath) 
        throws UnableToTransferException {
					   
        // Aci instruccions per fer la transferencia del fitxer
        // localFilePath a la maquina hostName
        
        // Per fer proves, suposant que mai es pot fer la transferencia:
        throw new UnableToTransferException("no es pot fer la transferencia");        
    }
}