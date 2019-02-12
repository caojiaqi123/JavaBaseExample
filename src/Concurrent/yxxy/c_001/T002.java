package Concurrent.yxxy.c_001;

public class T002 {
    private int count = 10;
    private Object o = new Object();

    public void m() {
        synchronized (this) {
            count--;
            System.out.println(Thread.currentThread().getName() + " count = " + count);
        }
    }
}
