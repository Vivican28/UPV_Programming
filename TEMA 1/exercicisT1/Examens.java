
/**
 * Write a description of class Examens here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Examens {
    // Curs 18/19
    public static boolean capicuaK(int[] a, int ini, int fi, int k) {
        if (fi <= ini) return true;
        else {
            int diff = Math.abs(a[ini] - a[fi]);
            return diff < k && capicuaK(a, ini + 1, fi - 1, k - 1);
        }
    }
    public static void escriuCapi(int n) {
        if (n < 10) System.out.print(n + "" + n);
        else {
            System.out.print(n % 10);
            escriuCapi(n / 10);
            System.out.print(n % 10);
        }
    }
    
    // Curs 17/18
    public static int comptar(String[] a, int b, int pos) {
        if (pos == a.length) return 0;
        else {
            if (a[pos].length() == b) return 1 + comptar(a, b, pos + 1);
            else return comptar(a, b, pos + 1);
        }
    }
    public static int intercepts(double[] a, int ini) {
        if (ini >= a.length) return -1;
        else if (a[ini] == 0.0) return ini;
        else if (a[ini] > 0.0) return -1;
        else  return intercepts(a, ini + 1); 
    }
    public static int interceptsBin(double[] a, int ini, int fi){
        if (ini > fi) return -1;
        else {
            int meitat = (fi + ini) / 2; // NO ENTIENDO por qué se suman i no restan
            if (a[meitat] == 0.0) return meitat;
            else if (a[meitat] > 0) return interceptsBin(a, ini, meitat - 1);
            else return interceptsBin(a, meitat + 1, fi);      
        }                               
    }
    
    // Curs 16/17
    public static int multiples(int[] a, int ini, int x) {
        if (ini >= a.length) return 0;
        else {
            if (a[ini] % x == 0) return multiples(a, ini + 1, x);
            else return 1 + multiples(a, ini + 1, x);
        }
    }

    public static int[] numTriang(int n) {
        int[] res = new int[n];
        numTriang(res, n - 1); // FIns n - 1 perquè l'array va des de 0
        return res;
    }
    private static void numTriang(int[] a, int n) {
        if (n == 0) a[n] = 0;
        else {
            numTriang(a, n - 1);
            a[n] = n + a[n - 1];
        }
    }

    // Curs 15/16
    public static int sumOrdAsc(int[] a, int x, int ini) {
        if (ini >= a.length) return 0;
        else {
            if (a[ini] <= x) return a[ini] + sumOrdAsc(a, x, ini + 1); 
            else return 0;
        }
    }
    public static boolean fibDesc(int[] a, int ini) {
        if (ini == 0) return a[0] == 0;
        else if (ini == 1) return a[1] == 1 && a[0] == 0;
        else return a[ini] == a[ini - 1] + a[ini - 2] && fibDesc(a, ini - 1);
        
    }
    
    // Curs 14/15
    public static boolean parellsICreixents(int[] a, int ini) {
        if (ini > a.length - 1) return a[ini] % 2 == 0;
        else return (a[ini] % 2 == 0) && a[ini] <= a[ini + 1] && parellsICreixents(a, ini + 1);
    }
    
    // Curs 13/14
    public static int sumaCapicua(int[] a, int ini, int fi) {
        int sum = 0;
        if (ini > fi || a[ini] != a[fi]) return 0;
        else if (ini == fi) return a[ini];
        else return a[ini] + a[fi] + sumaCapicua(a, ini + 1, fi - 1);
    }
    public static boolean fibAsc(int[] a, int ini) {
        if (ini == a.length) return true;
        if (a[0] != 0 || a[1] != 1) return false;
        else return a[ini] == a[ini - 1] + a[ini - 2] && fibAsc(a, ini + 1); 
    }
    
    // Curs 2012/13
    public static int sim(int[] a, int ini, int fi, int m) {
        if (ini > fi) return -1;
        else if (a[ini] + a[fi] == m) return ini;
        else return sim(a, ini + 1, fi - 1, m);
    }
    public static boolean baseMenor(int n, int b) {
        if (n == 0) return true;
        else {
            int val = n % 10;
            if (val < b) return baseMenor(n / 10, b);
            else return false;
        }
    }
    public static int numMajors(double[] a, double x, int pos) {
        int cont = 0;
        if (pos >= a.length) return cont;
        else {
            if (a[pos] > x) cont++;
            return cont + numMajors(a, x, pos + 1);
        }
    }
    
    // Curs 2011/12
    public void escriuSeq(int n) {
        if (n > 0) { 
            System.out.print(n + " ");
            escriuSeq(n - 1);
            System.out.print(" " + n);
        }
        else System.out.print("0\n0");
    }
    public static boolean sumSim(int x, int ini, int fi, int[] v) {
        if (ini > fi) return true; 
        else if (v[ini] + v[fi] != x) return false;
        else return v[ini] + v[fi] == x && sumSim(x, ini + 1, fi - 1, v);
    }
    public static boolean progGeo(int[] a, int i, int x) {
        if (i == a.length - 1) return true;
        else {
            if (a[i + 1] == a[i] * x) return progGeo(a, i + 1, x);
            else return false;
        }
    }
    public void seq(int i) {
        if (i == 0) System.out.print(0);
        else {
            System.out.print(-i + " ");
            seq(i - 1);
            System.out.print(" " + i);
        }
    }
    
    // REPÀS
    public static boolean capiK(int[] a, int ini, int fi, int k) {
        if (ini > fi) return true;
        else {
            int dif = Math.abs(a[ini] - a[fi]);
            return dif < k && capiK(a, ini + 1, fi - 1, k - 1);
        }
    }
    
}
