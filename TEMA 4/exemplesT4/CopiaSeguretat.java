import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner; 
/**
 * Classe CopiaSeguretat. Crea una còpia de seguretat d'un fitxer i 
 * la deixa de només lectura; si la còpia no es pot crear, el programa 
 * acaba sense fer res més.
 *
 * @author PRG
 * @version Curs 2019/20
 */
public class CopiaSeguretat {
    private CopiaSeguretat() { }
    
    public static void main(String[] args) {
        File fE = new File("file1.txt"), fS = new File("file1Back.txt");
        File f = null;
        Scanner sc = null; PrintWriter pw = null;
        try {
            f = fE; sc = new Scanner(f);
            f = fS; pw = new PrintWriter(f);
            copia(sc, pw); 
            // sc.close(); pw.close();
            // fS.setReadOnly();
        } catch (FileNotFoundException e) {
            System.err.println("Error " + e + " en obrir " + f);            
        } finally {
            if (sc != null) { sc.close(); }
            if (pw != null) { 
                pw.close(); 
                fS.setReadOnly(); // permís de només lectura
            }
        }
    }
    
    /** Mètode auxiliar que escriu les linies de s en p */
    private static void copia(Scanner s, PrintWriter p) {
        while (s.hasNext()) {
            String linia = s.nextLine();
            p.println(linia);
        }    
    }
}
