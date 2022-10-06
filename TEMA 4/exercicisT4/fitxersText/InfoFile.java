package fitxersText;

import java.io.File;
/**
 *  Mostra informacio basica sobre un fitxer (nom, directori i tamany en kbytes).
 *  S'executa invocant main amb un parametre que es la ruta relativa del fitxer.
 *  Per exemple, el nom relatiu d'aquest fitxer es fitxersText/InfoFile.java.
 *  @author PRG
 *  @version Curs 2019/20
 */ 
public class InfoFile {
    private InfoFile() { }
    
    public static void main(String[] args) { 
        if (args.length != 1) { 
            System.err.println("Especifica el nom d'un fitxer");    
        }
        else {      
            String filePath = args[0];      
            File f = new File(filePath);
            if (f.isFile()) {
                System.out.println("Nom del fitxer: " + f.getName());
                System.out.println("Directori: " + f.getParent());
                System.out.println("Tamany (kbytes): " + f.length()/1024.0);  
                System.out.println("Ruta absoluta: " + f.getAbsolutePath());
            }     
        }   
    }
}