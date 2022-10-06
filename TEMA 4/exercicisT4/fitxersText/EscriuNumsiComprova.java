package fitxersText;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
/**
 * Escriu en un fitxer de text (test1.txt) els numeros de l'1 al 999.  
 * Posteriorment, els torna a llegir d'aquest fitxer per tal de sumar-los, 
 * verificant que el resultat es correcte.
 * @author PRG
 * @version Curs 2019/20
 */ 
public class EscriuNumsiComprova {
    private EscriuNumsiComprova() { }
         
    public static void main(String[] args) {
        String fitxer = "fitxersText/test1.txt";
        int suma = 0;  
        try {
            System.out.println("Escrivint fitxer " + fitxer);
            PrintWriter pw = new PrintWriter(new File(fitxer));
            for (int i = 1; i < 1000; i++) { 
                pw.println(i);
            }
            pw.close();
   
            System.out.println("Llegint del fitxer " + fitxer);
            Scanner scanner = new Scanner(new File(fitxer));
            while (scanner.hasNextInt()) { 
                suma += scanner.nextInt(); 
            }     
            scanner.close();
   
            System.out.print("Els valors llegits");
            if (suma != sumaNumeros(1000)) { System.out.print(" NO"); }
            System.out.println(" son correctes");      
        } catch (FileNotFoundException ex) {
            System.err.println("Problemes en obrir el fitxer " 
                               + fitxer + ". Rao: " + ex.getMessage());
        }  
    }
    
    /**
     * Suma els enters en l'interval [1,n[
     * @param n int, valor màxim de l'interval (no inclos).
     * @return int.
     */
    public static int sumaNumeros(int n) {
        int suma = 0;
        for (int i = 1; i < n; i++) { suma += i; }
        return suma;
    }
}