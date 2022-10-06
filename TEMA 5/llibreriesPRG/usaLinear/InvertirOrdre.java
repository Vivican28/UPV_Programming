package usaLinear;

import java.util.Scanner;
import linear.StackIntLinked;
/** 
 *  Programa que llig una seqüència d'enters i els mostra
 *  per pantalla en ordre invers a com s'han llegit.
 *  
 *  @author PRG
 *  @version Curs 2019/20
 */
public class InvertirOrdre {
    private  InvertirOrdre() { }
    
    public static void main(String[] args) {
        Scanner teclat = new Scanner(System.in);
        System.out.println("Introdueix una seqüència d'enters >=0."
                          + " Escriu un valor negatiu per acabar.");
       
        // Crear un StackIntLinked buida
        StackIntLinked p = new StackIntLinked();
        int n = teclat.nextInt();
        while (n >= 0) {
            // Empilar la dada n
            p.push(n);
            n = teclat.nextInt(); 
        }
        
        System.out.println("Seqüència en sentit invers:");
        while (!p.empty()) { 
            // Mostrar per pantalla el cim i desempilar    
            System.out.print(p.pop() + " ");
        }  
    }
}