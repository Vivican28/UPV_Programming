package usaLinear;

import linear.ListPIIntLinked;
/**
 * Classe OpsLlistes: classe d'utilitats amb mètodes que usen ListPIIntLinked.
 *
 * @author PRG
 * @version Curs 2019/20
 */
public class OpsLlistes {
    private OpsLlistes() { }
    
    /** Torna una nova llista amb els elements de la intersecció de l1 i l2. 
     *  Precondició: l1 i l2 han d’estar ordenades ascendentment.
     *  @param l1 ListPIIntLinked.
     *  @param l2 ListPIIntLinked.
     *  @return ListPIIntLinked, llista amb punt d'interés intersecció de l1 i l2.
     */
    public static ListPIIntLinked intersectSort(ListPIIntLinked l1, ListPIIntLinked l2) {
        ListPIIntLinked l3 = new ListPIIntLinked();
        l1.begin(); l2.begin();
        while (!l1.isEnd() && !l2.isEnd()) {
            int e1 = l1.get(), e2 = l2.get();
            if (e1 < e2) l1.next();
            else if (e1 > e2) l2.next();
            else {
                l3.insert(e1);
                l1.next();
                l2.next();
            }
        }
        return l3;
    }

    /** Torna una nova llista amb els elements de la intersecció de l1 i l2. 
     *  @param l1 ListPIIntLinked.
     *  @param l2 ListPIIntLinked.
     *  @return ListPIIntLinked, llista amb punt d'interés intersecció de l1 i l2.
     */
    public static ListPIIntLinked intersection(ListPIIntLinked l1, ListPIIntLinked l2) {
        ListPIIntLinked l3 = new ListPIIntLinked();
        l1.begin(); 
        while (!l2.isEnd()) {
            int e1 = l1.get();
            
            // boolean esta = false;
            // l2.begin();
            // while (!l2.isEnd() && l2.get() != e1) l2.next();
            // if (!l2.isEnd()) esta = true;
            
            boolean esta = l2.search(e1);
            if (esta) l3.insert(e1);
            l1.next();
        }
        return l3;
    }
    
    /** Elimina de l1 els elements que apareixen en l2.
     *  Precondició: l2 ha d’estar ordenada ascendentment.
     *  @param l1 ListPIIntLinked.
     *  @param l2 ListPIIntLinked.
     */
    public static void dif(ListPIIntLinked l1, ListPIIntLinked l2) {
        l1.begin();
        while (!l1.isEnd()) {
            l2.begin();
            while (!l2.isEnd() && l2.get() < l1.get()) l2.next();
            if (!l2.isEnd() && l2.get() == l1.get()) l1.remove();
            else l1.next();
        }
    }

    /** Torna la mescla natural de l1 i l2.
     *  Precondició: l1 i l2 han d’estar ordenades ascendentment.
     *  @param l1 ListPIIntLinked.
     *  @param l2 ListPIIntLinked.
     *  @return ListPIIntLinked, llista amb punt d'interés mescla de l1 i l2.
     */
    public static ListPIIntLinked merge(ListPIIntLinked l1, ListPIIntLinked l2) { 
        ListPIIntLinked lu = new ListPIIntLinked();
        l1.begin(); l2.begin(); 
        while (!l1.isEnd() && !l2.isEnd()) {
            int i = l1.get(), j = l2.get();
            if (i < j) { lu.insert(i); l1.next(); }
            else if (i > j) { lu.insert(j); l2.next(); }
            else { lu.insert(i); l1.next(); l2.next(); }
        }
        while (!l1.isEnd()) {
            lu.insert(l1.get());
            l1.next();
        }
        while (!l2.isEnd()) {
            lu.insert(l2.get());
            l2.next();
        }
        return lu;
    }

    /** Comprova si els elements de l1 apareixen en l2 en el mateix ordre,
     *  encara que no necessàriament consecutius. És a dir, si l1 està immersa en l2.
     *  @param l1 ListPIIntLinked.
     *  @param l2 ListPIIntLinked.
     *  @return boolean, true si l1 està immersa en l2 o, en cas contrari, false.
     */ 
    public static boolean immersa(ListPIIntLinked l1, ListPIIntLinked l2) {
        l1.begin(); l2.begin(); 
        int cont1 = l1.size(), cont2 = l2.size(); 
        // COMPLETAR: bucle que, passada a passada, avance en l2, o en l1 i l2.
        // Acaba en arribar al final d'una de les llistes o si el número d'elements
        // que queden per revisar en l2 és menor que el d'elements de l1 que falten
        // per trobar en l2
        while (!l1.isEnd() && !l2.isEnd() && cont2 >= cont1) {
            int a = l1.get(), b = l2.get();
            if (a == b) l1.next(); cont1--;
            l2.next(); cont2--;
        }
        return l1.isEnd(); 
    }
}
