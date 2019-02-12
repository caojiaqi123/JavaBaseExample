package Concurrent.yxxy.c_001;

public class T004 {
    private static int count = 10;

    public synchronized static void m() {//等同于执行synchronized (T004.class)
        count--;
        System.out.println(Thread.currentThread().getName() + " count = " + count);
    }

    public static void mm() {
        synchronized (T004.class) {
            //
            count--;
        }
    }
}
