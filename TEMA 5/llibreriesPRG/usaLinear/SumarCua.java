package usaLinear;

import linear.QueueIntLinked;
/** 
 *  Programa que crea una cua d'enters i suma les seues dades.
 *  
 *  @author PRG
 *  @version Curs 2019/20
 */
public class SumarCua {
    private SumarCua() { }
    
    public static void main(String[] args) {
        // 1.- Crea una cua amb les dades 1, 6, 7, 8, -1, -7, -6
        QueueIntLinked q = new QueueIntLinked();
        q.add(1); q.add(6); q.add(7); q.add(8); 
        q.add(-1); q.add(-7); q.add(-6);    
        
        // 2.- Guarda en la variable suma la suma dels seus elements
        int suma = sumar(q);
        
        // 3.- Mostra per pantalla el contingut de la cua i la suma dels seus elements
        System.out.println(q);       
        System.out.println("Suma: " + suma);
    }
    
    /**
     * VERSIÓ 1: usant una cua auxiliar.
     */ 
    private static int sumar(QueueIntLinked q) {
        // ESTRATEGIA: trasvasar tots els nodes a una cua auxiliar i anant suman-los a un 
        // contador. Després tornar-los a la q inicial
        int sum = 0;
        QueueIntLinked aux = new QueueIntLinked();
        while (!q.empty()) {
            int x = q.remove();
            aux.add(x);
            sum += x;
        }
        // q està buida
        // aux té els mateix nombre d'elements que q en l'estat inicial
        while (!aux.empty()) {
            int x = aux.remove();
            q.add(x);
        }
        return sum;
    }   
    
    /**
     * VERSIÓ 2: No és precís usar una cua auxiliar. Si la cua té n elements, 
     * només cal desencuar n vegades l'element en cap i tornar-lo a encuar.
     */
    private static int sumar2(QueueIntLinked q) {
        int sum = 0;
        int n = q.size();
        while (n > 0) {
            int x = q.remove();
            q.add(x); 
            sum += x;
            n--; 
        }
        return sum;
    }
}
