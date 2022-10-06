package fitxersText;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 * Obte estadistiques basiques sobre un fitxer de text 
 * rebut pel main com argument.
 *  
 * @author PRG
 * @version Curs 2019/20
 */ 
public class Estadistiques {
    private Estadistiques() { }
    
    /**
     * Mostra per pantalla les estadistiques basiques 
     * d'un fitxer de text donat.
     * @param s Scanner que representa el fitxer d'on llegir.
     */    
    public static void estadistiques(Scanner s) {    
        int nParaules = 0, nChars = 0;
        while (s.hasNext()) {
            String p = s.next();
            nParaules++;
            nChars += p.length();
        }      
        System.out.println("Numero total de paraules: " + nParaules);
        System.out.println("Numero total de caracters:" + nChars);
        System.out.println("Longitud mitjana: " + nChars / (double) nParaules);
    }
      
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Introdueix la ruta a un fitxer de text");  
        }
        else {
            String f1 = args[0]; 
            Scanner s = null;
            try {
                s = new Scanner(new File(f1));
                System.out.println("Estadistiques del fitxer: " + f1);   
                estadistiques(s);                  
            } catch (FileNotFoundException ex) {
                System.out.println("El fitxer " + f1 + " no existeix.");  
            } finally {
                if (s != null) { s.close(); }
            }
        }
    }           
}  
