package linear;

/**
 * Classe que afegeix funcionalitat a ListPIIntLinked.
 *
 * @author PRG
 * @version Curs 2019/20
 */
public class ListPIIntLinkedPlus extends ListPIIntLinked {

    public ListPIIntLinkedPlus() { super(); }

    /**
     * Comprova si x està en la llista. Si està, torna true i
     * situa el punt d'interés sobre eixe valor. Si no està,
     * torna false i deixa el punt d'interés al final del tot.
     * @param x int valor a buscar.
     * @return true si x està en la llista i false en cas contrari.
     */
    public boolean search(int x) {
        // COMPLETAR: situar el PI a l'inici
        this.begin();
        // COMPLETAR: bucle de cerca de la primera ocurrència de x en la llista 
        while (!this.isEnd() && this.get() != x) this.next();
        // COMPLETAR: si cerca amb èxit, tornar true, sino tornar false
        return !this.isEnd();
    }

    /**
     * Esborra l'element x de la llista. Si apareix més d'una vegada,
     * esborra la primera aparició. 
     * Si no està, deixa el punt d'interés al final del tot.
     * @param x int valor a esborrar.
     */
    public void delete(int x) {
        // COMPLETAR: situar el PI a l'inici
        this.begin();
        // COMPLETAR: bucle de cerca de la primera ocurrència de x en la llista 
        while (!this.isEnd() && this.get() != x) this.next();
        // COMPLETAR: si cerca amb èxit, eliminar x, sino no fer res
        if (!this.isEnd()) this.remove();
    }   

    /**
     * Esborra de la llista totes les aparicions de la dada x 
     * i deixa el punt d'interés al final del tot.
     * @param x int valor a esborrar.
     */
    public void removeAll(int x) {
        // COMPLETAR: situar el PI a l'inici
        this.begin();
        // COMPLETAR: bucle de recorregut de totes les dades de la llista        
        // COMPLETAR: si la dada del PI és x, eliminar-la
        //            sino, avançar el PI
        while (!this.isEnd()) {
            if (this.get() == x) this.remove();
            else this.next();
        }
    }

    /**
     * Insereix ordenadament un nou element en la llista.
     * Precondició: la llista està ordenada ascendentment.
     * @param x int valor a inserir.
     */
    public void insertSort(int x) { // min 21 T5 S6
        // COMPLETAR: situar el PI a l'inici
        this.begin();
        // COMPLETAR: bucle de cerca de la primera dada >= x en la llista 
        while (!this.isEnd() && this.get() < x) this.next();
        // quan acaba el bucle, el PI està sobre el node amb dada>=x
        // o està al final de la llista si tots els elements són <x 
        // COMPLETAR: inserir x en la llista
        this.insert(x);
        // el PI no es mou i prevPI és el node inserit

    }

    /**
     * Modifica la llista amb punt d’interès 
     * triplicant tots els seus elements. 
     */
    public void triplicar() {
        // COMPLETAR: situar el PI a l'inici
        this.begin();
        // COMPLETAR: bucle de recorregut de totes les dades de la llista 
        while (!this.isEnd()) {
            // COMPLETAR: inserir el valor del PI * 3
            this.insert(3*get());
            // el PI segueix en l’element recuperat 
            // i l’anterior, l’inserit, és el triple del recuperat 
            // COMPLETAR: eliminar el valor del PI
            this.remove();
            // l’element recuperat s’ha esborrat 
            // i el PI està en el següent element a canviar
        }
    }
    
    /** Inverteix els elements de la llista a partir 
     *  del seu punt d’interès actual, és a dir,
     *  inverteix la subllista que es defineix des de 
     *  l’element que ocupa el punt d’interès actual fins
     *  l’últim element de la llista.
     */ 
    public void invertir() {
        if (!this.isEnd()) {
            int e = remove();
            invertir();
            insert(e);
        }
    }
}
