package linear;

/**
 * Classe UtilLinked: classe d'utilitats que conté operacions amb
 * seqüències enllaçades.
 * 
 * @author PRG 
 * @version Curs 2019/20
 */
public class UtilLinked {
    
    /** No hi ha objectes d'aquesta classe. */ 
    private UtilLinked() { }
    
    /**
     * Satura les dades d'una seqüència donada a un valor màxim.
     * @param seq NodeInt seqüència origen.
     * @param max int a saturar. 
     */
    public static void saturar(NodeInt seq, int max) {
        NodeInt aux = seq; 
        while (aux != null) { 
            if (aux.data > max) { aux.data = max; }
            aux = aux.next; 
        }
    }
            
    /**
     * Torna el màxim d'una seqüència donada amb, al menys, un node.
     * @param seq NodeInt seqüència original.
     * @return int valor màxim de la seqüència.
     */
    public static int maxim(NodeInt seq) {
        int max = seq.data;
        NodeInt aux = seq.next;
        while (aux != null) {
            if (aux.data > max) { max = aux.data; }
            aux = aux.next;
        }
        return max;
    }
    
    /** Torna el nombre d'elements de la seqüència seq.
     *  @param seq NodeInt seqüència origen.
     *  @return int nombre d'elements de seq.
     */
    public static int talla(NodeInt seq) {
        int cont = 0;
        NodeInt aux = seq;
        while (aux != null) { 
            aux = aux.next;
            cont++;
        }
        return cont;
    }
    
    /** Torna en un array del tamany just els elements de la seqüència seq.
     *  @param seq NodeInt seqüència origen.
     *  @return int[] array amb els elements de seq.
     */
    public static int[] toArray(NodeInt seq) {
        int[] res = new int[talla(seq)];
        int i = 0;
        NodeInt aux = seq;
        while (aux != null) { 
            res[i]= aux.data;
            i++;
            aux = aux.next;
        }
        return res;
    }
    
    /** Donada una seqüència enllaçada d'enters, torna un 
     *  String amb les seues dades. En l'String cada dada està separada 
     *  de la següent per un espai en blanc.
     *  @param seq NodeInt que representa una seqüència enllaçada d'enters.
     *  @return String.
     */
    public static String toString(NodeInt seq) {
        NodeInt aux = seq;
        String res = "";
        while (aux != null) {
            res += aux.data + " ";
            aux = aux.next;
        }        
        return res;
    }    
    
    /**
     * Torna el primer node d'una seqüencia donada seq que conté el valor d.
     * @param seq NodeInt seqüència origen.
     * @param d int a buscar. 
     * @return NodeInt referència al node que conté el valor d 
     *     o null si cap node conté a d.
     */ 
    public static NodeInt cercarDada(NodeInt seq, int d) {
        // Cerca del primer node amb dada d
        NodeInt aux = seq;
        while (aux != null && aux.data != d) { 
            aux = aux.next; 
        }
        // Si la cerca acaba amb èxit torna el node que conté a d, 
        // si no, torna null
        return aux;
    }
    
    /** 
     * Canvia el signe de la primera ocurrència de d en una seqüència
     * donada seq. Si d no apareix, el mètode no fa res.   
     * @param seq NodeInt seqüència origen.
     * @param d int a buscar.
     */
    public static void canviarSigne(NodeInt seq, int d) {
        // Cerca del primer node amb dada d
        NodeInt aux = seq;
        while (aux != null && aux.data != d) { 
            aux = aux.next; 
        }
        // Si la cerca acaba amb èxit, es canvia 
        // el signe de la dada
        if (aux != null) { aux.data = -d; }
    }

    /**
     * Torna la posició de la primera ocurrència d'un valor d en 
     * una seqüència donada seq.
     * @param seq NodeInt seqüència origen.
     * @param d int a buscar. 
     * @return int posició que ocupa d en la seqüència o -1 si no està.
     */
    public static int cercarPos(NodeInt seq, int d) {
        int cont = 0;
        NodeInt aux = seq;
        while (aux != null && aux.data != d) { 
            aux = aux.next;
            cont++;
        }
        if (aux != null) { return cont; } 
        // Ha de ser eixa condició i no val aux.data == d
        // Per comprovar que encara tenim seq
        else { return -1; }
    }
    
    /**
     * Donada una seqüència, insereix la dada d en la posició i>=0.
     * Si l’índex sobrepassa la longitud de la seqüència, la inserció 
     * no es fa.
     * @param seq NodeInt seqüència origen.
     * @param d int a inserir. 
     * @param i int posició on inserir, 0<=i.
     * @return NodeInt seqüència resultat.
     */
    public static NodeInt insert(NodeInt seq, int d, int i) {
        if (i == 0) { seq = new NodeInt(d, seq); }
        else { 
            NodeInt aux = seq; 
            int k = 0;
            while (aux != null && k < i - 1) {
                aux = aux.next; 
                k++;
            }
            if (aux != null) { // Èxit en la cerca 
                aux.next = new NodeInt(d, aux.next);
            }
        }    
        return seq;
    }    
    
    /**
     * Donada una seqüència tal que les seues dades estan ordenades 
     * de menor a major, insereix la dada d mantenint l'ordenació.
     * @param seq NodeInt seqüència origen.
     * @param d int a inserir. 
     * @return NodeInt seqüència resultat.
     */
    public static NodeInt insertSort(NodeInt seq, int d) {
        NodeInt aux = seq, ant = null; // el primer node no té 
                                       // anterior definit 
        while (aux != null && aux.data < d) { 
            ant = aux; 
            aux = aux.next; 
        } 
        
        // Acabada la cerca: 
        // Cas a) aux==seq, seq està buida o 
        //        totes les seues dades són >=d. 
        // Cas b) aux!=seq (o ant!=null), 
        //        no totes les seues dades són >=d. 
        // La inserció darrere de ant situa el nou node 
        // a continuació de totes les dades <d.
        if (aux == seq) { seq = new NodeInt(d, seq); } // Cas a) 
        else { ant.next = new NodeInt(d, aux); } // Cas b)
        return seq;
    }        
    
    /**
     * Donada una seqüència enllaçada, esborra, si existeix, la primera 
     * ocurrencia d'una dada d. Si aquest element no apareix, no es fa res.
     * @param seq NodeInt seqüència origen.
     * @param d int a esborrar. 
     * @return NodeInt seqüència resultat.
     */
    public static NodeInt delete(NodeInt seq, int d) {
        NodeInt aux = seq, ant = null;
        while (aux != null && aux.data != d) {
            ant = aux;
            aux = aux.next;
        }
        if (aux != null) { // Èxit en la cerca
            if (ant == null) { // o aux == seq -aux és el primer node-
                seq = aux.next;
            }
            else { ant.next = aux.next; }
        }
        // El paràmetre seq pot haver canviat, 
        // cal tornar el seu valor:
        return seq;
    }
    
    /**
     * Donada una seqüència enllaçada, esborra els elements menors 
     * que un umbral donat. 
     * @param seq NodeInt seqüència origen.
     * @param limit int a comparar. 
     * @return NodeInt seqüència resultat.
     */
    public static NodeInt deleteUnder(NodeInt seq, int limit) { 
        NodeInt aux = seq, ant = null; 
        while (aux != null) { 
            if (aux.data < limit) { // node a esborrar 
                if (aux == seq) { seq = seq.next; }
                else { ant.next = aux.next; }
                // ant no s’actualitza 
            } 
            else { ant = aux; }
            aux = aux.next; 
        } 
        // El paràmetre seq pot haver canviat, 
        // cal tornar el seu valor: 
        return seq;
    }
    
    /** Torna en una seqüència els elements d'un array a.
     *  @param a array d'enters seqüència origen.
     *  @return NodeInt seqüència amb els elements de l'array a.
     */
    public static NodeInt toSeq(int[] a) {
        NodeInt seq = null, aux = null; 
        // aux marca l'últim element de la seq
        // darrere de la que inserir el seguent element
        // Métode ascendent
        for (int i = 0; i < a.length; i++) {
            if (seq == null) { 
                seq = new NodeInt(a[i]);
                aux = seq;
            } else {
                aux.next = new NodeInt(a[i]);
                aux = aux.next;
            }
        }
        
        // Métode descendent
        for (int i = a.length - 1; i >= 0; i--) {
            seq = new NodeInt(a[i], seq);
        }
        return seq;
    }
    
    /**
     * Inverteix l'ordre dels elements d'una seqüència donada 
     * (amb cost lineal).
     * @param seq NodeInt seqüència a invertir.
     * @return NodeInt seqüència invertida.
     */
    public static NodeInt invertir(NodeInt seq) {
        NodeInt aux = seq, nova = null;
        while (aux != null) {
            nova = new NodeInt(aux.data, nova);
            aux = aux.next;
        }
        seq = nova;
        return seq;
    }
    
    /** 
     * Torna una seqüència enllaçada amb els elements menors que e,
     * i en el mateix ordre que apareixen en una seqüència donada seq.
     * El cost serà lineal amb la longitud de seq.
     * @param seq NodeInt seqüència origen.
     * @param e int a comparar.
     * @return NodeInt seqüència enllaçada amb els elements menors que e, 
     *         en el mateix ordre que apareixen en la seqüència original.
     */ 
    public static NodeInt menorsQue(NodeInt seq, int e) {
        NodeInt aux = seq, nova = null, ultim = null;
        while (aux != null) {
            if (aux.data < e) {
                if (nova == null) {
                    nova = new NodeInt(aux.data);
                    ultim = nova;
                } else {
                    ultim.next = new NodeInt(aux.data);
                    ultim = ultim.next;
                }
                aux = aux.next;
            }
        }
        return nova;
    }
}
