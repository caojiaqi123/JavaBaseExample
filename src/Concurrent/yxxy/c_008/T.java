package Concurrent.yxxy.c_008;

import java.util.concurrent.TimeUnit;

/**
 * @description 锁定某个对象 如果对象的属性发生改变
 * 不影响锁的使用， 但是如果   对象o变成了另外一个对象
 * 则锁定对象发生改变 应该避免锁定对象的引用变成另外的对象
 * @params
 */
public class T {
    Object o = new Object();

    void m() {
        synchronized (o) {
            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
            }
        }
    }

    public static void main(String[] args) {
        T t = new T();
        new Thread(t::m, "t1").start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread t2 = new Thread(t::m, "t2");
      //  t.o = new Object();//正常情况t2永远执行不了 因为o 一直有锁
        //但是现在 对象锁发生改变 new object()这个对象没有锁 所以t2可以执行
        //ps 证明了锁其实是加在 堆内存这个对象上 而不是引用 栈上的o
        t2.start();
    }
}
