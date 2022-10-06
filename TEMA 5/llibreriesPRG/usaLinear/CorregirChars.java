package usaLinear;

import linear.ListPIIntLinked;
/**
 * Programa per a veure exemples d'intercanvi de ñ per ny 
 * i viceversa
 *
 * @author PRG
 * @version Curs 2019/20
 */
public class CorregirChars {
    private CorregirChars() { }

    public static void main(String[] args) {
        // Crea una llista amb PI amb els caràcters del String dades, 
        // aprofitant que en Java un char és compatible amb el tipus int
        String dades = "caña,anna,parañ";
        ListPIIntLinked lpi = new ListPIIntLinked();
        for (int i = 0; i < dades.length(); i++) {
            lpi.insert(dades.charAt(i));
        }
        System.out.println(toStringChar(lpi));
        System.out.println("Després de substituir ñ per ny...");
        corregirCV(lpi);
        System.out.println(toStringChar(lpi));

        System.out.println("Després de substituir ny per ñ...");
        corregirVC(lpi);
        System.out.println(toStringChar(lpi));
    }

    /** Torna el String que resulta d'interpretar els int de 
     *  la llista amb PI l com caràcters 
     */
    private static String toStringChar(ListPIIntLinked l) {
        String res = "";
        l.begin();
        while (!l.isEnd()) {
            res += (char) l.get(); 
            l.next();
        }
        return res;
    }

    /** Substitueix en la llista l totes les aparicions del
     *  int corresponent al char ñ per la parella ny 
     */
    private static void corregirCV(ListPIIntLinked l) {
        l.begin();
        while (!l.isEnd()) {
            if ((char) l.get() == 'ñ') {
                l.remove();
                l.insert('n');
                l.insert('y');
            } else l.next();
        }
    }

    /** Substitueix en la llista l totes les aparicions de la
     *  parella ny per ñ
     */
    private static void corregirVC(ListPIIntLinked l) {
        l.begin();
        while (!l.isEnd()) {
            if ((char) l.get() == 'n') {
                l.remove();
                if(!l.isEnd()) {
                    if ((char) l.get() == 'y') {
                        l.remove();
                        l.insert('ñ');
                    } else l.insert('n');
                }
            } else l.next();
        }
    }
}
