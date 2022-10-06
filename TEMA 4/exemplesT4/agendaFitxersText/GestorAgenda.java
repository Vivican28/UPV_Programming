package agendaFitxersText;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
/**
 * Classe GestorAgenda: llanca l'aplicacio de simulacio d'una agenda telefonica,
 * presentant a l'usuari en mode text una interficie basica amb la qual aquest 
 * pot manipular la seua agenda. Per aixo, el seu unic metode public es el main 
 * i en ell es descriuen via menu les opcions de treball que permet l'aplicacio.
 * 
 * @author PRG
 * @version Curs 2019/20
 */
public class GestorAgenda {
    private static final String ERR = "\n***ERROR***: No s'ha pogut ";
    private static final String TANCAR = "tancar el fitxer ";
    private static final String ACCE = "accedir al fitxer ";
    private static final String LLEGIR = "llegir del fitxer ";
    private static final String TIPUS = "llegir per tipus erroni en ";
    private static final String CREAR = "crear el fitxer ";
    private static final String ESCR = "escriure en el fitxer ";
    
    /** No hi ha objectes d'aquesta classe */
    private GestorAgenda() { }
    
    /** 
     *  Programa principal.
     *  @param args String[] 
     */ 
    public static void main(String[] args) {
        Scanner teclat = new Scanner(System.in);
        Agenda agendaMeua = new Agenda();
        
        int opc;        
        do {
            opc = menu(teclat);
            switch(opc) {
                case 1: // Mostrar contactes
                    System.out.println("\n" + agendaMeua);
                    break;                        
                case 2: // Afegir un contacte
                    UtilsAgenda.inserirContacte(agendaMeua, teclat);  
                    break;                        
                case 3: // Consultar un contacte
                    UtilsAgenda.recuperarContacte(agendaMeua, teclat);
                    break; 
                case 4: // Carregar agenda des de fitxer de text     
                    System.out.print("\nNom de fitxer: ");
                    String nomFitxEnt = teclat.nextLine(); 
                                              
                    Scanner fEnt = null;
                    try {
                        fEnt = new Scanner(new File(nomFitxEnt));
                        agendaMeua.carregarFitxerText(fEnt); 
                    } catch (FileNotFoundException e) {
                        System.out.println(ERR + ACCE + nomFitxEnt);
                    } finally {
                        if (fEnt != null) { fEnt.close(); }
                    }    
                    break;                  
                    
                case 5: // Guardar agenda en fitxer de text
                    System.out.print("\nNom de fitxer: ");
                    String nomFitxSort = teclat.nextLine();  
                                              
                    PrintWriter fSort = null;
                    try {
                        fSort = new PrintWriter(new File(nomFitxSort));
                        agendaMeua.guardarFitxerText(fSort); 
                    } catch(FileNotFoundException e) {
                        System.out.println(ERR + ESCR + nomFitxSort);
                    } finally {
                        if (fSort != null) { fSort.close(); }
                    }
                    break;                          
                        
                case 0: // Finalitzar
                    System.out.println("\nAgenda tancada.");
            }        
        } while (opc != 0);
    }
    
    /** 
     *  Presenta un menu d'opcions per pantalla.
     *  @param teclat Scanner per fer la lectura de l'opcio 
     *  triada des de teclat.  
     *  @return int, torna l'opcio valida triada per l'usuari 
     *  d'entre les opcions possibles.
     */  
    private static int menu(Scanner teclat) {
        int opcio;
        do {
            System.out.println("\n                MENÚ");
            System.out.println("---------------------------------------");
            System.out.println("| 1.- Mostrar contactes               |");
            System.out.println("| 2.- Afegir un contacte              |");
            System.out.println("| 3.- Consultar un contacte           |");
            System.out.println("| 4.- Carregar agenda des de fitxer   |");
            System.out.println("| 5.- Guardar agenda en fitxer        |");
            System.out.println("| 0.- Finalitzar                      |");
            System.out.println("---------------------------------------");
            System.out.print("Tria una opcio: ");
            opcio = teclat.nextInt(); 
            teclat.nextLine();
            if (opcio < 0 || opcio > 5) {
                System.out.println("Opcio incorrecta, torna a intentar-ho");
            }
        } while (opcio < 0 || opcio > 5);
        return opcio;        
    } 
    
}
