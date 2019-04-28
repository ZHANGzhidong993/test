import lock.TwinsLock;
import org.junit.Test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zhangzhidong
 * @create: 2019-04-28 22:06
 */
public class TestLock {

    @Test
    public void test() {
        final Lock lock = new ReentrantLock();

        class Worker extends Thread {
            public void run() {
                lock.lock();
                while (true) {

                }
            }
        }

        new Worker().start();

        lock.lock();


    }
}
