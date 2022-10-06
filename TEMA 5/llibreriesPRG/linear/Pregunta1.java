package linear;


/**
 * Write a description of class Pregunta1 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Pregunta1 {
    private Pregunta1() { }
    public static QueueIntLinked removeMajorsQue(QueueIntLinked q, int x) {
        QueueIntLinked res = new QueueIntLinked();
        while (!q.empty()) {
            int e = q.remove();
            if (e > x) res.add(e);
            else  q.add(e); 
        }
        return res;
    }
}
