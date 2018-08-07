package ThreadTest.syn;

import java.util.Hashtable;

/**
 * 一般锁定对象
 * */
public class Demo01 {
    public static void main(String[] args) {

        Web12306 web = new Web12306();

        Thread t1 = new Thread(web, "路人甲1");
        Thread t2 = new Thread(web, "黄牛乙1");
        Thread t3 = new Thread(web, "工程师1");
        t1.start();
        t2.start();
        t3.start();
    }


}

class Web12306 implements Runnable {
    private int num = 20;
    private boolean flag = true;

    @Override
    public void run() {
        while (flag) {
            test3();
        }
    }

    /**
     * 线程不安全 锁定资源不正确
     */
    private void test5() {
        //锁定this 指当前对象 web12306
        synchronized ((Integer) num) {
            if (num <= 0) {
                flag = false;
                return;//需要return返回 不允许在往下执行
            }
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "抢到第" + num-- + "张");
        }
    }

    /**
     * 锁定范围过小
     */
    private void test4() {
        //锁定this 指当前对象 web12306
        synchronized (this) {
            if (num <= 0) {
                flag = false;
                return;//需要return返回 不允许在往下执行
            }
        }
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "抢到第" + num-- + "张");
    }

    /**
     * 同步块
     */
    private void test3() {
        //锁定this 指当前对象 web12306
        synchronized (this) {
            if (num <= 0) {
                flag = false;
                return;//需要return返回 不允许在往下执行
            }
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "抢到第" + num-- + "张");
        }
    }


    /**
     * 同步方法 在方法签名中增加synchronized关键字
     */
    private synchronized void test2() {
        if (num <= 0) {
            flag = false;
            return;//需要return返回 不允许在往下执行
        }
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "抢到第" + num-- + "张");
    }


    /**
     * 线程不安全
     */
    private void test1() {
        if (num <= 0) {
            flag = false;
        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "抢到第" + num-- + "张");

    }
}