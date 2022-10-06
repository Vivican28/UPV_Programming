package figures;

/**
 * Classe Rectangle - Descripcio d'un rectangle
 * 
 * @author PRG
 * @version Curs 2019/20
 */
public class Rectangle extends Figura {
    private double base, altura;

    /**
     * Crea un nou Rectangle donats el seu color, la seua base i la seua altura.
     * @param c String que representa el color.
     * @param b double que representa la base.
     * @param a double que representa l'altura.
     */
    public Rectangle(String c, double b, double a) {
        super("Rectangle", c);
        this.base = b;
        this.altura = a;
    }

    /**
     * Crea un nou Rectangle amb el color per defecte, 
     * donades la seua base i la seua altura.
     * @param b double que representa la base.
     * @param a double que representa l'altura.
     */
    public Rectangle(double b, double a) { 
        this(COLOR_PER_DEFECTE, b, a); 
    }
    
    /**
     * Torna la base del Rectangle actual.
     * @return double, la base.
     */
    public double getBase() { return this.base; }

    /**
     * Torna l'altura del Rectangle actual.
     * @return double, l'altura.
     */ 
    public double getAltura() { return this.altura; }

    /**
     * Torna l'area del Rectangle actual.
     * @return double, l'area.
     */ 
    public double getArea() { return base * altura; }

    /**
     * Torna un String amb les dades del Rectangle actual.
     * @return String.
     */
    public String toString() {
        return super.toString() 
            + " de base " + this.base + ", altura " + this.altura;
    }
}