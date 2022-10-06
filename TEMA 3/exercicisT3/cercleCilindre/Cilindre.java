package cercleCilindre;

/**
 * Classe Cilindre - Descripcio d'un cilindre
 * 
 * @author PRG
 * @version Curs 2019/20
 */
public class Cilindre extends Cercle {  
    private double altura;

    /**
     * Crea un nou Cilindre donats el seu color, el radi de la seua base 
     * i la seua altura.
     * @param color String que representa el color.
     * @param radiBase double que representa el radi de la base.
     * @param alt double que representa l'altura.
     */
    public Cilindre(String color, double radiBase, double alt) {
        //Opcio a) CORRECTA
        super(radiBase, color);
        super.tipus = "Cilindre";
        altura = alt;        
        
        // Opcio b) INCORRECTA
        //super.color = color;
        //super.radi = radiBase;
        //super.tipus = "Cilindre";
        //altura = alt;
    }
       
    /**
     * Torna l'altura del Cilindre actual.
     * @return double, l'altura.
     */
    public double getAltura() { return this.altura; }
    
    /**
     * Actualitza l'altura del Cilindre actual.
     * @param a double que representa la nova altura.
     */
    public void setAltura(double a) { this.altura = a; }
    
    /**
     * Torna l'area del Cilindre actual.
     * @return double, l'area.
     */
    public double getArea() {             
        return 2 * super.getArea()
            + super.getPerimetre() * altura; 
    }
    
    /**
     * Torna el volum del Cilindre actual.
     * @return double, el volum.
     */
    public double getVolum() {         
        return super.getArea() * altura; 
    }
    
    /**
     * Torna un String amb les dades del Cilindre actual.
     * @return String.
     */
    public String toString() {
        return super.toString() + " i altura: " + altura;     
    }      
}