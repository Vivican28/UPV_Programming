package linear;
import java.util.Arrays;
/**
 * Classe TestUtilLinked: classe programa per a provar els mètodes de UtilLinked.
 *
 * @author PRG
 * @version Curso 2019/20
 */
public class TestUtilLinked {
    private TestUtilLinked() { }
    
    public static void main(String[] args) {
        //1. Crear una seqüència enllaçada amb els 10 primers
        //   numeros senars: 1, 3, 5, 7, 9, 11, 13, 15, 17, 19
        NodeInt seq = null;
        for (int n = 10; n > 0; n--) seq = new NodeInt(2 * n - 1, seq);
      
            
        //2. Mostrar per pantalla la seqüència i el número de dades que té
        System.out.println(UtilLinked.toString(seq));
        System.out.println("Talla: " + UtilLinked.talla(seq));
        
        //3. Mostrar per pantalla la posició de les següents dades: 
        //   1, 13, 19 y 20
        System.out.println("El 1 está en ... " + UtilLinked.cercarPos(seq, 1));
        System.out.println("El 13 está en ... " + UtilLinked.cercarPos(seq, 13));
        System.out.println("El 19 está en ... " + UtilLinked.cercarPos(seq, 19));
        System.out.println("El 20 está en ... " + UtilLinked.cercarPos(seq, 20)); 
        
        //4. Mostrar per pantalla el valor més gran.
        System.out.println("El valor més gran és ... " + UtilLinked.maxim(seq));
        
        //5. Afegir les següents dades: 
        //   0 en la posició 0
        //   20 en la posició 11
        //   8 en la posició 5
        //   100 en la posició 20
        seq = UtilLinked.insert(seq, 0, 0);
        seq = UtilLinked.insert(seq, 20, 11);
        seq = UtilLinked.insert(seq, 8, 5);
        seq = UtilLinked.insert(seq, 100, 20);
        
        //6. Mostrar per pantalla les dades de la seqüència
        //   Has d'obtenir [0, 1, 3, 5, 7, 8, 9, 11, 13, 15, 17, 19, 20]
        System.out.println(UtilLinked.toString(seq));
        
        //7. Canviar de signe el valor 9
        UtilLinked.canviarSigne(seq, 9);
        
        //8. Afegir en ordre els següents valors:
        //   -1, 14, 25 
        seq = UtilLinked.insertSort(seq, -1);
        seq = UtilLinked.insertSort(seq, 14);
        seq = UtilLinked.insertSort(seq, 25);
        
        //9. Mostrar per pantalla les dades de la seqüència
        //   Has d'obtenir [-1, 0, 1, 3, 5, 7, 8, -9, 11, 13, 14, 15, 17, 19, 20, 25]
        System.out.println(UtilLinked.toString(seq));
        
        //10. Eliminar les següents dades: 0, 20, 25 y 8
        seq = UtilLinked.delete(seq, 0);
        seq = UtilLinked.delete(seq, 20);
        seq = UtilLinked.delete(seq, 25);
        seq = UtilLinked.delete(seq, 8);
        
        //11. Mostrar per pantalla les dades de la seqüència
        //   Has d'obtenir [-1, 1, 3, 5, 7, -9, 11, 13, 14, 15, 17, 19]
        System.out.println(UtilLinked.toString(seq));
        
        //12. Saturar les dades de la seqüència al valor 10
        UtilLinked.saturar(seq, 10);
        
        //13. Mostrar per pantalla les dades de la seqüència
        //   Has d'obtenir [-1, 1, 3, 5, 7, -9, 10, 10, 10, 10, 10, 10]
        System.out.println(UtilLinked.toString(seq));
        
        //14. Obtenir una nova seqüència que continga només
        //    les dades menors que 10
        NodeInt seqMen = null; seqMen = UtilLinked.menorsQue(seq, 10);
        
        //15. Mostrar aquesta nova seqüència.
        //  Has d'obtenir [-1, 1, 3, 5, 7, -9]
        System.out.println(UtilLinked.toString(seqMen));
        
        //16. Obtenir un altra seqüència que siga la inversió d'aquesta última
        NodeInt seqInv = null; seqInv = UtilLinked.invertir(seqMen);
        
        //17. Mostrar aquesta nova seqüència.
        //   Has d'obtenir [-9, 7, 5, 3, 1, -1]
        System.out.println(UtilLinked.toString(seqInv));
        
        //18. Convertir aquesta seqüència en un array i mostrar-lo per pantalla
        int[] a = UtilLinked.toArray(seqInv);
        System.out.println(Arrays.toString(a));
        
        //19. Crear una seqüència a partir de l'array {0, -3, 5, 2, 7, 8}
        int[] aS = {0, -3, 5, 2, 7, 8};
        NodeInt seqA = UtilLinked.toSeq(aS);
        
        //20. Mostrar la seqüència per pantalla
        System.out.println(UtilLinked.toString(seqA));
    }
}
