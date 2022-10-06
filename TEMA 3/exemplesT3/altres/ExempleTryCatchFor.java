package altres;

/**
 * Classe ExempleTryCatchFor: exemple d'us d'un bloc try-catch dins 
 * i fora d'una instruccio for.
 * Les dades s'han de passar com arguments al metode main.
 * @author PRG
 * @version Curs 2019/20
 */
public class ExempleTryCatchFor {    
    /** No hi ha objectes d'aquesta classe. */
    private ExempleTryCatchFor() { }
    
    public static void main(String[] args) {
        System.out.println("Primera versio: for que inclou try-catch");
        System.out.println("----------------------------------------");
        for (int i = 0; i < args.length; i++) {
            try {
                double valor = Double.parseDouble(args[i]);
                System.out.println(args[i] + " es un numero");
            } catch (NumberFormatException e) {
                System.out.println(args[i] + " no es un numero");
            }
        }

        System.out.println("\nSegona versio: try-catch que inclou for");
        System.out.println("---------------------------------------");
        int i = 0;
        try {
            for ( ; i < args.length; i++) {
                double valor = Double.parseDouble(args[i]);
                System.out.println(args[i] + " es un numero");
            }
        } catch (NumberFormatException e) {
            System.out.println(args[i] + " no es un numero");
        }
    }
}