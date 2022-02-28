import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AnalyseBeholder {
    LinkedList<Pasient> beholder = new LinkedList<>();
    Lock laas = new ReentrantLock();
    Condition ikkeTom = laas.newCondition();

    void leggInn(Pasient p) throws InterruptedException{
        laas.lock();
        try {
            beholder.add(p);
            ikkeTom.signalAll();
        }
        finally {
            laas.unlock();
        }
    }
    Pasient hentUt() throws InterruptedException {
        laas.lock();
        try {
            while (beholder.size() == 0) {
                ikkeTom.await();
                return beholder.removeFirst();
            }

        }
        finally {
            laas.unlock();
        }
        return null;
    }

}
