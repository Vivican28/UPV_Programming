package lecturaEnterPositiu;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;
/**
 * Classe LecturaEnterPositiu1: permet la lectura des de teclat
 * d'un enter positiu capturant l'excepcio InputMismatchException 
 * al metode de lectura.
 * 
 * @author PRG 
 * @version Curs 2019/20
 */
public class LecturaEnterPositiu1 {
   /** No hi ha objectes d'aquesta classe. */
    private LecturaEnterPositiu1() { }
    
   /**
     * Lectura d'un enter >=0 des de teclat.
     * @param t Scanner amb el que es fa la lectura.
     * @return int, enter llegit >= 0.
     */
    public static int llegirEnterPositiu(Scanner t) {
        boolean eixir = false;
        int llegit = 0;
        do {
            try {
                System.out.print("Introdueix un enter positiu: ");
                llegit = t.nextInt();
                if (llegit < 0) { System.out.println("Error: no es positiu"); }
                else { eixir = true; }
            } catch (InputMismatchException e) {
                System.out.println("Error: no es un enter");
            } finally {
                t.nextLine();
            }
        } while (!eixir);
        return llegit;
    }
        
    public static void main(String[] args) {
        Scanner tec = new Scanner(System.in).useLocale(Locale.US);
        int resp = llegirEnterPositiu(tec);   
        System.out.println("S'ha llegit el numero " + resp);
    }
}
