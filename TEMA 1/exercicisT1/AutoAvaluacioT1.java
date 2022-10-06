/**
 * Classe AutoAvaluacioT1: mètodes recursius numèrics, 
 * amb arrays i amb Strings.
 * 
 * @author (ESCRIU ACI Cognoms i nom del/s autor/s) 
 * @version Tema 1 - Sessio 6
 */
public class AutoAvaluacioT1 {
    private AutoAvaluacioT1() { }
    
    /** Torna una String amb la seqüència 1 2 ... m-1 m , 
     *  acabada per un caràcter de canvi de línia.
     *  Precondició: m > 0.
     */
    public static String sequencia(int m) {
        String res = "1 "; 
        for (int i = 2; i <= m; i++) { res += i + " "; }
        return res + "\n"; 
    }    
    
    /** Torna una String de n línies amb seqüències decreixents,
     *  formant un triangle.
     *  Precondicio: n > 0.
     */
    public static String trgSuperior(int n) {
        if (n == 1) { return sequencia(1);}
        else { return sequencia(n) + trgSuperior(n - 1); }
    }
    
    /** Torna una String de n línies amb seqüències creixents,
     *  formant un triangle.
     *  Precondició: n > 0.
     */
    public static String trgInferior(int n) {
        if (n == 1) { return sequencia(1);}
        else { return trgInferior(n - 1) + sequencia(n); }
    }
    
    /** Calcula a[0] + a[1]*x + ... + a[i]*x^i.
     *  Precondició: -- COMPLETAR --  
     */
    /* COMPLETAR - metode privat recursiu */
    public static double polinomi(double[] a, double x, int i) {
        if (i == 0) return a[0];
        else return polinomi(a, x, i-1) + a[i] * Math.pow(x, i);
    }
    
    /** Calcula a[0] + a[1]*x + ... + a[a.length-1]*x^(a.length-1).
     *  Precondició: -- COMPLETAR --
     */
    /* COMPLETAR - metode public guia que crida a l'anterior */
    
    /** Determina si a i b són simètriques.
     *  Precondició: -- COMPLETAR --
     */
    public static boolean simetriques(String a, String b) {
        if (a.length() == 0) return true;
        else {
            int ult = b.length() - 1;
            return a.charAt(0) == b.charAt(ult)
                && simetriques(a.substring(1), b.substring(0, ult));
        }
    }    
}