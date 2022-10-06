package fitxersText;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Locale;
/**
 * Classe IOPresio: classe d'utilitats amb metodes que permeten llegir/escriure 
 * des de/en fitxer de text els valors de presio (de tipus double) 
 * emmagatzemats en una matriu.
 * 
 * @author PRG 
 * @version Curs 2019/20
 */
public class IOPresio {    
    private static final String ERR = "\n***ERROR***: No s'ha pogut ";
    
    private IOPresio() { }
    
    /**
     * Escriu en un fitxer de text nomFitx els valors de tipus double
     * emmagatzemats en una matriu presions. 
     * Cada fila de la matriu s'escriu en una linea del fitxer i 
     * els valors de cada fila s'escriuen separats per espais en blanc.
     * @param presions double[][].
     * @param nomFitx String.
     */
    public static void escriuPresions(double[][] presions, String nomFitx) {
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(new File(nomFitx));
            for (int i = 0; i < presions.length; i++) {
                for (int j = 0; j < presions[i].length; j++) {
                    pw.print(presions[i][j] + " ");
                }
                pw.println();
            }
        } catch (FileNotFoundException e) {
            System.out.println(ERR + "escriure en el fitxer " + nomFitx);
        } finally {
            if (pw != null) { pw.close(); }
        }
    }
    
    /**
     * Llig des d'un fitxer de text nomFitx valors de tipus double 
     * (amb el "." com separador decimal) que va emmagatzemant en una 
     * matriu resultat de dimensions n x n.
     * @param nomFitx String amb el nom del fitxer.
     * @param n int dimensio de la matriu.
     * @return double[][].
     */
    public static double[][] lligPresions(String nomFitx, int n) {         
        double[][] aux = new double[n][n];    
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(nomFitx)).useLocale(Locale.US);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    try {
                        aux[i][j] = scanner.nextDouble();  
                    } catch (InputMismatchException e) {
                        System.out.println("\n***ERROR***: Dada no valida");
                    }
                }
            }
        } catch (FileNotFoundException  e) {
            System.out.println(ERR + "accedir al fitxer " + nomFitx);
        } finally {            
            if (scanner != null) { scanner.close(); }
        }
        return aux;
    }    
    
    public static void main(String[] args) {
        String nomFitx = "fitxersText/presio.txt";
        double[][] matriuPresions = lligPresions(nomFitx, 10);
        String nomFitx2 = "fitxersText/presio2.txt";
        escriuPresions(matriuPresions, nomFitx2);
    }
}
