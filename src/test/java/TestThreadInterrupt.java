import org.junit.Test;

/**
 * @author zhangzhidong
 * @create: 2019-03-21 22:07
 */
public class TestThreadInterrupt {

    @Test
    public void testInterrupted() {
        MyThread myThread = new MyThread();
        myThread.start();
        try {
            Thread.sleep(1000);
            myThread.interrupt();
            System.out.println("是否停止1？=" + myThread.interrupted());
            System.out.println("是否停止2？=" + myThread.interrupted());
        } catch (InterruptedException e) {
            System.out.println("main catch");
            e.printStackTrace();
        }
    }

    @Test
    public void testIsInterrupted() {
        MyThread myThread = new MyThread();
        myThread.start();
        try {
            Thread.sleep(1000);
            myThread.interrupt();
            System.out.println("是否停止1？=" + myThread.isInterrupted());
            System.out.println("是否停止2？=" + myThread.isInterrupted());
        } catch (InterruptedException e) {
            System.out.println("main catch");
            e.printStackTrace();
        }
    }
}
