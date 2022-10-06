package linear;

/**
 * Classe per a provar els mètodes de ListPIInt.
 *
 * @author PRG
 * @version Curs 2019/20
 */
public class TestListPIInt {
    private TestListPIInt() { } 
    
    public static void main(String[] args) {
        //1. Definir una llista amb els 10 primers números senars
        // i mostrar-la per pantalla
        // 1a. Representada sobre un array
        //ListPIIntArray lpi = new ListPIIntArray();
        // 1b. Com una llista enllaçada
        ListPIIntLinked lpi = new ListPIIntLinked();
        System.out.println("Llista: " + lpi.toString());
        System.out.println("Inserint...");
        for (int i = 1; i <= 10; i++) {
            lpi.insert(2 * i - 1);
        }
        System.out.println("Llista: " + lpi.toString());

        //2. Mostrar per pantalla la primera dada de lpi:
        lpi.begin();
        int d = lpi.get();
        System.out.println("\nLa primera dada és... " + d);
        //3. Mostrar per pantalla totes les dades de lpi:
        System.out.println("Llista: " + lpi.toString());
        
        //4. Mostrar per pantalla la tercera dada de lpi:
        lpi.begin();
        lpi.next(); lpi.next(); 
        d = lpi.get();
        System.out.println("\nLa tercera dada és... " + d);
        //5. Mostrar per pantalla totes les dades de lpi:
        System.out.println("Llista: " + lpi.toString());
        
        //6. Esborrar la tercera dada de lpi:
        d = lpi.remove();
        System.out.println("\nEsborrat... " + d);
        //7. Mostrar per pantalla totes les dades de lpi:
        System.out.println("Llista: " + lpi.toString());
    }
    
    // Creant la llista amb PI com una llista enllaçada o com un array,
    // observa que el codi que has escrit en els passos 2 a 6
    // és correcte per a les dues representacions.
    // Això és així perque els perfils i funcionalitats dels mètodes
    // són els mateixos.
}
