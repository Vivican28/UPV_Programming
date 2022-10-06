package problemesExamens;

/**
 * Classe P2Curs1516: exercici sobre excepcions del parcial 2 del curs 2015/16.
 * Es disposa d'un array lS d'objectes de tipus String, tal que no té inicialitzats 
 * tots els seus elements (és a dir, alguna de les posicions de l'array conté un valor
 * null en lloc d'una String ben formada). Si s'utilitza el mètode m1 per imprimir la 
 * longitud de totes les String realment existents de lS es poden produir les excepcions: 
 * NullPointerException i ArrayIndexOutOfBoundsException. Quan, en realitat, es desitjaria 
 * una sortida sense excepcions. Com, per exemple, amb un array de 6 elements:
 * Posició 0: 4 caràcters
 * Posició 1: 9 caràcters
 * Posició 2: String no inicialitzada
 * Posició 3: 11 caràcters
 * Posició 4: String no inicialitzada
 * Posició 5: 0 caràcters
 * Posició 6: Inexistent. Fi de l'array
 * 
 * Es demana: reescriure el mètode m1 perqué, tractant exclusivament les dues excepcions 
 * indicades (sense fer ús de l'atribut length de l'array ni de la constant null), resolga 
 * el problema demanat efectuant una sortida com la mostrada en l'exemple.
 * 
 * @author PRG
 * @version Curs 2019/20
 */
public class P2Curs1516 {    
    private P2Curs1516() { }
    
    public static void main(String[] args) {
        String[] s = {"hola", "posicions", null, "inicialitza", null, ""};
        m1(s);
    }

    public static void m1(String[] lS) {
        int k = 0;
        boolean fi = false;
        while (!fi) {
            System.out.print("Posicio " + k + ": ");
            System.out.println(lS[k].length() + " caràcters");
            k++;
        }
    }
}
