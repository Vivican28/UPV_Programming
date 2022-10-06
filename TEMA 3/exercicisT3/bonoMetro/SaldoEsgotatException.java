package bonoMetro;

/**
 * Classe SaldoEsgotatException - excepcio llançada per 
 * BonoMetro quan al picar no queden viatges disponibles.
 * 
 * @author PRG 
 * @version Curs 2019/20
 */
public class SaldoEsgotatException extends Exception {    
    /** Crea una excepcio SaldoEsgotatException sense cap missatge. */
    public SaldoEsgotatException() { super(); }
    
    /** Crea una excepcio SaldoEsgotatException amb el missatge especificat. 
     *  @param msg String, el missatge.  
     */
    public SaldoEsgotatException(String msg) { super(msg);
    }
}