import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zhangzhidong
 * @create: 2019-05-02 21:47
 */
public class FairAndUnfairTest {

    private static Lock fairLock = new ReentrantLock2(true);
    private static Lock unfairLock = new ReentrantLock2(false);

    @Test
    public void fair() {
        testLock(fairLock);
    }

    @Test
    public void unfair() {
        testLock(unfairLock);
    }

    private void testLock(Lock lock) {
        for (int i = 0; i < 5; i++) {
            Job job = new Job(lock);
            job.setName(i + "");
            job.start();
        }
    }


    private static class Job extends Thread {
        private Lock lock;

        public Job(Lock lock) {
            this.lock = lock;
        }

        public void run() {
            //连续两次打印当前的Thread 和等待队列中的Thread
            ReentrantLock2 lock = (ReentrantLock2) this.lock;
            StringBuffer stringBuffer = new StringBuffer();
            Collection<Thread> queuedThreads = lock.getQueuedThreads();
            for (Thread queuedThread : queuedThreads) {
                stringBuffer.append(queuedThread.getName());
                stringBuffer.append(",");
            }
            System.out.println("Lock by [" + Thread.currentThread().getName() + "], Waiting by [" + stringBuffer.toString() + "]");
            System.out.println("Lock by [" + Thread.currentThread().getName() + "], Waiting by [" + stringBuffer.toString() + "]");
        }
    }

    private static class ReentrantLock2 extends ReentrantLock {
        public ReentrantLock2(boolean fair) {
            super(fair);
        }

        public Collection<Thread> getQueuedThreads() {
            List<Thread> arrayList = new ArrayList<>(super.getQueuedThreads());
            Collections.reverse(arrayList);
            return arrayList;
        }
    }
}
