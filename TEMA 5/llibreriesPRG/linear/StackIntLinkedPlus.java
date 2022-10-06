package linear;

/**
 * Classe que afegeix funcionalitat a StackIntLinked.
 *
 * @author PRG
 * @version Curs 2019/20
 */
public class StackIntLinkedPlus extends StackIntLinked {    
    /**
     * Crea una StackIntLinkedPlus buida
     */    
    public StackIntLinkedPlus() { super(); }

    /**
     * Afegeix la dada d en la base de la pila, deixant la resta
     * d'elements ordenats com estaven inicialment.
     * Versió iterativa.
     * @param d int dada a afegir en la base
     */
    public void insertBaseIter(int d) {
        StackIntLinked aux = new StackIntLinked();
        while (!this.empty())  aux.push(this.pop()); 
        this.push(d);
        while (!aux.empty())  this.push(aux.pop()); 
    }
    
    /**
     * Afegeix la dada d en la base de la pila, deixant la resta
     * d'elements ordenats com estaven inicialment.
     * Versió recursiva.
     * @param d int dada a afegir en la base
     */
    public void insertBaseRec(int d) { // Métode recursiu
        if (this.empty()) { this.push(d); }
        else {
            int x = this.pop();
            this.insertBaseRec(d);
            this.push(x);
        }
    }
    
    /** 
     * Comprova si una pila p es sombrero de la actual,
     * és a dir, si els elements de p apareixen en la part
     * de dalt de this i empilats en el mateix ordre.
     * Precondició: p.size() <= this.size().
     */
    public boolean esSombrero(StackIntLinked p) {
        if (!p.empty()) {
            if (p.peek() == this.peek()) {
                int e1 = p.pop(), e2 = this.pop(); 
                // Es necessari guardar-se els valors per a que
                // la pila es quede igual al finalitzar el métode 
                boolean result = this.esSombrero(p); 
                // Com amb el pop hem desempilat, "s'ha avancat" 
                // en la pila per a fer la nova crida recursiva
                p.push(e1); this.push(e2); // Tornem a empilar per que quede igual
                return result;        
            } else return false;
        } else return true;
    }
    
    /** 
     * Esborra la dada de la base de la pila actual, deixant 
     * la resta d'elements ordenats com estaven inicialment.
     * Si la pila està buida no fa res.
     */
    public void esborrarBase() {
        if (!this.empty()) {
            int e = this.pop();
            if (this.size() > 0) {
                this.esborrarBase();
                this.push(e);
            }
        }
    }
    
    /** 
     * Suma les dades de la pila actual
     */
    public int sumarPila() {
        if (this.empty()) return 0;
        else {
            int e = this.pop();
            int sum = this.sumarPila();
            this.push(e);
            return sum + e;
        }
    }
    
    /** 
     * Canvia el signe de les dades de la pila actual
     */
    public void canviarSigne() {
        if (!this.empty()) {
            int e = this.pop();
            this.canviarSigne();
            this.push(-e);
        }
    }
}
