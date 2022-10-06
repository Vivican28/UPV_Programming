package linear;

/**
 * Classe per a provar els mètodes de StackInt.
 *
 * @author PRG
 * @version Curs 2019/20
 */
public class TestStackInt {
    private TestStackInt() { }
    
    public static void main(String[] args) {
        //1. Crea una pila buida ...
        //1a. Representada sobre un array
        // StackIntArray p = new StackIntArray(); 
        //Mateix resultat amb mateixes operacions
        // 1b. Com una llista enllaçada
        StackIntLinked p = new StackIntLinked();
        
        //2. Empilar els valors 15, 10, 8, 5, 3, 1
        System.out.println("Empilant...");
        p.push(15); p.push(10);
        p.push(8); p.push(5);
        p.push(3); p.push(1);
        
        
        //3. Mostra per pantalla l'estat de la pila
        System.out.println(p);
        
        //4. Mostra per pantalla la dada del cim de la pila
        System.out.println("Cim: " + p.peek());
        
        //5. Desempila dada a dada, mostrant en cada pas l'estat de la pila
        System.out.println("\nDesempilant...");
        while (!p.empty()) {
            // desempilar
            int e = p.pop();
            System.out.println(p);
        }
        
        System.out.println("Fi del procés");
    }
    
    // Quan hages acabat, crea la pila buida però...
    // 1b. Com una llista enllaçada
    // Observa que la resta del codi que has escrit en els passos 2 a 5
    // segueix sent correcte per aquesta representació.
    // Això és així perque els perfils i funcionalitats dels mètodes
    // són els mateixos.
}
