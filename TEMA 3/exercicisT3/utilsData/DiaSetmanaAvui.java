package utilsData;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
/** 
 *  Classe DiaSetmanaAvui: mostra per pantalla la data d'avui 
 *  incloent el dia de la setmana, amb el format:  
 *  dijous, 28 de febrer 2019
 *  
 *  @author PRG 
 *  @version Curs 2019/20
 */
public class DiaSetmanaAvui {
    /** No hi ha objectes d'aquesta classe */
    private DiaSetmanaAvui() { }
    
    public static void main(String[] args) {       
        SimpleDateFormat fmt = new SimpleDateFormat("EEEE, dd MMMM yyyy", 
                                                     new Locale("ca", "ES"));
        Date avui = new Date();
        String avuiAmbDia = fmt.format(avui);
        System.out.println("Avui: " + avuiAmbDia);            
    }
}
