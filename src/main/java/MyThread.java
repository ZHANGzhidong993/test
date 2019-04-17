/**
 * @author zhangzhidong
 * @create: 2019-03-21 22:10
 */
public class MyThread extends Thread {

    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 250000; i++) {
            System.out.println("i=" + (i + 1));
        }
    }
}
