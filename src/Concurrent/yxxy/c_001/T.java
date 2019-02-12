package Concurrent.yxxy.c_001;

/**
*@description synchronized
 * 给某个对象加锁
*@params
*/
public class T {
    private int count = 10;
    private Object o = new Object();

    public void m() {
        synchronized (o) {//执行下面代码需要执行下面代码 必须先拿到o的锁
            count--;
            System.out.println(Thread.currentThread().getName() + " count = " + count);
        }
    }
}
