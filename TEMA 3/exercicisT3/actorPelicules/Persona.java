package actorPelicules;

/**
 * Classe Persona - Descripcio d'una persona
 * 
 * @author PRG 
 * @version Curs 2019/20
 */
public class Persona {
    protected String nom;    
   
    /** Crea un objecte Persona amb un nom donat.     
     *  @param n String que representa el nom.  
     */
    public Persona(String n) {
        this.nom = n;
    }  
    public String toString() { return nom; }
}