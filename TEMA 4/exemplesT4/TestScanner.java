import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner; 
/**
 * Classe TestScanner. Exemple d'ús d'Scanner
 *
 * @author PRG
 * @version Curs 2019/20
 */
public class TestScanner {
    private TestScanner() { }
    
    public static void main(String[] args) {
        System.out.println("Es lligen 3 números i una línia de text");
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("coses.txt"));
            int n1 = scanner.nextInt();
            int n2 = scanner.nextInt(), n3 = scanner.nextInt();
            scanner.nextLine();
            String linia = scanner.nextLine();
            System.out.println("Els tres números són: " 
                               + n1 + ", " + n2 + ", " + n3);
            System.out.println("La línia és: " + linia);
            scanner.close();
        } catch (FileNotFoundException ex) {
            System.err.println("El fitxer no existeix.\n" + ex.getMessage());
        } catch (InputMismatchException ex) {
            System.err.println("Error al llegir.\n" + ex.getMessage());
        } 
    }
}
