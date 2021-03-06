import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * @author zhangzhidong
 * @create: 2019-04-03 22:53
 */
public class MultiThread {

    public static void main(String[] args) {
        //获取Java线程管理MXBean
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        //不需要获取同步的monitor和synchronized信息，仅获取线程和线程堆栈信息
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);
        for (ThreadInfo threadInfo : threadInfos) {

            System.out.println("[" + threadInfo.getThreadId() + "]" + threadInfo.getThreadName());

        }

    }
}
