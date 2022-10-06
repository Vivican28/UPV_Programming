package agendaFitxersText;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
/**
 * Classe Agenda: representacio d'una agenda telefonica com un grup de  
 * contactes dinamic situats en posicions contigues de memoria. 
 * Es molt important notar que una agenda, per definicio, no conte contactes 
 * repetits o, mes ben dit, noms de contactes repetits. 
 * @author PRG
 * @version Curs 2019/20
 */ 
public class Agenda {
    public static final int MAX = 100; 
    private Contacte[] lArray;
    private int num;
    
    /**
     * Crea una agenda sense contactes (pot tenir un maxim de MAX contactes).
     */
    public Agenda() { lArray = new Contacte[MAX]; num = 0; }
  
    /**
     * Torna el numero actual de contactes.
     * @return int, numero actual de contactes.
     */
    public int getNumContactes() { return num; }
  
    /**
     * Duplica la grandaria de l'array.
     */
    private void duplicaEspai() {
        Contacte[] aux = new Contacte[2 * lArray.length];
        for (int i = 0; i < lArray.length; i++) { aux[i] = lArray[i]; }
        lArray = aux; 
    }
  
    /**
     * Permet inserir el Contacte b a l'agenda. Si l'agenda esta completa,
     * duplica el numero de contactes que poden haver-hi.
     * @param b Contacte a inserir. Es un contacte valid: el nom te una 
     * longitud en l'interval [1...40] i no esta repetit. I el telefon
     * te 9 caracters de l'interval ['0'..'9'] sent el primer d'ells 
     * distint de zero.
     * @param b Contacte a inserir.
     */
    public void inserir(Contacte b) {
        if (num >= lArray.length) { duplicaEspai(); }        
        lArray[num++] = b; 
    }
  
    /**
     * Torna el contacte amb nom nom.
     * Si aquest contacte no existeix, torna null.
     * @param nom String que indica el nom del contacte.
     * @return Contacte, el contacte resultat.
     */
    public Contacte getContacte(String nom) {
        int i = 0;
        while (i < num && !lArray[i].getNom().equals(nom)) { i++; }
        if (i < num)  { return lArray[i]; }
        else { return null; }
    }
    
    /**
     * Torna una String amb tota la informacio de l'agenda.
     * El format es un contacte per linia (nom: telefon).
     * @return String.
     */
    public String toString() {
        String res = "";
        for (int i = 0; i < num; i++) { res += lArray[i] + "\n"; }   
        return res; 
    } 
    
    /**
     * Carrega els contactes de l'agenda a partir d'un fitxer de text.
     * @param f Scanner per a realitzar la lectura des de fitxer.
     */
    public void carregarFitxerText(Scanner f) {         
        while (f.hasNext()) {
            String linia = f.nextLine();
            String[] v = linia.split(":");            
            String nom = v[0];
            String telefon = v[1].trim();
            boolean nomValid = UtilsAgenda.esNomValid(nom);
            boolean telValid = UtilsAgenda.esTelefonValid(telefon);
            if (!nomValid || !telValid) {
                System.out.println("Linia no valida");
            }
            else {
                Contacte c = new Contacte(nom, telefon);
                if (this.getContacte(nom) != null) {
                    System.out.println("El nom " + nom + " ja existeix. "
                                       + "Contacte no inserit");
                }
                else { this.inserir(c); }
            }            
        }
    }
    
    /**
     * Guarda una agenda en un fitxer de text.
     * @param f PrintWriter per a realitzar l'escriptura en fitxer.
     */
    public void guardarFitxerText(PrintWriter f) {  
        /* Primera versio: toString() de Contacte */
        // for (int i = 0; i < num; i++) { f.println(lArray[i]); } 
        
        /* Segona versio: toString() de Agenda */
        if (num > 0) { f.print(this); }  
    }
}
