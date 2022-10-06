package personaEstudiant;

/**
 * Classe TestEstudiantPersona: classe programa que permet comprovar 
 * la funcionalitat de les classes Persona, Estudiant i Professor.
 * 
 * @author PRG 
 * @version Curs 2019/20
 */
public class TestEstudiantPersona {
    /** No hi ha objectes d'aquesta classe. */
    private TestEstudiantPersona() { }
    
    public static void main(String[] args) {        
        Persona p = new Persona("Lluisa Garcia", 23456678);
        System.out.println("Persona: " + p);  // toString() de Persona
        Estudiant e = new Estudiant("Joan Lopez", 10987653);
        System.out.println("Estudiant: " + e.getNom() + " " 
            + e.getDni() + ": " + e.getCredits() + " crèdits");
        System.out.println("Estudiant: " + e);  // toString() d'Estudiant
        
        // Casting implícit o automàtic
        Persona p2 = new Estudiant("Pepe", 24123487);
        //int c = p2.getCredits();  //---> INCORRECTE: error de compilació
        int c = ((Estudiant) p2).getCredits();
        System.out.println("Credits: " + c);
        //Estudiant e2 = p;  // INCORRECTE: error de compilació 
                             // (no totes les persones són estudiants)
                         // igual d'incorrecte que int i = d; sent d un double
        // Casting explícit 
        //Estudiant e2 = (Estudiant) p; // no dóna error de compilació
                         // pero dóna error d'execució: ClassCastException
        // Solució: comprovar que p és un Estudiant    
        if (p instanceof Estudiant) {
            Estudiant e3 = (Estudiant) p;        
            System.out.println("Estudiant: " + e3);
        }
    }
}
