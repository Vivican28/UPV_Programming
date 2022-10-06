package fitxersText;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
/**
 * El main rep com arguments la ruta a un fitxer de text i una paraula. 
 * I elimina totes les ocurrencies de la paraula al fitxer de text donat,
 * escrivint en un altre fitxer.
 * Si el nom del fitxer donat es "nomFitx.txt", el nom del fitxer resultat 
 * sera "nomFitx_2.txt"
 * 
 * @author PRG
 * @version Curs 2019/20
 */ 
public class Elimina {  
    private Elimina() { }
    
    /**
     * Elimina les ocurrencies d'una paraula en un fitxer 
     * de text donat, escrivint en un altre fitxer de text.
     * @param s Scanner que representa el fitxer d'on llegir.
     * @param w String que representa la paraula a eliminar.
     * @param pw PrintWriter que representa el fitxer on escriure.
     */  
    public static void elimina(Scanner s, String w, PrintWriter pw) {
        while (s.hasNext()) {
            String p = s.next(); // Les paraules es prenen com solament "next"
            if (!p.equals(w)) { pw.println(p); }
        }
    }
      
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Introdueix la ruta a un fitxer de text "
                               + "i la paraula a eliminar");     
        }
        else {
            String f1 =  args[0];
            String paraula = args[1];       
            System.out.println("Eliminant totes les ocurrencies de " + paraula 
                               + " al fitxer: " + f1);
            Scanner s = null; PrintWriter pw = null;
            try {
                s = new Scanner(new File(f1));
                File f2 = new File(f1.substring(0, f1.indexOf('.')) + "_2.txt");
                pw = new PrintWriter(f2);
                elimina(s, paraula, pw);
                System.out.println("Resultat en " + f2);                
            } catch (FileNotFoundException ex) {
                System.out.println("El fitxer " + f1 + " no existeix.");  
            } finally {
                if (s != null) { s.close(); }
                if (pw != null) { pw.close(); }
            }
        }
    }           
}  