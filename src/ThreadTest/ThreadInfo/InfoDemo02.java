package ThreadTest.ThreadInfo;

/**
 * MAX_PRIORITY 10
 * NORM_PRIORITY 5
 * MIN_PRIORITY 1
 * 优先级代表的是执行概率 没有先后顺序
 */
public class InfoDemo02 {
    /**
     * 没有手指优先级的时候 使用的是默认优先级
     */
    public static void main(String[] args) throws InterruptedException {
        MyThread mt = new MyThread();
        Thread t1 = new Thread(mt, "挨踢1");
        MyThread mt2 = new MyThread();
        Thread t2 = new Thread(mt2, "挨踢2");

        t1.setPriority(Thread.MAX_PRIORITY);
        t2.setPriority(Thread.MIN_PRIORITY);
        t1.start();
        t2.start();

        Thread.sleep(100);
//        mt.stop();
//        mt2.stop();
    }
}
