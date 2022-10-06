package transferirFitxers;

/**
 * Classe TestCopyViaFTP - permet fer la transferencia 
 * del fitxer /tmp/data a la màquina fileserver.upv.es. 
 * En cas d’error, l'operació s'haurà de reintentar un màxim 
 * de 3 vegades i indicar a l'usuari el número d'intent.
 * @author PRG 
 * @version Curs 2019/20
 */
public class TestCopyViaFTP {
    /** No hi ha objectes d'aquesta classe. */
    private TestCopyViaFTP() { }
    
    public static void main(String[] args) {
        String hostName = "fileserver.upv.es";
        String localFilePath = "/tmp/data";
        boolean ok = false;
        int intents = 0;
        do {
            try {
                System.out.println("Transferencia de " + localFilePath
                            + " a la maquina " + hostName);
                CopyViaFTP.copyTo(hostName, localFilePath); 
                System.out.println("Transferencia feta");
                ok = true;
            } catch (UnableToTransferException ex) {
                intents++;
                System.err.println(intents
                                    + " intents. Error: " + ex.getMessage());
            }
        } while (!ok && intents < 3);
    }
}