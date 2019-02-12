package Concurrent.yxxy.c_001;

/**
 * @description 分析输出 线程重入问题
 * 解决方法 放开 synchronized
 * @params
 */
public class T005 implements Runnable {
    private int count = 10;

    @Override
    public synchronized void run() {
        count--;
        System.out.println(Thread.currentThread().getName() + " count = " + count);
    }

    public static void main(String[] args) {
        T005 t = new T005();
        for (int i = 0; i < 6; i++) {
            new Thread(t, "thread " + i).start();
        }
    }
}
