package Concurrent.yxxy.c_003;

/**
 * @description 一个同步方法可以调用另一个同步方法，一个线程已经拥有某个对象对锁，
 * 再次申请时 仍然会得到该对象对锁
 * 也就是说synchronized获得对锁是可重入的(获得的锁可以在获得一遍)
 * @params
 */
public class T001 {
    synchronized void m1() {
        System.out.println("m1 start");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        m2();
    }

    synchronized void m2() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("m2");
    }

    public static void main(String[] args) {
        T001 t = new T001();
        t.m1();
    }
}
