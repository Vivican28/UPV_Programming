package lecturaEnterPositiu;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;
/**
 * Classe LecturaEnterPositiu2: permet la lectura des de teclat
 * d'un enter positiu propagant l'excepcio InputMismatchException 
 * al metode de lectura i capturant-la al main.
 * 
 * @author PRG 
 * @version Curs 2019/20
 */
public class LecturaEnterPositiu2 {
    /** No hi ha objectes d'aquesta classe. */
    private LecturaEnterPositiu2() { }
    
    /**
     * Lectura d'un enter >= 0 des de teclat.
     * @param t Scanner amb el que es fa la lectura.
     * @return int, enter llegit.
     * @throws InputMismatchException - si el token llegit no es un Integer 
     *                                  o esta fora de rang.
     */
    public static int llegirEnterPositiu(Scanner t) 
        throws InputMismatchException {
        int llegit;
        do {
            System.out.print("Introdueix un enter positiu: ");
            llegit = t.nextInt();
            if (llegit < 0) { System.out.println("Error: no es positiu"); }
        } while (llegit < 0);
        return llegit;
    }
    
    public static void main(String[] args) {
        Scanner tec = new Scanner(System.in).useLocale(Locale.US);        
        boolean eixir = false;
        int resp;
        do {
            try {
                resp = llegirEnterPositiu(tec);
                System.out.println("S'ha llegit el numero " + resp);
                eixir = true;
            } catch (InputMismatchException e) {
                System.out.println("Error: no es un enter");                
            } finally { 
                tec.nextLine();         
            }
        } while (!eixir);         
    }
}
