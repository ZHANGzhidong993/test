import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zhangzhidong
 * @create: 2019-04-03 23:12
 */
public class ThreadState {

    private static AtomicInteger i = new AtomicInteger(0);
    private static AtomicBoolean flag = new AtomicBoolean(true);

    public static void main(String[] args) throws InterruptedException {
       final CountDownLatch countDownLatch = new CountDownLatch(2);

        Thread thread1 = new Thread(new Runnable() {

            public void run() {
                while (i.get() <= 100) {
                    if (flag.get()) {
                        System.out.println(Thread.currentThread().getName() + " : " + i.getAndIncrement());
                        flag.compareAndSet(true,false);
                    }
                }
                countDownLatch.countDown();
            }
        });
        thread1.setName("thread1");
        thread1.start();
        Thread thread2 = new Thread(new Runnable() {

            public void run() {
                while (i.get() < 100) {
                    if (!flag.get()) {
                        System.out.println(Thread.currentThread().getName() + " : " + i.getAndIncrement());
                        flag.compareAndSet(false,true);
                    }
                }
                countDownLatch.countDown();
            }
        });
        thread2.setName("thread2");
        thread2.start();
        countDownLatch.await();

    }
}
