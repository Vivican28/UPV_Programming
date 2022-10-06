package agendaFitxersText;

import java.util.Scanner;
/**
 * Classe UtilsAgenda: classe d'utilitats de l'Agenda.
 *
 * @author PRG
 * @version Curs 2019/20
 */
public class UtilsAgenda {
    private UtilsAgenda() { }

    /** Comprova si un nom donat te una 
     *  longitud en l'interval [1...40]. */
    public static boolean esNomValid(String n) {
        return n.length() >= 1 && n.length() <= 40;
    }
    
    /** Comprova si un telefon donat te 9 caracters de 
     *  l'interval ['0'..'9'] sent el primer d'ells distint de zero. */
    public static boolean esTelefonValid(String t) {
        return t.matches("[0-9]+") && t.length() == 9 && t.charAt(0) != '0';
    }
    
    /** Lectura validada d'un nom valid per a un Contacte de l'agenda. */
    public static String llegirNomValid(Agenda a, Scanner teclat) {
        // Filtre de dades: Un nom valid per a un Contacte de l'agenda pot 
        // estar compost per qualsevol caracter PERO CAL que tinga una longitud 
        // en l'interval [1...40] i no pot estar repetit
        String nom;
        do {
            System.out.print("\nNom del nou contacte "
                + "(minim una lletra i maxim 40): "); 
            nom = teclat.nextLine().trim();
        } while (!esNomValid(nom) || a.getContacte(nom) != null);
        return nom;
    }
    
    /** Lectura validada d'un telefon valid per a un Contacte de l'agenda. */
    public static String llegirTelefonValid(Agenda a, Scanner teclat) {
        // Filtre de dades: Un telefon valid per a un Contacte de l'agenda 
        // CAL que estiga compost per 9 caracters de l'interval ['0'..'9']  
        // PERO el primer d'ells NO pot ser el zero
        String telefon;
        do { 
            System.out.print("\nTelefon del nou contacte (9 digits, "
                + "el primer d'ells no pot ser 0): "); 
            telefon = teclat.nextLine().trim();
        } while (!esTelefonValid(telefon));  
        return telefon;
    }
        
    /**
     * Metode que afegeix un nou contacte a l'agenda donada.
     * @param a Agenda on s'afegeix un nou contacte.
     * @param teclat Scanner per fer la lectura de dades.
     */
    public static void inserirContacte(Agenda a, Scanner teclat) {  
        // Filtre de dades: lectura d'un nom valid per a un Contacte de l'agenda 
        String nom = llegirNomValid(a, teclat);       
        // Filtre de dades: lectura d'un telefon valid per a un Contacte de l'agenda 
        String telefon = llegirTelefonValid(a, teclat);
        // Filtre de dades: la forma d'escriure un nom, amb o sense majuscules, 
        // no pot originar informacio redundant en l'agenda, es a dir, no pot  
        // donar lloc a contactes repetits. Per aixo, en l'agenda figuren els 
        // noms dels contactes en majuscules <--> qualsevol nom de contacte que 
        // es llija de teclat es passa a majuscules usant el metode toUpperCase 
        // de la classe String 
        Contacte nou = new Contacte(nom.toUpperCase(), telefon);
        a.inserir(nou);
    }
    
    /**
     * Metode que recupera la informacio associada a un nom d'un contacte de 
     * l'agenda donada.
     * @param a Agenda d'on es recupera un telefon.
     * @param teclat Scanner per fer la lectura de dades.
     */
    public static void recuperarContacte(Agenda a, Scanner teclat) {  
        final String MSG = "A la teua agenda no figura "
                         + "cap contacte amb aquest nom.";
        String nom;
        // Filtre del nom
        do {
            System.out.print("\nNom del contacte del qual " 
                             + "vols coneixer el telefon: "); 
            nom = teclat.nextLine().trim();  
        } while (!esNomValid(nom));
        // Filtre del nom (toUpperCase)
        Contacte c = a.getContacte(nom.toUpperCase()); 
        if (c != null) { System.out.println(c); }
        else {
            System.out.println(MSG);
        }
    }
}
