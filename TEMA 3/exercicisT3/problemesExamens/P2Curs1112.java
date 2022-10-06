package problemesExamens;

import java.util.Scanner; 
/**
 * Classe P2Curs1112: exercici sobre excepcions del parcial 2 del curs 2011/12.
 * El mètode llegirInt demana a l'usuari un valor enter, que és llegit com una String, val, 
 * que després és transformada, mitjançant l'operació Integer.parseInt(val) en el valor 
 * enter que aquesta conté.
 * El problema és que si el que conté la String no és un enter correctament escrit (per exemple 
 * perque continga alguna lletra) es produirà una excepcióo NumberFormatException, detenint-se 
 * a continuació el procés de lectura.
 * 
 * Es demana: modificar el mètode llegirInt() per tal que, cas de produir-se una excepció
 * NumberFormatException durant la transformació de la String a int, torne a demanar les vegades 
 * que calga el valor fins que aquest siga un nombre correcte.
 *
 * @author PRG
 * @version Curs 2019/20
 */
public class P2Curs1112 {
    private P2Curs1112() { }
    
    public static int llegirInt() {
        Scanner tcl = new Scanner(System.in);
        System.out.print("Dona'm valor: ");
        String val = tcl.nextLine().trim();
        int ret = Integer.parseInt(val);
        return ret;
    }
}
