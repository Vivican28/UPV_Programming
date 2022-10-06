package altres;

import java.util.Locale;
import java.util.Scanner;
/**
 * Classe MesuresPlutja: mostra per pantalla les mesures de plutja
 * llegides des de teclat.
 * 
 * @author PRG 
 * @version Curs 2019/20
 */
public class MesuresPlutja {    
    /** No hi ha objectes d'aquesta classe. */
    private MesuresPlutja() { }
    
    public static void main(String[] args) {
        Scanner teclat = new Scanner(System.in).useLocale(Locale.US);
        double[] elArray = recollirDadesPlutja(teclat);
        System.out.print("Array Mesures: { ");
        for (int i = 0; i < elArray.length; i++) {
            if (i != elArray.length - 1) { 
                System.out.print(elArray[i] + ", ");
            }
            else { System.out.print(elArray[i] + " }"); }
        }
    }
    
    /** 
     * Lectura de les mesures i construccio de l'array.
     * @param t Scanner per fer la lectura.
     * @return double[], array de reals amb les mesures de plutja.
     */
    public static double[] recollirDadesPlutja(Scanner t) {
        System.out.print("Introdueix el numero de mesures: ");
        int num = t.nextInt();
        double[] resultat;
        try {
            resultat = new double[num];
        } catch (NegativeArraySizeException e) {
            System.out.println("S'ha produit l'error " + e);
            System.out.println(num + "<0 --> se li canvia el signe.");
            System.out.println("Array de " + (-num) + " elements.");
            num *= -1;
            resultat = new double[num];
        }
        
        // Per tractar aquest error no es necessari el bloc try-catch.
        // Directament:
        // if (num < 0) num *= -1;
        // resultat = new double[num];
        
        System.out.println("Introdueix les precipitacions mesurades:");
        for (int i = 0; i < num; i++) {
            System.out.print("Litres de la mesura " + (i + 1) + ": ");
            resultat[i] = t.nextDouble();
        }
        return resultat;
    }
}