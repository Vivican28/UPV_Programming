package usaLinear;

import linear.QueueIntLinked;
import linear.StackIntLinked;
/** 
 *  Programa que crea una cua amb els 10 primers enters parells i la inverteix.
 *  
 *  @author PRG
 *  @version Curs 2019/20
 */
public class InvertirCua {
    private InvertirCua() { }
    
    public static void main(String[] args) {
        QueueIntLinked q = new QueueIntLinked();
        for (int i = 1; i <= 10; i++) {
            q.add(2 * i);
        }
        System.out.println("Abans d'invertir la cua: ");
        System.out.println(q.toString());
        //invertRecur(q);
        invertIter(q);
        System.out.println("Després d'invertir la cua: ");
        System.out.println(q.toString());
    }
    
    /** mètode recursiu que inverteix la cua q */
    private static void invertRecur(QueueIntLinked q) {
        if (!q.empty()) {
            int x = q.remove();
            invertRecur(q);
            q.add(x);
        }
    }
    
    /** mètode iteratiu que inverteix la cua q 
     *  fent ús d'una pila auxiliar */
    private static void invertIter(QueueIntLinked q) {
        StackIntLinked pAux = new StackIntLinked();
        while (!q.empty()) {
            int x = q.remove();
            pAux.push(x);
        }
        
        while (!pAux.empty()) {
            int x = pAux.pop();
            q.add(x);
        }
    }
}
