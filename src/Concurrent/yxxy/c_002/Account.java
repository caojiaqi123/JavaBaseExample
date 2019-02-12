package Concurrent.yxxy.c_002;

/**
 * @description 对写加锁 对读取 不加锁
 * 容易产生脏读
 * @params
 */
public class Account {
    String name;
    double balance;

    public synchronized void set(String name, double balance) {
        this.name = name;
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.balance = balance;
    }

    public /*synchronized*/ double getBalance(String name) {
        return balance;
    }

    public static void main(String[] args) throws InterruptedException {
        Account a = new Account();
        new Thread(() -> a.set("张三", 20000)).start();
        Thread.sleep(1000);
        System.out.println(a.getBalance("张三"));
        Thread.sleep(2000);
        System.out.println(a.getBalance("张三"));
    }
}
