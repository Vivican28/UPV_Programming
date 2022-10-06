package fitxersText;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 *  El main rep com arguments la ruta a un fitxer de text i una paraula. 
 *  Mostra per pantalla totes les linies en les que apareix 
 *  eixa paraula (en el format: numLinia: contingut de la linia)
 * 
 *  @author PRG
 *  @version Curs 2019/20
 */ 
public class Filtra {
    private Filtra() { }
    
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Introdueix la ruta a un fitxer de text "
                               + "i la paraula a buscar");     
        }
        else {
            String filePath = args[0];
            String paraula = args[1];       
            System.out.println("Buscant les ocurrencies de " + paraula 
                               + " en el fitxer: " + filePath);
            Scanner s = null;                   
            try {
                s = new Scanner(new File(filePath));
                cercaParaula(s, paraula);
            } catch (FileNotFoundException ex) {
                System.out.println("El fitxer " + filePath + " no existeix.");  
            } finally {
                if (s != null) { s.close(); } // COMPROVAR si existeix.
            }
        }
    } // de main   
    
    /**
     * Mostra per pantalla les ocurrencies d'una paraula en un fitxer.
     * @param scanner Scanner que representa el fitxer d'on llegir.
     * @param paraula String que representa la paraula a cercar.
     */
    public static void cercaParaula(Scanner scanner, String paraula) {      
        int numLinia = 0;
        while (scanner.hasNextLine()) {
            String linia = scanner.nextLine();
            numLinia++;
            if (linia.indexOf(paraula) != -1) {
                System.out.println(numLinia + ": " + linia);
            }
        }       
    }
}