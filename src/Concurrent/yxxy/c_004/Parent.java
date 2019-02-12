package Concurrent.yxxy.c_004;

public class Parent {
    synchronized void m() {
        System.out.println("m start");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("m end");
    }

    public static void main(String[] args) {
        //锁定的都是 new child
        new child().m();
    }
}

class child extends Parent {
    @Override
    synchronized void m() {
        System.out.println("child start");
        super.m();//重入锁的第二种情形 子类掉父类
        System.out.println("child end");
    }
}
