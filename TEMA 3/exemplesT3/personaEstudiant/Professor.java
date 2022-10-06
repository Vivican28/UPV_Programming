package personaEstudiant;

/**
 * Classe Professor: classe tipus de dades per representar un professor
 * amb el seu nom, el seu dni i el departament al que pertany.
 * 
 * @author PRG 
 * @version Curs 2019/20
 */
public class Professor extends Persona {
    private String dep;  // departament al qual pertany el Professor
    
    /**
     * Crea un objecte Professor amb nom, dni 
     * i departament donats.
     * @param n String que representa el nom del professor.
     * @param d int que representa el dni del professor.
     * @param dpt String que representa el departament del professor.
     */
    public Professor(String n, int d, String dpt) { 
        super(n, d); 
        this.dep = dpt;
    }
    
    /**
     * Torna el departament del professor.
     * @return String, departament.
     */
    public String getDepartament() { return dep; } 
    
    /**
     * Torna un String amb les dades del professor.
     * @return String, amb el nom, el dni i el departament.
     */
    public String toString() { 
        return super.toString() + " Dep: " + dep;
    }
}
