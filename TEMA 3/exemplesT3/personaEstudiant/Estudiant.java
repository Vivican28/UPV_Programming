package personaEstudiant;

/**
 * Classe Estudiant: classe tipus de dades per representar un estudiant
 * amb el seu nom, el seu dni i els credits dels que esta matriculat.
 * 
 * @author PRG 
 * @version Curs 2019/20
 */
public class Estudiant extends Persona {
    private int credits;
    
    /**
     * Crea un objecte Estudiant amb nom i dni donats 
     * i matriculat de 60 crèdits.
     * @param nom String que representa el nom de l'estudiant.
     * @param dni int que representa el dni de l'estudiant.
     */
    public Estudiant(String nom, int dni) { 
        super(nom, dni); 
        this.credits = 60;
    }
    
    /**
     * Torna el nombre de crèdits dels que l'estudiant està matriculat.
     * @return int, crèdits.
     */
    public int getCredits() { return credits; } 
    
    /**
     * Torna un String amb les dades de l'estudiant.
     * @return String, amb el nom, el dni i els crèdits.
     */
    public String toString() { 
        return super.toString() + " Cred: " + credits;
    }   
}
