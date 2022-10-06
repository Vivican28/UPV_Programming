package altres;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;
/**
 * Classe Calculadora: calculadora d'enters. Les operacions permeses 
 * son la suma, la diferencia, el producte i la divisio.
 *
 * @author PRG
 * @version Curs 2019/20
 */
public class Calculadora {    
    /** No hi ha objectes d'aquesta classe. */
    private Calculadora() { }
    
    public static void main(String[] args) {   
        Scanner tec = new Scanner(System.in).useLocale(Locale.US);
        int num1 = 0, num2 = 0, result = 0; // dades i resultat
        char op; // operador implicat
        boolean eixir = false;    
        do {
            try {
                System.out.print("num1? ");
                num1 = tec.nextInt();
                System.out.print("operador? ");
                op = tec.next("\\S").charAt(0);
                System.out.print("num2? ");
                num2 = tec.nextInt();
    
                switch(op) {
                    case '+': 
                        result = num1 + num2; 
                        break;
                    case '-': 
                        result = num1 - num2; 
                        break;
                    case '*': 
                        result = num1 * num2; 
                        break;
                    case '/': 
                        result = num1 / num2; 
                        break;
                    default: 
                        throw new InputMismatchException("No es un op. valid");
                }
                System.out.println("El resultat es: " + result);  
            } catch (InputMismatchException e) {
                System.out.println(e);     
            } catch (ArithmeticException e) {
                System.out.println("No es pot fer el calcul!");
            } finally {
                tec.nextLine();
                try {
                    System.out.println("\nPolsa 0 per acabar o "
                                      + "qualsevol altre numero per continuar");
                    if (tec.nextInt() == 0) { eixir = true; }
                } catch (InputMismatchException e) {
                    System.out.println(e);     
                } finally {
                    tec.nextLine();
                }               
            }            
        } while (!eixir);
    } 
}