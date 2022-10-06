package linear;

/**
 * Classe per a provar els mètodes de ListIntLinkedPlus.
 *
 * @author PRG
 * @version Curs 2019/20
 */
public class TestListPIIntLinkedPlus {
    private TestListPIIntLinkedPlus() { }
    
    public static void main(String[] args) {
        //1. Crea una llista amb pi plus amb els 10 primers senars
        ListPIIntLinkedPlus lpi = new ListPIIntLinkedPlus();
        for (int i = 1; i <= 10; i++) {
            lpi.insert(2 * i - 1);
        }
        
        //2. Mostra per pantalla la llista amb pi plus
        System.out.println("Llista amb els 10 primers senars: ");
        System.out.println(lpi.toString());
        
        //3. Busca en la llista amb pi plus les dades 101 i 15
        boolean esta101 = lpi.search(101);
        System.out.println("\nEl 101 està? " + esta101);
        System.out.println(lpi.toString()); 
        boolean esta15 = lpi.search(15);
        System.out.println("\nEl 15 està? " + esta15);
        System.out.println(lpi.toString());        
        
        //4. El punt d'interés de la llista està sobre el 15
        // situa'l en l'anterior
        System.out.println("\nMoure el punt d'interés a l'anterior.");
        lpi.anterior();
        System.out.println(lpi.toString()); 
        
        //5. Esborra de la llista amb pi la dada 17
        // i mostra la llista per pantalla
        System.out.println("\nEsborrant el valor 17. ");
        lpi.delete(17);
        System.out.println(lpi.toString()); 
        
        //6. Insereix de forma ordenada les dades 0, 8 i 100
        // i mostra la llista per pantalla
        System.out.println("\nInserint ordenadament 0, 8 i 100. ");
        lpi.insertSort(0);
        System.out.println(lpi.toString()); 
        lpi.insertSort(8);
        System.out.println(lpi.toString()); 
        lpi.insertSort(100);
        System.out.println(lpi.toString()); 
        
        //7. Crea la llista lpi2 amb les dades 5 5 5 1 5 2 4 6 5 5
        //Esborra totes les aparicions del 5 i mostra la llista resultant
        int[] dades = {5, 5, 5, 1, 5, 2, 4, 6, 5, 5};
        ListPIIntLinkedPlus lpi2 = new ListPIIntLinkedPlus();
        for (int i = 0; i < dades.length; i++) {
            lpi2.insert(dades[i]);
        }
        System.out.println("\nlpi2:\n" + lpi2.toString());
        System.out.println("Esborrant totes les aparicions del 5.");
        lpi2.removeAll(5);
        System.out.println(lpi2.toString());
        
        //8. Triplica tots els elements de lpi2
        System.out.println("\nTriplicant... ");
        lpi2.triplicar();
        System.out.println(lpi2.toString());
        
        //9. Inverteix tots els elements de lpi2
        System.out.println("\nInvertint... ");
        lpi2.begin();
        lpi2.invertir();
        System.out.println(lpi2.toString());
        
        System.out.println("\nFi del procés");        
    }        
}