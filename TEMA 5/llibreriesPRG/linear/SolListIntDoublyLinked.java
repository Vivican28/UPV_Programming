package linear;
/**
 * Classe ListIntDoublyLinked: implementació d'una llista doblement
 * enllaçada, de manera que cada node té una referència tant al node
 * següent com al node anterior.
 * 
 * @author PRG - Activitat de reforç
 * @version Curs 2019/20
 */
public class SolListIntDoublyLinked {
    private NodeIntDouble first, last; // referències al primer i últim nodes
    private int size;                  // número d'elements de la llista

    /** Crea una llista buida. */
    public SolListIntDoublyLinked() {
        first = last = null;
        size = 0;
    }

    /** Insereix un nou node amb l'element x en el cap de la llista,
     *  és a dir, el nou node serà el primer de la llista.
     *  @param x int a afegir en la llista.
     */
    public void inserir(int x) {
        NodeIntDouble nou = null;
        if (size == 0) { 
            nou = new NodeIntDouble(x, null, null); 
            last = nou;
        }
        else {  
            nou = new NodeIntDouble(x, first, null);
            first.prev = nou;
        }
        first = nou;
        size++;
    }

    /** Insereix un nou node amb l'element x al final de la llista,
     *  és a dir, el nou node serà l'últim de la llista.
     *  @param x int a afegir en la llista.
     */
    public void inserirFi(int x) {
        NodeIntDouble nou = null;
        if (size == 0) {
            nou = new NodeIntDouble(x, null, null);
            first = nou;
        }
        else {
            nou = new NodeIntDouble(x, null, last);
            last.next = nou;
        }
        last = nou;
        size++;
    }

    /** Esborra, si existeix, el primer node de la llista. */
    public void esborrarIni() {
        if (size > 0) {
            if (size == 1) {
                first = null;
                last = null;
            }
            else {
                first = first.next;
                first.prev = null;
            }
            size--;
        }
    }
    
    /** Esborra, si existeix, el darrer node de la llista. */
    public void esborrarFi() {
        if (size > 0) {
            if (size == 1) {
                first = null;
                last = null;
            }   
            else {
                last = last.prev;
                last.next = null;
            }
            size--;
        }
    }  
    
    /** Esborra, si existeix, la primera ocurrència d'una
     *  dada donada. Si no existeix, no fa res.
     *  @param x int a esborrar de la llista.
     */
    public void esborrar(int x) { 
        NodeIntDouble aux = this.first, ant = null;
        while (aux != null && aux.data != x) {
            ant = aux;
            aux = aux.next;
        }
        if (aux != null) {
            if (size == 1) {
                last = null;
                first = null;
            }
            else if (aux == this.first) {
                first = aux.next;
                aux.next.prev = ant;
            }
            else if (aux == this.last) {
                ant.next = null;
                last = ant;
            }
            else {
                ant.next = aux.next;
                aux.next.prev = ant;
            }
            size--;
        }
    }  
    
    /** Obté un String amb totes les dades de la llista en
     *  sentit ascendent (des del primer node fins l'últim).
     *  Si la llista està buida, torna la cadena buida.
     *  Exemple: si les dades son 2, 15 i 8, el String 
     *  resultat sera "2 15 8 "
     *  @return String, resultat.
     */
    public String toString() {
        String str = "";
        NodeIntDouble aux = this.first;
        while (aux != null) {
            str += aux.data + " "; 
            aux = aux.next;
        }
        return str;
    }

    /** Obté un String amb totes les dades de la llista en
     *  sentit descendent (des de l'últim node fins el primer).
     *  Si la llista està buida, torna la cadena buida.
     *  Exemple: si les dades son 2, 15 i 8, el String 
     *  resultat sera "8 15 2 "
     *  @return String, resultat.
     */
    public String toStringDescendent() {
        String str = "";
        NodeIntDouble aux = last;
        while (aux != null) {
            str += aux.data + " ";
            aux = aux.prev;
        }
        return str;
    }   
    
}