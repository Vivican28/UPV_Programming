import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
/**
 * Classe TestPrintWriter. Exemple de programa que usa PrintWriter
 *
 * @author PRG
 * @version Curs 2019/20
 */
public class TestPrintWriter {
    private TestPrintWriter() { }
    
    public static void main(String[] args) {
        String fitxer = "fileTPW.txt";
        try {
            PrintWriter pw = new PrintWriter(new File(fitxer));
            pw.print("Setze jutges d'un jutjat ");
            pw.println("mengen fetge d'un penjat ");
            pw.println(4.815162342);
            pw.close();
        } catch (FileNotFoundException e) { 
	    System.err.println("Problemes en obrir el fitxer " + fitxer); 
        }
    }
}
