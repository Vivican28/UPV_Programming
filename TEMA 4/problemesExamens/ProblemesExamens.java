 

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;
/**
 * Classe ProblemesExamens: problemes d'exÃ mens del Tema 4 de cursos anteriors.
 *
 * @author PRG
 * @version Curs 2019/20
 */
public class ProblemesExamens {
    private ProblemesExamens() { }
    
    /** P2 - Curs 18/19 */
    public static void sumInt(String fileIn, String fileOut) throws FileNotFoundException {
        Scanner in = new Scanner(new File(fileIn));
        PrintWriter out = new PrintWriter(new File(fileOut));
        int sum = 0;
        while (in.hasNext()) {
            try {
                int n = in.nextInt();
                out.println(n);
                sum += n;
            } catch (InputMismatchException e) {
                out.println("(Error: " + in.next() + ")");
            }
        }
        out.println("Suma: " + sum);
        in.close(); out.close();
    }
    
    /** RecP2 - Curs 18/19 */
    public static void filtraErrors(String fileIn, String fileOut) throws FileNotFoundException {
        Scanner in = new Scanner(new File(fileIn));
        PrintWriter out = new PrintWriter(new File(fileOut));
        int cont = 0;
        while (in.hasNext()) {
            try {
                String linia = in.nextLine();
                cont++;
                String[] tokens = linia.split("([ \t]+");
                if (tokens.length != 4) {
                    out.println("Error línia " + cont + ": Incorrecte el nombre de dades.");
                } else {
                    int edat = Integer.parseInt(tokens[1]);
                    int punts = Integer.parseInt(tokens[2]);
                    int campionats = Integer.parseInt(tokens[3]);
                    if (edat < 0 || punts < 0 || campionats < 0) {
                        out.println("Error línia " + cont + ": Valor negatiu.");
                    } 
                } 
            } catch (NumberFormatException e) {
                    out.println("Error línia " + cont + ": Format d'enter no vàlid.");
            }
        }
        in.close(); out.close(); 
    }
    
    /** P2 - Curs 17/18 */
    public static File fromArrayToTextFile(int[] a) {
        File res = new File("ArrayElements.txt");
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(res);
            for (int i = 0; i < a.length; i++) {
                pw.print(a[i]);
            }
        } catch (FileNotFoundException e) {
            System.out.println("El array " + a + " no existeix");
        } finally {
            if (pw != null) { pw.close(); }
        }
        return res;
    }
    
    /** P2 - Curs 16/17 */
    public static void fitxerNou(String ftx) {
        File f = new File(ftx);
        Scanner sc = null;
        PrintWriter pw = null;
        try {
            sc = new Scanner(f).useLocale(Locale.US); 
            // SEMPRE el Locale PER ALS DOUBLE
            pw = new PrintWriter(new File(f + "_nou"));
            while (sc.hasNextLine()) {
                try {
                    pw.println(sc.nextDouble());
                } catch (InputMismatchException e1) {
                } finally {
                    sc.nextLine();
                }
            }
        } catch (FileNotFoundException e2) {
        } finally {
            if (sc != null) { sc.close(); }
            if (pw != null) { pw.close(); }
        }
    }
    
    /** RecP2 - Curs 16/17 */
    public static int lligISuma(String nomFitxer) {
        int suma = 0;
        Scanner s = null;
        try {
            s = new Scanner(new File(nomFitxer));
            while (s.hasNextLine()) {
                String[] linia = s.nextLine().trim().split(" ");
                for (int i = 0; i < linia.length; i++) {
                    try {
                        suma += Integer.parseInt(linia[i]);
                    } catch (NumberFormatException e) {
                        System.out.println(linia[i]);
                    }
                } 
            }
        } catch (FileNotFoundException e) {
            System.out.println("No s'ha trobat el fitxer");
        } finally {
            if (s != null) { s.close(); }
        }
        return suma;
    }
    
    /** P2 - Curs 2013-2014 */
    public static void escriuAmbMajuscules(String nomF1) throws FileNotFoundException{
        Scanner sc = new Scanner(new File(nomF1));
        while (sc.hasNextLine()) {
            System.out.println(sc.next().toUpperCase());
        }
        sc.close();
    }
    
    /** RecP2 - Curs 2013-2014 */
    public static boolean EstaEn(String nomFitx, String par) {
        Scanner s = null;
        boolean trobat = false;
        try {
            s = new Scanner(new File(nomFitx));
            while (s.hasNextLine() && !trobat) {
                if (s.next().equals(par))  trobat = true;
            }
        } catch (FileNotFoundException e) {
            System.out.println("El fitxer no existeix");
            trobat = false; // CORRECCIÓ EXAMEN: return false;
        } finally {
            if (s != null)  s.close(); 
            return trobat;
        }
    }
}