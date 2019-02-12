package Concurrent.yxxy.c_001;

public class T003 {
    private int count = 10;
    private Object o = new Object();

    /**
    *@description 锁定其实时锁定当前对象
    *@params
    */
    public synchronized void m() {//等同于执行synchronized (this)
        count--;
        System.out.println(Thread.currentThread().getName() + " count = " + count);

    }
}
