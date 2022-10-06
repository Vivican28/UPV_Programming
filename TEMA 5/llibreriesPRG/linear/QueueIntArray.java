package linear;

import java.util.NoSuchElementException;
/**
 * QueueIntArray: Implementació amb array circular de l'estructura de dades 
 * lineal Cua d'enters.
 * 
 * @author PRG
 * @version Curs 2019/20
 */
public class QueueIntArray {
    private static final int MAX = 10; // dimensió màxima de la cua
    private int[] theArray;            // array utilitzat per emmagatzemar 
                                       // les dades de la cua
    private int first, last, size;  // posició del primer i últim element
                                    // i número d'elements de la cua

    /**
     * Crea una cua buida.
     */
    public QueueIntArray() {
        theArray = new int[MAX];
        size = 0; 
        first = 0; 
        last = -1;
    }

    /** Mètode auxiliar de càlcul de l'índex 
     *  següent a i en un array circular
     */
    private static int increment(int i, int length) {
        i++;
        if (i == length) { i = 0; }
        return i;
    }
    
    /**
     * Encua un nou element en la cua. 
     * @param x int a encuar en la cua actual.
     */
    public void add(int x) {
        if (size == theArray.length) { duplicateArray(); }
        last = increment(last, theArray.length);
        theArray[last] = x;
        size++;
    }
    
    private void duplicateArray() {
        int[] aux = new int[2 * theArray.length];
        int pos = first; 
        for (int i = 0; i < theArray.length; i++) { 
            aux[i] = theArray[pos];
            pos = increment(pos, theArray.length);
        }
        first = 0; last = theArray.length - 1; theArray = aux;
    }

    /**
     * Torna i desencua el first de la cua.
     * @throws NoSuchElementException si la cua està buida.
     * @return int, dada de l'element first desencuat de la cua actual.
     */
    public int remove() {
        if (size == 0) { 
            throw new NoSuchElementException("Empty queue");
        }
        int x = theArray[first];
        first = increment(first, theArray.length);
        size--;
        return x;
    }

    /**
     * Torna l'element first de la cua actual.
     * @throws NoSuchElementException si la cua està buida.
     * @return int, dada de l'element first de la cua actual.
     */
    public int element() { 
        if (size == 0) { 
            throw new NoSuchElementException("Empty queue");
        }
        return theArray[first]; 
    }

    /**
     * Comprova si la cua actual està o no buida.
     * @return boolean, true si la cua està buida i false en cas contrari.
     */
    public boolean empty() { return size == 0; }

    /**
     * Torna el número d'elements de la cua actual.
     * @return int, número d'elements de la cua actual.
     */
    public int size() { return size; }
    
    /**
     * Torna una String formada pels valors de la cua actual.
     * @return String amb les dades de la cua.
     */
    public String toString() {
        String s = "";
        int pos = first; 
        for (int i = 0; i < size; i++) { 
            s += String.format("%4d", theArray[pos]);
            pos = increment(pos, theArray.length);
        }
        return s;
    }    

    /**
     * Comprova si la cua actual és igual o no a una cua donada.
     * @param o Object que representa la cua a comparar.
     * @return boolean, true si són iguals i false en cas contrari.
     */
    public boolean equals(Object o) {
        if (o instanceof QueueIntArray) {
            QueueIntArray q = (QueueIntArray) o;
            if (this.size != q.size) { return false; }
            else {
                int i = 1, t = first, a = first;
                while (i <= this.size && this.theArray[t] == q.theArray[a]) { 
                    i++;
                    t = increment(t, theArray.length);
                    a = increment(a, q.theArray.length);
                }
                return i > size;
            }
        }
        else { return false; }
    }
}
