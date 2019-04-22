package threadpool;

/**
 * 线程池
 *
 * @author zhangzhidong
 * @since 2019/4/22
 */
public interface ThreadPool<Job extends Runnable> {

    void execute(Job job);

    /**
     * 关闭线程池
     */
    void shutdown();

    /**
     * 增加工作者线程
     *
     * @param num
     */
    void addWorkers(int num);

    /**
     * 减少工作者线程
     *
     * @param num
     */
    void removeWorker(int num);

    /**
     * 得到正在等待执行的任务数量
     *
     * @return
     */
    int getJobSize();
}
