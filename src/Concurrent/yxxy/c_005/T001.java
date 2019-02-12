package Concurrent.yxxy.c_005;

/**
 * @description 程序执行过程中 如果出现异常 锁默认会被释放
 * 所以在并发处理中 有异常需要小心
 * 例如 在一个web app处理过程中 多个servlet线程共同访问同一个资源 如果处理异常不合适
 * 在第一个线程中抛出 其他线程会进入同步代码区 有可能会访问到异常产生的数据
 * 因此 要非常小心的处理同步业务逻辑中的异常
 * @params
 */
public class T001 {
    int count = 0;

    synchronized void m() {
        System.out.println(Thread.currentThread().getName() + " start");
        while (true) {
            count++;
            System.out.println(Thread.currentThread().getName() + " count = " + count);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (count == 5) {
                int i = 1 / 0; //抛出异常 如果不想抛出 进行catch
            }
        }
    }

    public static void main(String[] args) {
        T001 t = new T001();
        Runnable r = new Runnable() {
            @Override
            public void run() {
                t.m();
            }
        };

        new Thread(r, "t1").start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //不抛异常锁永远不会被释放 则 t2永远不会被启动
        new Thread(r, "t2").start();

    }
}
