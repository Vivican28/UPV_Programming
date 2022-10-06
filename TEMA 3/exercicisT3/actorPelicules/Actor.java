package actorPelicules;

/**
 * Classe Actor - Descripcio d'un actor
 * Un Actor es una Persona que ha rodat una pel.licula amb un titol.
 * 
 * @author PRG 
 * @version Curs 2019/20
 */
public class Actor extends Persona {
    private String pelicula;
    
    /** Crea un objecte Actor donats un nom i 
     *  una pel.licula.
     *  @param n String amb el nom.
     *  @param p String amb el titol d'una pel.licula.
     */
    public Actor(String n, String p) {
        super(n);  
        this.pelicula = p;
    }    
    
    public String getPelicula() { return this.pelicula; }
    public String getString() {
        return "Nom: " + super.toString()
            + "\tPel.licula: " + this.pelicula;
    }
}
