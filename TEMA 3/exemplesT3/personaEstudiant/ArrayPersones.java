package personaEstudiant;

/**
 * Classe ArrayPersones: classe per comprovar la compatibilitat de tipus 
 * en presència d’herència.
 *
 * @author PRG 
 * @version Curs 2019/20
 */
public class ArrayPersones {
    /** No hi ha objectes d'aquesta classe. */
    private ArrayPersones() { }
    
    public static void main(String[] args) {
        Estudiant e1 = new Estudiant("Manel Font", 33445566);
        Estudiant e2 = new Estudiant("Lluís Sales", 44226655);
        Professor pr1 = new Professor("Víctor Ferragut", 11223344, "idm");
        Professor pr2 = new Professor("Andreu Pla", 44332288, "dsic");
        Professor pr3 = new Professor("Mireia Albiol", 99432885, "disca");
        Persona[] a = {pr1, e1, pr2, e2, pr3};
        
        for (int i = 0; i < a.length; i++) {
            if (a[i] instanceof Professor) {
                System.out.println(((Professor) a[i]).getDepartament()); 
                    // Si no es fa el càsting, error de compilació 
            }       // perquè a[i] és de tipus Persona  
                                                                          
            //System.out.println(((Professor) a[i]).getDepartament());  
                  // És necessari comprovar que a[i] és de tipus Professor
                  // Sense el if, error d'execució: 
                  // java.lang.ClassCastException: Estudiant cannot be cast to Professor
        }
    }
}
