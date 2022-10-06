package linear;
import java.util.NoSuchElementException;
import linear.ListPIIntLinked;

/**
 * Write a description of class ProblemesListPI here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ProblemesListPI {
    public static ListPIIntLinked compress(ListPIIntLinked l) {
        ListPIIntLinked result = new ListPIIntLinked();
        int n = l.size();
        l.begin();
        if (n >= 2) {
            int e1 = l.get(); l.next();
            int e2 = l.get(); l.next();
            result.insert(e1 * 2 + e2);
            n = n - 2;
        }
        if (n == 1) result.insert(l.get() - 2);
        return result;
    }
    public static ListPIIntLinked esborrar(ListPIIntLinked l, int x) {
        ListPIIntLinked result = new ListPIIntLinked();
        l.begin();
        while (!l.isEnd()) {
            if (l.get() == x) {
                result.insert(x);
                l.remove();
            }
            else l.next();
        }
        return result;
    }
}
