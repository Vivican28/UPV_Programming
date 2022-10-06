package figures;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;
/**
 * Classe LecturaFigures - Classe d'utilitats amb metodes 
 * que permeten llegir des de l'entrada estandard les 
 * caracteristiques de distintes figures geometriques.
 * 
 * @author PRG 
 * @version Curs 2019/20
 */
public class LecturaFigures {
    private static final String ERR = "Atenció. NO s'ha introduit "; 
    private static final String[] COLORS_VALIDS = {"groc", "blau", 
                                                   "roig", "verd", 
                                                   "negre", "taronja"};
                                                   
    /** No hi ha objectes d'aquesta classe. */
    private LecturaFigures() { }
    
    /**
     * Llig una Figura des de teclat.
     * @param teclat Scanner per llegir des de l'entrada estàndard.
     * @return Figura.
     */
    public static Figura llegirFigura(Scanner teclat) {
        Figura res = null;
        System.out.println("*** MENÚ DE LECTURA DES DE TECLAT ***\n");
        System.out.println("         1. Cercle");
        System.out.println("         2. Rectangle");
        System.out.println("         3. Quadrat");
        System.out.println("         0. Eixir");
        System.out.print("    Tria una opció: ");
        int opcio = llegirIntValid(teclat);
        if (opcio == 1) { res = llegirCercle(teclat); }
        else if (opcio == 2) { res = llegirRectangle(teclat); }
        else if (opcio == 3) { res = llegirQuadrat(teclat); }
        return res;
    }
    
    /**
     * Llig un enter vàlid (>=0 i <=3) des de teclat.
     * @param teclat Scanner per llegir des de l'entrada estàndard.
     * @return int, enter llegit.
     */
    private static int llegirIntValid(Scanner teclat) {
        boolean lecturaCorrecta = false;
        int res = 0;           
        do {
            try {
                res = teclat.nextInt();                
                if (res >= 0 && res <= 3) { lecturaCorrecta = true; }
            } catch (InputMismatchException eUnchecked) {
                System.out.println(ERR + "un enter");
            } finally {
                teclat.nextLine(); 
                if (!lecturaCorrecta) {
                    System.out.println(ERR + "una opció vàlida");
                    System.out.println("Introduisca: 1--> Cercle, "
                                       + "2--> Rectangle, 3--> Quadrat i "
                                       + "0--> Eixir\n");
                }            
            }
        } while (!lecturaCorrecta);
        return res;
    }  
    
    /**
     * Llig un color vàlid des de teclat.
     * @param teclat Scanner per llegir des de l'entrada estàndard.
     * @return String, cadena de caracters llegida.
     */
    private static String llegirColorValid(Scanner teclat) {
        boolean lecturaCorrecta = false;
        String res = "";
        System.out.print("Introduisca un color: ");
        do {
            try {
                res = teclat.nextLine().toLowerCase();
                if (!validarColor(res)) { throw new InputMismatchException(); }
                lecturaCorrecta = true;
            } catch (InputMismatchException eUnchecked) {
                System.out.println(ERR + "un color vàlid");
                System.out.print("Introduisca algun d'aquestos colors: ");
                for (int i = 0; i < COLORS_VALIDS.length; i++) {
                    System.out.print(COLORS_VALIDS[i] + " ");
                }
                System.out.println();
            }
        } while (!lecturaCorrecta);
        return res;
    }
    
    /**
     * Comprova que el color és vàlid 
     * (que pertany al conjunt de colors vàlids).
     * @param color String que representa un color.
     * @return boolean, true si és un color vàlid i 
     *         false en cas contrari.
     */
    private static boolean validarColor(String color) {
        boolean valid = false;
        for (int i = 0; i < COLORS_VALIDS.length && !valid; i++) {
            if (color.equals(COLORS_VALIDS[i])) { valid = true; }
        }
        return valid;
    }
    
    /**
     * Llig un real vàlid (>=0.0) des de teclat.
     * @param teclat Scanner per llegir des de l'entrada estàndard.
     * @return double, real llegit.
     */
    private static double llegirDoubleValid(Scanner teclat) {
        boolean lecturaCorrecta = false;
        double res = 0;           
        do {
            try {
                res = teclat.nextDouble();                
                if (res < 0) { throw new InputMismatchException(); }
                lecturaCorrecta = true;
            } catch (InputMismatchException eUnchecked) {
                System.out.println(ERR + "un double positiu");
                System.out.print("Introduisca un de nou: ");
            } finally {
                teclat.nextLine();              
            }
        } while (!lecturaCorrecta);
        return res;
    }  
    
    /** 
     * Torna un Cercle a partir de la lectura dels valors 
     * dels seus atributs des de teclat.
     * @param teclat Scanner per llegir des de l'entrada estàndard.
     * @return Cercle.
     */
    public static Cercle llegirCercle(Scanner teclat) {        
        System.out.println("\n*** LECTURA D'UN Cercle DES DE TECLAT ***");
        System.out.print("Introduisca el radi del Cercle: ");
        double radi = llegirDoubleValid(teclat);
        Cercle res = new Cercle(radi);
        res.setColor(llegirColorValid(teclat));
        return res;
    }
    
    /**
     * Llegir un Rectangle des de teclat.
     * @param teclat Scanner per llegir des de l'entrada estàndard.
     * @return Rectangle.
     */
    public static Rectangle llegirRectangle(Scanner teclat) {        
        System.out.println("\n*** LECTURA D'UN Rectangle DES DE TECLAT ***");
        System.out.print("Introduisca la base del Rectangle: ");
        double base = llegirDoubleValid(teclat);
        System.out.print("Introduisca l'altura del Rectangle: ");
        double altura = llegirDoubleValid(teclat);
        Rectangle res = new Rectangle(base, altura);
        res.setColor(llegirColorValid(teclat));
        return res;
    } 
    
    /**
     * Torna un Quadrat llegit des de teclat.
     * @param teclat Scanner per llegir des de l'entrada estàndard.
     * @return Quadrat.
     */
    public static Quadrat llegirQuadrat(Scanner teclat) { 
        System.out.println("\n*** LECTURA D'UN Quadrat DES DE TECLAT ***");
        System.out.print("Introduisca el costat del Quadrat: ");
        double costat = llegirDoubleValid(teclat);
        Quadrat res = new Quadrat(costat);  
        res.setColor(llegirColorValid(teclat));
        return res;
    }
}
