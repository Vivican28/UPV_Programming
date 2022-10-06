package lecturaEnterPositiu;

import java.util.Locale;
import java.util.Scanner;
/**
 * Classe LecturaEnterPositiuSenseExcepcions: permet la lectura des de teclat
 * d'un enter positiu sense fer cap gestio de les exepcions que poden ocorrer.
 * 
 * @author PRG 
 * @version Curs 2019/20
 */
public class LecturaEnterPositiuSenseExcepcions {
    /** No hi ha objectes d'aquesta classe. */
    private LecturaEnterPositiuSenseExcepcions() { }
    
    /**
     * Llig des d'un Scanner i torna un valor enter >= 0.
     * @param t Scanner per a lectura des de teclat.
     * @return int, enter llegit >= 0.
     */ 
    public static int llegirEnterPositiu(Scanner t) {
        boolean eixir = false;
        int llegit = 0;
        do {
            System.out.print("Introdueix un enter positiu: ");
            llegit = t.nextInt();
            if (llegit < 0) { System.out.println("Error: no es positiu"); }
            else { eixir = true; }
            t.nextLine();
        } while (!eixir);        
        return llegit;
    }
        
    public static void main(String[] args) {
        Scanner tec = new Scanner(System.in).useLocale(Locale.US);
        int resp = llegirEnterPositiu(tec);   
        System.out.println("S'ha llegit el numero " + resp);
    }
}
