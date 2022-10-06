package linear;


/**
 * Write a description of class TextExamen here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TextExamen {
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class TextExamen
     */
    public TextExamen() { }

    public static void main(String args[]) {
        ListPIIntLinked li1 = new ListPIIntLinked();
        for (int i = 0; i < 10; i++) {
            li1.insert(i);
        }
        System.out.println("---------------------------------");
        System.out.println(li1.toString() + "\n" + "executant metode...");
        li1.removeLessThanInOrd(4);
        System.out.println("després del metode..." + "\n" + li1.toString());
        System.out.println("---------------------------------");
        ListPIIntLinked li2 = new ListPIIntLinked();
        for (int i = 10; i >= 0; i--) {
            li2.insert(i);
        }
        System.out.println(li2.toString() + "\n" + "executant metode...");
        li2.removeLessThanInOrd(4);
        System.out.println("després del metode..." + "\n" + li2.toString());
        System.out.println("---------------------------------");
        ListPIIntLinked li3 = new ListPIIntLinked();
        li3.insert(5);
        li3.insert(6);
        li3.insert(7);
        li3.insert(8);
        li3.insert(9);
        li3.insert(10);
        li3.begin();
        System.out.println(li3.toString() + "\n" + "executant metode...");
        li1.removeLessThanInOrd(4);
        System.out.println("després del metode..." + "\n" + li3.toString());
    }
}
