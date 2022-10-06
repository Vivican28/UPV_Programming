package figures;

/**
 * Classe Quadrat - Descripcio d'un quadrat
 * 
 * @author PRG
 * @version Curs 2019/20
 */
public class Quadrat extends Rectangle {
   
    /**
     * Crea un nou Quadrat donats el seu color i el seu costat.
     * @param color String que representa el color.
     * @param costat double que representa el costat. 
     */
    public Quadrat(String color, double costat) {
        super(color, costat, costat); 
        this.tipus = "Quadrat";
    }
    
    /**
     * Crea un nou Quadrat amb el color per defecte, donat el seu costat.
     * @param costat double que representa el costat. 
     */
    public Quadrat(double costat) { this(COLOR_PER_DEFECTE, costat); }
    
        
    /**
     * Torna un String amb les dades del Quadrat actual.
     * @return String.
     */
    public String toString() {
        return this.tipus + " de color " + this.color 
            + " i costat " + this.getBase();           
    }
}
