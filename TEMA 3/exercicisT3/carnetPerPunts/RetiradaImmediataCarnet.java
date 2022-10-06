package carnetPerPunts;

/**
 * Classe RetiradaImmediataCarnet - excepcio llançada per 
 * CarnetDeConduir quan el nombre de punts es zero o negatiu.
 * 
 * @author PRG 
 * @version Curs 2019/20
 */
public class RetiradaImmediataCarnet extends Exception {
    /** Crea una excepcio RetiradaImmediataCarnet sense cap missatge. */
    public RetiradaImmediataCarnet() { super(); }
    
    /** Crea una excepcio RetiradaImmediataCarnet amb el missatge especificat. 
     *  @param msg String, el missatge.  
     */
    public RetiradaImmediataCarnet(String msg) { super(msg); }
}
