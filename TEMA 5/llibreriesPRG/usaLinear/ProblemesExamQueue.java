package usaLinear;

import java.util.NoSuchElementException;
import linear.QueueIntLinked;
/**
 * Classe ProblemesExamQueue: mètodes d'exàmens de cursos anteriors que 
 * fan ús dels mètodes de la classe QueueIntLinked.
 *
 * @author PRG
 * @version Curs 2019/20
 */
public class ProblemesExamQueue {
    private ProblemesExamQueue() { }

    /** RecP2 - Curs 18/19 */
    public static void moureAlFinal(QueueIntLinked q, int x) {
        // COMPLETAR
    }

    /** P2 - Curs 17/18 */    
    /** Versió 1 */
    public static QueueIntLinked fusion1(QueueIntLinked q1, QueueIntLinked q2) {
        QueueIntLinked res = new QueueIntLinked();
        // COMPLETAR
        return res;
    }
    
    /** Versió 2 */
    public static QueueIntLinked fusion(QueueIntLinked q1, QueueIntLinked q2) {
        QueueIntLinked res = new QueueIntLinked();
        // COMPLETAR
        return res;
    }

    /** RecP2 - Curs 16/17 */
    /** Versió 1: sense estructures auxiliars */
    public static int fromCuaToInt1(QueueIntLinked q) {
        int res = 0;
        for (int i = 0; i < q.size(); i++) {
            // COMPLETAR
        }
        return res;
    }

    /** Versió 2: usant una cua auxiliar */
    public static int fromCuaToInt2(QueueIntLinked q) {
        int res = 0;
        QueueIntLinked qAux = new QueueIntLinked();
        while (!q.empty()) {
            // COMPLETAR
        }
        while (!qAux.empty()) {
            // COMPLETAR
        }
        return res;
    }

    /** P2 - Curs 13/14 */
    public static QueueIntLinked incrementaParells(QueueIntLinked q) {
        QueueIntLinked q1 = new QueueIntLinked();
        int n = q.size();
        for (int i = 0; i < n; i++) {
            // COMPLETAR
        }
        return q1;
    }

    /** RecP2 - Curs 13/14 */
    public static int maxim(QueueIntLinked c) {
        int n = c.size();
        if (n == 0) { throw new NoSuchElementException("Cua buida: màxim no definit"); }
        int e = c.remove();
        int maxim = e;
        c.add(e); n--;
        while (n > 0) {
            // COMPLETAR
        }
        return maxim;
    }

    public static void main(String[] args) {
        // Crea una cua buida com una llista enllaçada
        QueueIntLinked q1 = new QueueIntLinked();
        // Encuar els valors 1, 2, 3, 4, 5, 6        
        int[] dades1 = {1, 2, 3, 4, 5, 6};        
        for (int i = 0; i < dades1.length; i++) { q1.add(dades1[i]); }  
        System.out.println("q1: " + q1);

        // Crea un altra cua buida com una llista enllaçada
        QueueIntLinked q2 = new QueueIntLinked();
        // Encuar els valors 7, 8, 9        
        int[] dades2 = {7, 8, 9};        
        for (int i = 0; i < dades2.length; i++) { q2.add(dades2[i]); } 
        System.out.println("q2: " + q2);

        // Moure al final el 3 en q1
        moureAlFinal(q1, 3);
        System.out.println("\nDesprés de moureAlFinal:\nq1: " + q1);

        // Fusionar q1 i q2
        QueueIntLinked q3 = fusion(q1, q2);
        System.out.println("\nDesprés de fusion:\nq1: " + q1 + "\nq2: " + q2 + "\nq3: " + q3);

        // From cua to int de q1
        System.out.println("\nfromCuaToInt(q1): " + fromCuaToInt1(q1));
        System.out.println("q1: " + q1);
        
        // Incrementar els números parells de q3
        QueueIntLinked q4 = incrementaParells(q3);
        System.out.println("\nDesprés de incrementaParells:\nq3: " + q3 + "\nq4: " + q4);
        
        // Màxim de q4
        System.out.println("\nmaxim(q4): " + maxim(q4));
        System.out.println("q4: " + q4);
    }
}
