package personaEstudiant;

/**
 * Classe Persona: classe tipus de dades per representar una persona
 * amb el seu nom i el seu dni.
 * 
 * @author PRG 
 * @version Curs 2019/20
 */
public class Persona {
    protected String nom;
    protected int dni;
   
    /** Crea un objecte Persona amb nom i dni donats.     
     *  @param n String que representa el nom.  
     *  @param d int que representa el dni.
     */
    public Persona(String n, int d) {
        this.nom = n;
        this.dni = d;
    }
   
    /** Torna el nom de la Persona. 
     *  @return String, nom de la persona.
     */
    public String getNom() { return nom; }

    /** Torna el dni de la Persona.
     *  @return int, dni de la persona.
     */
    public int getDni() { return dni; }
   
    /** Torna un String amb les dades de la Persona.
     *  @return String, amb el nom i el dni.
     */
    public String toString() { 
        return "Nom: " + nom + " DNI: " + dni;
    }
   
    /**
     * Comprova si dues Persones són iguals (si tenen el mateix dni).
     * @param o Object a comparar amb la Persona actual.
     * @return boolean.
     */
    public boolean equals(Object o) {
        return o instanceof Persona                
            && this.dni == ((Persona) o).dni;
    }
}
