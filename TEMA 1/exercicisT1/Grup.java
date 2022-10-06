/**
 * Classe Grup: representa els alumnes d'un grup.
 * 
 * @author PRG 
 * @version Curs 2019/20
 */
public class Grup {
    /** Nombre maxim d'alumnes per grup */
    public static final int NUM_ALUMNES = 50; 
    private Alumne[] grup;
    private int numAl; // nombre real d'alumnes del grup      

    /** Crea un Grup amb 0 alumnes. */
    public Grup() {
        grup = new Alumne[NUM_ALUMNES];
        numAl = 0;
    }

    /** Donat un alumne, si cap, l'afegeix al grup.
     *  @param a Alumne a afegir.
     */
    public void afegir(Alumne a) {
        if (numAl < NUM_ALUMNES) { grup[numAl++] = a; }
    }
    
    /** Torna la posicio d'un alumne donat o -1 si no el troba.
     *  @return int.  
     */
    private int cercar(Alumne a) {
        int i = 0;
        while (i < numAl && !grup[i].equals(a)) { i++; }
        if (i < numAl) { return i; }
        else { return -1; }
    }
    
    /** Donat un alumne, si existeix, l'elimina del grup.
     *  @param a Alumne a eliminar.
     *  @return boolean.
     */
    public boolean eliminar(Alumne a) {
        int i = cercar(a);
        boolean trobat = i != -1;
        if (trobat) {
            for (int j = i + 1; j < numAl; j++) {
                grup[j - 1] = grup[j];
            }
            numAl--;
            grup[numAl] = null;
        }
        return trobat;
    }

    /** Mostra per pantalla la informacio de tots els alumnes. */  
    public void mostrarAlumnes() { mostrarAlumnes(0); } 
    
    /** Recorregut recursiu ascendent
     *  PRECONDICIO: 0 <= pos <= numAl */
    private void mostrarAlumnes(int pos) {
        if (pos < numAl) { 
            System.out.println(grup[pos]);
            mostrarAlumnes(pos + 1);
        }
    }      

    /** Torna la nota minima.
     *  @return double.  
     */
    public double notaMinima() { return notaMinima(0); }
    
    /** Recorregut recursiu ascendent
     *  PRECONDICIO: 0 < numAl i 0 <= pos < numAl  AAAAAAAAAAAAAAAAAAAA */
    private double notaMinima(int pos) {
        double min = grup[pos].getNota();
        if (pos < numAl -1) { 
            double aux = notaMinima(pos + 1); 
            if (grup[pos].getNota() < aux) {
                return grup[pos].getNota();
            }
            else { return aux; }
        }
        else { return grup[pos].getNota(); }
    }

    /** Compta el nombre de MH. 
     *  @return int. 
     */
    public int comptarMH() { return comptarMH(numAl - 1); }
    
    /** Recorregut recursiu descendent
     *  PRECONDICIO: -1 <= pos < numAl */
    private int comptarMH(int pos) {
        if (pos >= 0) {
            int cont = comptarMH(pos - 1);
            if (grup[pos].getNota() == 10) { return cont + 1; }
            else { return cont; }
        }
        else { return 0; }
    }       

    /** Torna la posicio del primer alumne amb MH o -1 si no hi ha cap MH.
     *  @return int.  
     */
    public int primeraMH() { 
        // recorregut descendent primera versio
        return primeraMH(numAl - 1);  
        // recorregut descendent segona versio
        // return primeraMH(numAl - 1, -1); 
        // cerca ascendent
        // return primeraMHC(0); 
    }
    
    /** Recorregut recursiu descendent - Primera versio
     *  PRECONDICIO: -1 <= pos < numAl */
    private int primeraMH(int pos) {
        if (pos >= 0) {
            int cont = primeraMH(pos - 1);
            if (cont == -1 && grup[pos].getNota() == 10) { return pos; }
            else { return cont; }
        }
        else { return -1; } 
    }

    /** Recorregut recursiu descendent - Segona versio
     *  PRECONDICIO: -1 <= pos < numAl i -1 <= primMH < numAl AAAAAAAAAAAAAAAAAA */ 
    private int primeraMH(int pos, int primMH) {
        if (pos>= 0) {
            if (grup[pos].getNota() == 10) { return primeraMH(pos -1, pos); }
            else { return primeraMH(pos-1, primMH); }
        }
        else { return primMH; }
    }

    /** Cerca recursiva ascendent
     *  PRECONDICIO: 0 <= pos <= numAl */
    private int primeraMHC(int pos) {
        if (pos< numAl) {
            if (grup[pos].getNota() == 10) { return pos; }
            else { return primeraMH(pos + 1); }
        }
        else { return -1; }
    }
    
    /** Torna la posicio del darrer alumne amb MH o -1 si no hi ha cap MH.
     *  @return int.  
     */
    public int darreraMH() { return darreraMH(numAl - 1); } 
    
    /** Cerca recursiva descendent
     *  PRECONDICIO: -1 <= pos < numAl */
    private int darreraMH(int pos) {
        if (pos >= numAl) {
            if (grup[pos].getNota() == 10) { return pos; }
            else { return darreraMH(pos - 1); }
        }
        else { return -1; }
    } 

    /** Comprova si els alumnes estan ordenats ascendentment 
     *  per nota (de menor a major).
     *  @return boolean.
     */
    public boolean ordreAsc() { return ordreAsc(0); } 
    
    /** Cerca recursiva ascendent
     *  PRECONDICIO: 0 <= pos < numAl */
    private boolean ordreAsc(int pos) {
        if (pos < numAl - 1) {
            return grup[pos].getNota() <= grup[pos + 1].getNota() && ordreAsc(pos + 1);
        }
        else { return true; }
    }     

    /** Torna la posicio d'un alumne de nom donat, sabent que els alumnes 
     *  estan ordenats per nom (lexicograficament), o -1 si no el troba.
     *  @param nom String.
     *  @return int.
     */  
    public int encNom(String nom) { return encNom(nom, 0, numAl - 1); }
    
    /** Cerca binaria recursiva
     *  PRECONDICIO: 0 <= ini <= numAl i -1 <= fi < numAl */
    private int encNom(String nom, int ini, int fi) {
        if (ini > fi) { return -1; }
        else {
            int meitat = (ini + fi) / 2;
            if (grup[meitat].getNom().equals(nom)) { return meitat; }
            else if (grup[meitat].getNom().compareTo(nom) > 0) {
                return encNom(nom, ini, meitat - 1);
            }
            else { return encNom(nom, meitat + 1, fi); }
        }
    }
}