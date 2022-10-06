/**
 * Clase Pregunta1. 
 * @author PRG - Parcial 1
 * @version 19/06/20
 */
public class Pregunta1 {
    private Pregunta1() { }   // No hay objetos de esta clase
    
    /** Escribe en la salida estandar las parejas de
     *  un array a de char desde fuera hacia el centro.
     *  Precondicion: 0 <= ini, fi < a.length 
     */
    public static void preg1(char[] a, int ini, int fi) {
        if (a.length >= 0) {
            // if (ini > fi) Cas base
            if (ini <= fi) { // Cas general
                System.out.print(a[ini]);
                System.out.print(a[fi]);
                preg1(a, ini + 1, fi - 1);
            }
        }
    }
    
    
    public static void main(String[] args) {
        char[] aMain = {'a', 'b', 'c', 'd', 'e', 'f'};
        
        // COMPLETAR con la llamada inicial
        preg1(aMain, 0, aMain.length - 1);
    }        
}
