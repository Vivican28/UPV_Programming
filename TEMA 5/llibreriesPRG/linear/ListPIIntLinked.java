package linear;

import java.util.NoSuchElementException;
/**
 * ListPIIntLinked: Implementació enllaçada de l'estructura de dades 
 * lineal Llista amb punt d'interès d'enters.
 * 
 * @author PRG
 * @version Curs 2019/20
 */
public class ListPIIntLinked {    
    private NodeInt first, pI, prevPI; // referències al first, al PI 
    // i a l'anterior de la llista   
    private int size;       // número d'elements de la llista

    /**
     * Crea una llista buida.
     */
    public ListPIIntLinked() {
        first = null;
        pI = null;
        prevPI = null;
        size = 0;
    }

    /**
     * Comprova si la llista actual està o no buida.
     * @return boolean, true si la llista està buida i false en cas contrari.
     */
    public boolean empty() { 
        return size == 0;   // Alternativament: return first == null;
    }

    /**
     * Comprova si el punt d'interès està al final de la llista actual.
     * @return boolean, true si el PI està al final de la llista i false 
     * en cas contrari.
     */
    public boolean isEnd() { return pI == null; }

    /**
     * Torna el número d'elements de la llista actual.
     * @return int, número d'elements de la llista actual.
     */
    public int size() { return size; }      

    /**
     * Situa el punt d'interès en la primera posició de la llista actual.
     */
    public void begin() { 
        pI = first; 
        prevPI = null; 
    }

    /**
     * Desplaça el PI una posició cap a la dreta. 
     * @throws NoSuchElementException si el PI es troba al final de la llista.
     */
    public void next() { 
        if (pI == null) { 
            throw new NoSuchElementException("Point of interest at the end");
        }
        prevPI = pI; 
        pI = pI.next;
    }

    /**
     * Torna l'element en el PI. 
     * @throws NoSuchElementException si el PI es troba al final de la llista.
     * @return int, element en el PI de la llista.
     */
    public int get() { 
        if (pI == null) { 
            throw new NoSuchElementException("Point of interest at the end");
        }
        return pI.data; 
    }   

    /**
     * Insereix un nou node amb l'element x en la posició anterior al PI. 
     * Si el cursor està a l’inici, el nou node serà el first de la 
     * llista. En qualsevol altre cas, el nou node s’insereix entre el 
     * node cursor i el seu node predecessor.
     * @param x, element a afegir en la llista.
     */
    public void insert(int x) {
        if (pI == first) { 
            first = new NodeInt(x, pI); 
            prevPI = first; 
        } 
        else { 
            prevPI.next = new NodeInt(x, pI); 
            prevPI = prevPI.next; 
        } 
        size++;
    }

    /**
     * Torna i elimina de la llista l'element en el PI. 
     * Si el cursor està a l’inici, first s’actualitza al seu node 
     * següent. En qualevol altre cas, els nodes anterior i posterior 
     * al node cursor queden enllaçats.
     * @throws NoSuchElementException si el PI es troba al final de la llista.
     * @return int, element en el PI de la llista.
     */
    public int remove() {
        if (pI == null) { 
            throw new NoSuchElementException("Point of interest at the end");
        }
        int x = pI.data; 
        if (pI == first) { first = first.next; }
        else { prevPI.next = pI.next; }
        pI = pI.next; 
        size--; 
        return x;
    }

    /**
     * Comprova si la llista actual és igual o no a una llista donada.
     * Dues llistes són iguals si són iguals tots els seus elements 
     * i en el mateix ordre.
     * @param o Object que representa la llista a comparar.
     * @return boolean, true si són iguals i false en cas contrari.
     */
    public boolean equals(Object o) {
        boolean answer = false;
        if (o instanceof ListPIIntLinked) {
            ListPIIntLinked other = (ListPIIntLinked) o;
            NodeInt b = other.first;
            NodeInt a = this.first;
            answer = (this.size == other.size);
            while (a != null && answer) {
                answer = (a.data == b.data);
                a = a.next; b = b.next;
            }       
        }
        return answer;
    }

    /**
     * Torna un String amb els elements de la llista actual.
     * @return String amb les dades de la llista.
     */     
    public String toString() {
        String s = "";
        NodeInt p = first;
        while (p != null) {
            if (p == pI)   { s += " [" + p.data + "]"; }
            else           { s += " " + p.data; }
            p = p.next;           
        }
        if (pI == null) { s += " []"; }
        return s;
    }

    /*************** MÈTODES DELS EXEMPLES i EXERCICIS ******************************/   
    /**
     * Mètode privat auxiliar que busca la primera ocurrència de x 
     * des del node aux en endavant; si el troba, mou el PI al node 
     * que conté a x. Si no apareix, el PI no es mou.
     * @param aux NodeInt a partir del qual es fa la cerca
     * @param x int a buscar
     * @return boolean true si el troba i false en cas contrari.
     */
    private boolean search(NodeInt aux, int x) { 
        NodeInt ant = null;
        if (aux == this.pI) { ant = this.prevPI; }
        while (aux != null && aux.data != x) {
            ant = aux;
            aux = aux.next;
        }
        boolean res = false;
        if (aux != null) {
            this.pI = aux;
            this.prevPI = ant;
            res = true;
        }
        return res;
    } 

    /**
     * Busca la primera ocurrència de x des del primer node de la llista; 
     * si el troba, mou el PI al node que conté a x. Si no apareix, el PI 
     * no es mou.
     * @param x int a buscar
     * @return boolean true si el troba i false en cas contrari.
     */
    public boolean search(int x) { return search(first, x); } 

    /**
     * Busca la primera ocurrència de x des del node del PI (inclusivament) 
     * de la llista; si el troba, mou el PI al node que conté a x. Si no 
     * apareix, el PI no es mou.
     * @param x int a buscar
     * @return boolean true si el troba i false en cas contrari.
     */
    public boolean searchFromPI(int x) { return search(pI, x); }

    /**
     * Canvia el punt d'interés a la posició anterior a l'actual
     * en la llista. L'operació no està definida si el punt
     * d'interés està sobre el primer element de la llista.
     * Precondició: PI != first
     */
    public void anterior() {
        NodeInt aux = first, ant = null;
        /* COMPLETAR bucle per a situar aux en prevPI */
        while (aux != this.prevPI) ant = aux; aux = aux.next;
        // quan acaba el bucle, aux és prevPI i ant és l'anterior
        /* COMPLETAR actualitzar pI i prevPI */
        pI = aux; prevPI = ant;
    }

    /**
     * Esborra de la llista totes les aparicions de la dada x 
     * i deixa el punt d'interés al final del tot.
     * @param x int valor a esborrar
     */
    public void removeAll(int x) {
        // s'usen pI i prevPI per anar visitant els nodes 
        pI = first; prevPI = null;
        while (pI != null) {
            if (pI.data == x) {
                if (pI == first) {
                    first = pI.next;
                } else {
                    prevPI.next = pI.next;
                }
                pI = pI.next;
                size--;
            } else {
                prevPI = pI; pI = pI.next;
            }
        }
    }

    /**
     * Insereix ordenadament un nou element en la llista.
     * Precondició: la llista està ordenada ascendentment.
     * @param x int valor a inserir.
     */
    public void insertSort(int x) {
        NodeInt aux = first, ant = null;
        /* COMPLETAR bucle de cerca del primer node amb dada>=x */
        while (aux != null && aux.data < x) ant = aux; aux = aux.next;
        // quan acaba el bucle: aux és el node amb dada>=x
        // o és null si tots els elements són <=x
        // El nou node s'ha d'inserir entre ant i aux.
        // en la posició anterior al PI. 
        /* COMPLETAR: crear el nou node i actualitzar prevPI, 
        first quan corresponga, pI i size                 */

        prevPI = new NodeInt(x, aux);
        if (aux == first) first = prevPI;
        else ant.next = prevPI;
        pI = aux;
        size++;

    }
    
    public void removeLessThanInOrd(int x) {
        pI = first; prevPI = null;
        while (pI != null && pI.data < x) {
            first = pI.next;
            pI = pI.next;
        }
    }
}
