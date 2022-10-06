package carnetPerPunts;

import java.util.Scanner;
/**
 * Classe DGT - per a aplicar la penalitzacio a un CarnetDeConduir.
 * 
 * @author PRG 
 * @version Curs 2019/20
 */
public class DGT {
    /** No hi ha objectes d'aquesta classe. */
    private DGT() { }
    
    /**
     * Aplica la penalitzacio a un carnet de conduir donat i 
     * mostra per pantalla un missatge d'error si la penalitzacio 
     * de punts comporta la retirada immediata del carnet.
     * @param c CarnetDeConduir al que s'aplica la penalitzacio.
     * @param tec Scanner per a llegir des de l'entrada estandard.
     */
    public static void multar(CarnetDeConduir c, Scanner tec) {
        System.out.print("Introdueix la penalització: ");
        int penalitzacio = tec.nextInt();
        try {
            c.llevarPunts(penalitzacio);    
        } catch (RetiradaImmediataCarnet e) {
            System.out.println(e.getMessage());
        }    
    }
    
    public static void main(String[] args) {
        Scanner tec = new Scanner(System.in);
        // Es crea un CarnetDeConduir amb els 12 punts inicials
        CarnetDeConduir c = new CarnetDeConduir("Pep Tormo");
        System.out.println(c);
        // El següent bucle simula que es van cometent infraccions
        // fins el saldo de punts és 0 o negatiu
        boolean eixir = false;
        do {
            multar(c, tec);            
            if (c.getPunts() <= 0) { eixir = true; }
            else { System.out.println(c); }
        } while (!eixir);
    }
}