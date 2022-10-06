package utilsData;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
/** 
 *  Classe DiaSetmana: mostra per pantalla una data donada com una String 
 *  dd/mm/yyyy, incloent el dia de la setmana.
 *  Per exemple, si la String es 28/02/2019, es mostra:
 *  dijous, 28 de febrer 2019
 *  
 *  @author PRG 
 *  @version Curs 2019/20 
 */
public class DiaSetmana {
    /** No hi ha objectes d'aquesta classe */
    private DiaSetmana() { }
    
    public static void main(String[] args) {
        // COMPLETAR:
        // 1.- Corregir l'error de compilacio.
        // 2.- Permetre que l'usuari puga introduir per teclat 
        //     totes les dates que destige.
        // 3.- Si alguna de les dates que escriu no s'ajusta al
        //     format establert, ha d'informar de l'error.
        // 4.- El programa ha d'acabar quan l'usuari introduisca
        //     la String buida.
        
        Scanner teclat = new Scanner(System.in);
        boolean eixir = false;
        do {
            System.out.println("Escriu la data (dd/MM/yyyy)");
            String data = teclat.nextLine();
            if (data.length() == 0) { eixir = true; }
            else {
                try { 
                    SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy", new Locale("ca", "ES"));
                    
                    Date dataD = fmt.parse(data);
                    fmt.applyPattern("EEEE, dd MMMM yyyy");
                    String dataDAmbDia = fmt.format(dataD);
                    System.out.println(dataDAmbDia);
                } catch (ParseException pe) {
                    System.out.println("Dades introduides incorrectes" + data);
                }
            }
        } while (!eixir);
        System.out.println("Adeu!");
    }
}
