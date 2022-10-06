import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner; 
/**
 * Classe TestPrintWriterScanner. Exemple d'ús de PrintWriter i Scanner
 *
 * @author PRG
 * @version Curs 2019/20
 */
public class TestPrintWriterScanner {
    private TestPrintWriterScanner() { }
    
    public static void main(String[] args) {
        String fitxer = "file1.txt";
        try {
      	    PrintWriter pw = new PrintWriter(new File(fitxer));
      	    for (int i = 0; i < 10; i++) { pw.println(i); }
     	    pw.close();
     	    
     	    Scanner scanner = new Scanner(new File(fitxer));
     	    while (scanner.hasNextInt()) {
	        System.out.println("Valor llegit: " + scanner.nextInt());
            } 
     	    scanner.close();
        } catch (FileNotFoundException e) {
            System.err.println("Problemes en obrir el fitxer " + fitxer);
        } 
    } 
}
