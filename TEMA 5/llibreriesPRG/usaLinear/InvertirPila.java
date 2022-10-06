package usaLinear;

import linear.QueueIntLinked;
import linear.StackIntLinked;
/**
 * Programa que crea una pila amb els 10 primers enters parells i 
 * la inverteix (fent ús d'una cua auxiliar).
 *  
 *  @author PRG
 *  @version Curs 2019/20
 */
public class InvertirPila {
    private InvertirPila() { }
    
    public static void main(String[] args) {
        StackIntLinked p = new StackIntLinked();
        for (int i = 1; i <= 10; i++) {
            p.push(2 * i);
        }
        System.out.println("Abans d'invertir la pila: ");
        System.out.println(p.toString());
        invertIter(p);
        System.out.println("Després d'invertir la pila: ");
        System.out.println(p.toString());
    }
    
    /** mètode iteratiu que inverteix la pila p 
     *  fent ús d'una cua auxiliar */
    private static void invertIter(StackIntLinked p) {
        QueueIntLinked qAux = new QueueIntLinked();
        while (!p.empty()) {
            int x = p.pop();
            qAux.add(x);
        }
        
        while (!qAux.empty()) {
            int x = qAux.remove();
            p.push(x);
        }
    } 
}
