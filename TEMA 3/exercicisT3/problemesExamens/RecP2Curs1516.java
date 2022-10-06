package problemesExamens;

/**
 * Classe RecP2Curs1516: exercici sobre excepcions de la recuperació del parcial 2 del curs 2015/16.
 * Es disposa d'un array lS d'objectes de tipus String, que representen valors en coma flotant.
 * Si l'array està correctament format, açó és, si cadascun dels seus elements és una String que 
 * conté la representació d'un double en Java, aleshores, el metode m1 escriu correctament el contingut 
 * de l'array.
 * No obstant aixó, si alguna de les String de l'array no existeix, o conté un valor que no representa un double,
 * es podran produir, respectivament, les excepcions: NullPointerException o NumberFormatException.
 * En aquest cas, en realitat, es desitjaria una sortida sense excepcions. Per exemple, com la que es mostra, a
 * continuació, per a l'array: {"1234.0", "1.23456789E8", null, "123xx9", null, ""}.
 * Pos: 0: Valor: 1234.0
 * Pos: 1: Valor: 1.23456789E8
 * Pos: 2: String inexistent.
 * Pos: 3: Nombre mal format.
 * Pos: 4: String inexistent.
 * Pos: 5: String de longitud zero.
 * 
 * Es demana: reescriure el mètode m1 perqué, tractant exclusivament les dues excepcions indicades, resolga
 * el problema efectuant una sortida com la mostrada en l'exemple.
 * 
 * @author PRG
 * @version Curs 2019/20
 */
public class RecP2Curs1516 {
    private RecP2Curs1516() { }
    
    public static void main(String[] args) {
        String[] s = {"1234.0", "1.23456789E8", null, "123xx9", null, ""};
        m1(s);
    }
    
    public static void m1(String[] lS) {
        for (int i = 0; i < lS.length; i++) {
            System.out.print("Pos: " + i + ": ");
            if (lS[i].length() > 0) {
                double valor = Double.parseDouble(lS[i]);
                System.out.println("Valor: " + valor);
            }
            else { System.out.println("String de longitud zero."); }
        }
    }
}
