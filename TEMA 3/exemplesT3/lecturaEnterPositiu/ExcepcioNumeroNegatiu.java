package lecturaEnterPositiu;

/**
 * Classe ExcepcioNumeroNegatiu - llançada des de LecturaEnterPositiu3
 * quan el token llegit no es un enter >= 0.
 * 
 * @author PRG 
 * @version Curs 2019/20
 */
public class ExcepcioNumeroNegatiu extends Exception {
    
    /** Crea una excepcio ExcepcioNumeroNegatiu sense cap missatge. */
    public ExcepcioNumeroNegatiu() { super(); }    
    
    /** Crea una excepcio ExcepcioNumeroNegatiu amb el missatge especificat. 
     *  @param msg String, el missatge.  
     */
    public ExcepcioNumeroNegatiu(String msg) { super(msg); }
}