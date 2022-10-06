import java.io.File;
/**
 * Classe TestFile. Exemple d'ús de la classe File per tractar 
 * amb el sistema d’arxius.
 *
 * @author PRG
 * @version Curs 2019/20
 */
public class TestFile {
    private TestFile() { }

    public static void main(String[] args) {
        File f = new File("/home/pcasals/file.txt");
        System.out.println("getName(): " + f.getName());
  	System.out.println("getParent(): " + f.getParent());  	
        if (f.exists()) {
	     System.out.println("El fitxer existeix!");	     
  	     System.out.println("length(): " + f.length());
        }	
        else { System.err.println("El fitxer NO existeix!"); }
    }
}