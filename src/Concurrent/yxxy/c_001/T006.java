package Concurrent.yxxy.c_001;

/**
 * @description 同步方法和非同步方法是否可以同时调用
 * @params
 */
public class T006 {
    public synchronized void m1() {
        System.out.println(Thread.currentThread().getName() + " m1 start...");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " m1 end...");
    }

    public void m2() {
        System.out.println(Thread.currentThread().getName() + " m2 start...");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " m2 ");
    }

    public static void main(String[] args) {
        T006 t = new T006();
        new Thread(() -> t.m1(), "t1").start();
        new Thread(() -> t.m2(), "t2").start();
        //结论 同步方法不影响 非同步方法的调用 只有调用m1的时候才需要申请锁
        // 执行m1的时候是锁定了整个对象 不过执行m2不需要获得锁 所以 可以执行

//        new Thread(t::m1,"t1").start();
//        new Thread(t::m2,"t2").start();
    }
}
