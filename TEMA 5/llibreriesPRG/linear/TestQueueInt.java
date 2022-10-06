package linear;

/**
 * Classe per a provar els mètodes de QueueInt.
 *
 * @author PRG
 * @version Curs 2019/20
 */
public class TestQueueInt {
    private TestQueueInt() { }
    
    public static void main(String[] args) {
        //1. Crea una cua buida ...
        // 1a. Representada sobre un array
        // QueueIntArray q = new QueueIntArray();
        // 1b. Com una llista enllaçada
        QueueIntLinked q = new QueueIntLinked();
        
        //2. Encuar els valors 1, 3, 5, 8, 10, 15,
        // mostrant en cada pas l'estat de la cua
        int[] dades = {1, 3, 5, 8, 10, 15};
        System.out.println("Encuant...");
        for (int i = 0; i < dades.length; i++) {
            q.add(dades[i]); 
            System.out.println(q);
        }        
        
        //3. Mostra per pantalla la dada en cap de la cua
        System.out.println("\nCap de la cua: " + q.element());
        
        //4. Desencua dada a dada, mostrant en cada pas l'estat de la cua
        System.out.println("\nDesencuant...");
        while (!q.empty()) {
            int e = q.remove();
            System.out.println(q);
        }
        
        System.out.println("Fi del procés");
    }
    
    // Quan hages acabat, crea la cua buida però...
    // 1b. Com una llista enllaçada
    // Observa que la resta del codi que has escrit en els passos 2 a 5
    // segueix sent correcte per aquesta representació.
    // Això és així perque els perfils i funcionalitats dels mètodes
    // són els mateixos.
}
