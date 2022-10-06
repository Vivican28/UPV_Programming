package lecturaEnterPositiu;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;
/**
 * Classe LecturaEnterPositiu3: permet la lectura des de teclat
 * d'un enter positiu llançant l'excepcio d'usuari 
 * ExcepcioNumeroNegatiu al metode de lectura, propagant-la 
 * junt amb l'excepcio InputMismatchException. 
 * Sent ambdues capturades al main. 
 * 
 * @author PRG
 * @version Curs 2019/20
 */
public class LecturaEnterPositiu3 {
    /** No hi ha objectes d'aquesta classe. */
    private LecturaEnterPositiu3() { }
    
    /**
     * Lectura d'un enter >= 0 des de teclat.
     * @param t Scanner amb el que es fa la lectura.
     * @return int, enter llegit.
     * @throws InputMismatchException - si el token llegit no es un Integer 
     *                                  o esta fora de rang.
     * @throws ExcepcioNumeroNegatiu - si el token llegit no es un enter >= 0.
     */
    public static int llegirEnterPositiu(Scanner t) 
        throws InputMismatchException, ExcepcioNumeroNegatiu {
        System.out.print("Introdueix un enter positiu: ");
        int llegit = t.nextInt();
        if (llegit < 0) { 
            throw new ExcepcioNumeroNegatiu("numero " + llegit);
        }
        return llegit;
    }
    
    public static void main(String[] args) {
        Scanner tec = new Scanner(System.in).useLocale(Locale.US);
        boolean eixir = false;
        int resposta;
        do {
            try {
                resposta = llegirEnterPositiu(tec);
                System.out.println("S'ha llegit el numero " + resposta);
                eixir = true;
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage() 
                                   + ": Error: no es un enter");               
            } catch (ExcepcioNumeroNegatiu e) {
                System.out.println(e.getMessage() 
                                   + ": Error: no es positiu");               
            } finally {
                tec.nextLine();
            }
        } while (!eixir); 
    }
}