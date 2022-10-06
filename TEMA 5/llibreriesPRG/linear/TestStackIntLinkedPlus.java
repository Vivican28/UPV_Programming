package linear;
/**
 * Classe per a provar els mètodes de StackIntLinkedPlus.
 *
 * @author PRG
 * @version Curs 2019/20
 */
public class TestStackIntLinkedPlus {
    private TestStackIntLinkedPlus() { }
    
    public static void main(String[] args) {
        //1. Crea una pila plus com una llista enllaçada
        //   amb els valors 2, 7 i 5
        int[] dades = {2, 7, 5};
        StackIntLinkedPlus p = creaPila(dades);
        
        //2. Mostra per pantalla l'estat de la pila
        //   i el seu cim
        System.out.println(p.toString());
        System.out.println("Cim = " + p.peek());
        
        //3. Empila el 9 en la base de la pila
        System.out.println("\nAfegeix el 9 en la base de la pila. ");
        p.insertBaseRec(9);
        System.out.println(p.toString());
        System.out.println("Cim = " + p.peek());
        
        //4. Empila el 8 en la base de la pila
        System.out.println("\nAfegeix el 8 en la base de la pila. ");
        p.insertBaseRec(8);     
        System.out.println(p.toString());
        System.out.println("Cim = " + p.peek() + "\n");   
        
        //5. Crea tres piles: 
        // pA = [9, 5, 7, 2], pB =[9, 5] i pC = [2, 1]
        int[] dadesA = {2, 7, 5, 9};
        StackIntLinkedPlus pA = creaPila(dadesA);
        int[] dadesB = {5, 9};
        StackIntLinkedPlus pB = creaPila(dadesB);
        int[] dadesC = {1, 2};
        StackIntLinkedPlus pC = creaPila(dadesC);
        System.out.println("pA \n" + pA.toString());
        System.out.println("pB \n" + pB.toString());
        System.out.println("pC \n" + pC.toString());
        // i comprova si pB i pC són sombreros de pA
        System.out.println("Comprova si pB és sombrero de pA: " + pA.esSombrero(pB));
        System.out.println("Comprova si pC és sombrero de pA: " + pA.esSombrero(pC));
        
        //6. Crea la pila pD = [9, 5, 7, 2], esborra la seua base i 
        //   escriu el cim i la pila
        int[] datosD = {2, 7, 5, 9};
        StackIntLinkedPlus pD = creaPila(datosD);
        System.out.println("pD \n" + pD.toString());
        System.out.println("Cim = " + pD.peek() + "\n"); 
        pD.esborrarBase();
        System.out.println("Despres d'esborrar la seua base:");
        System.out.println("pD \n" + pD.toString());
        System.out.println("Cim = " + pD.peek() + "\n"); 
        
        //7. Suma les dades de la pila que queda
        System.out.println("Sumant les dades...");
        System.out.println("Suma = " + pD.sumarPila());
        
        //8. Canvia de signe les dades de la pila
        System.out.println("\nCanviant de signe les dades...");
        pD.canviarSigne();
        System.out.println(pD.toString());
        
        System.out.println("Fi del procés");        
    }
    
    // Crea una Pila Plus (StackIntLinkedPlus) en la que en la pila buida 
    // s'han empilat les dades de l'array d en el ordre d0, d1, ...
    private static StackIntLinkedPlus creaPila(int[] d) {
        StackIntLinkedPlus p = new StackIntLinkedPlus();
        for (int i = 0; i < d.length; i++) {
            p.push(d[i]);
        }
        return p;
    }        
}
