package usaLinear;

import linear.ListPIIntLinked;
/**
 * Classe programa que prova els mètodes de OpsLlistes.
 *
 * @author PRG
 * @version Curs 2019/20
 */
public class TestOpsLlistes {
    private TestOpsLlistes() { }
    
    public static void main(String[] args) {
        int[] dades1 = {7, 8, 11, 25, 40};
        ListPIIntLinked lpi1 = new ListPIIntLinked();
        for (int i = 0; i < dades1.length; i++) {
            lpi1.insert(dades1[i]);
        }
        System.out.println("Llista 1: " + lpi1.toString());
    
        int[] dades2 = {1, 3, 7, 11, 40, 89};
        ListPIIntLinked lpi2 = new ListPIIntLinked();
        for (int i = 0; i < dades2.length; i++) {
            lpi2.insert(dades2[i]);
        }
        System.out.println("Llista 2: " + lpi2.toString());
        
        ListPIIntLinked lpiIntersectSort = OpsLlistes.intersectSort(lpi1, lpi2);
        System.out.println("Llista Intersecció Ordenada: " + lpiIntersectSort.toString() + "\n");
        
        int[] dades3 = {11, 7, 8, 40};
        lpi1 = new ListPIIntLinked();
        for (int i = 0; i < dades3.length; i++) {
            lpi1.insert(dades3[i]);
        }
        System.out.println("Llista 1: " + lpi1.toString());
    
        int[] dades4 = {40, 89, 7, 1, 11, 3};
        lpi2 = new ListPIIntLinked();
        for (int i = 0; i < dades4.length; i++) {
            lpi2.insert(dades4[i]);
        }
        System.out.println("Llista 2: " + lpi2.toString());
        
        ListPIIntLinked lpiIntersection = OpsLlistes.intersection(lpi1, lpi2);
        System.out.println("Llista Intersecció: " + lpiIntersection.toString() + "\n");
        
        int[] dades5 = {8, 7, 11, 25, 7, 13};
        lpi1 = new ListPIIntLinked();
        for (int i = 0; i < dades5.length; i++) {
            lpi1.insert(dades5[i]);
        }
        System.out.println("Llista 1: " + lpi1.toString());
    
        int[] dades6 = {1, 3, 7, 11, 13, 17, 19};
        lpi2 = new ListPIIntLinked();
        for (int i = 0; i < dades6.length; i++) {
            lpi2.insert(dades6[i]);
        }
        System.out.println("Llista 2: " + lpi2.toString());
        
        OpsLlistes.dif(lpi1, lpi2);
        System.out.println("Llista 1 després de dif: " + lpi1.toString() + "\n");
        
        int[] dades7 = {1, 4, 5, 7, 8};
        lpi1 = new ListPIIntLinked();
        for (int i = 0; i < dades7.length; i++) {
            lpi1.insert(dades7[i]);
        }
        System.out.println("Llista 1: " + lpi1.toString());
    
        int[] dades8 = {2, 3, 6};
        lpi2 = new ListPIIntLinked();
        for (int i = 0; i < dades8.length; i++) {
            lpi2.insert(dades8[i]);
        }
        System.out.println("Llista 2: " + lpi2.toString());
        
        ListPIIntLinked lpiMerge = OpsLlistes.merge(lpi1, lpi2);
        System.out.println("Llista Merge: " + lpiMerge.toString() + "\n");
        
        int[] dades9 = {6, 2, 6};
        lpi1 = new ListPIIntLinked();
        for (int i = 0; i < dades9.length; i++) {
            lpi1.insert(dades9[i]);
        }        
    
        int[] dades10 = {1, 6, 1, 2, 3, 6, 4};
        lpi2 = new ListPIIntLinked();
        for (int i = 0; i < dades10.length; i++) {
            lpi2.insert(dades10[i]);
        }
        
        boolean immersa = OpsLlistes.immersa(lpi1, lpi2);
        System.out.println(lpi1.toString() + " immersa en " + lpi2.toString() + "? " + immersa);
        
        int[] dades11 = {6, 5, 6};
        lpi1 = new ListPIIntLinked();
        for (int i = 0; i < dades11.length; i++) {
            lpi1.insert(dades11[i]);
        }
        
        immersa = OpsLlistes.immersa(lpi1, lpi2);
        System.out.println(lpi1.toString() + "  immersa en " + lpi2.toString() + "? " + immersa);
        
        int[] dades12 = {6, 1, 6};
        lpi1 = new ListPIIntLinked();
        for (int i = 0; i < dades12.length; i++) {
            lpi1.insert(dades12[i]);
        }
        
        immersa = OpsLlistes.immersa(lpi1, lpi2);
        System.out.println(lpi1.toString() + " immersa en " + lpi2.toString() + "? " + immersa);
    }
}
