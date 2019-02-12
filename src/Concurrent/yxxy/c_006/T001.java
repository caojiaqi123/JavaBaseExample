package Concurrent.yxxy.c_006;

/**
 * @description volatile 关键字 使一个变量在多个线程内可见
 * a b 线程都用同一个变量 java 默认是a线程中保留一份copy 这样如果b线程改了该变量
 * 则a线程未必直到 使用 volatile 则会让所有线程都会读到该变量都修改值
 * <p>
 * 下面代码中 running 是存在堆内存都t对象中
 * 当线程t1开始运行 则会把running值从内存中读取到t1线程工作区 在运行过程中直接使用这个copy 并不会
 * 每次都读取内存 这样 当主线程修改 running值当时候 t1感知不到 所以不会停止运行
 * <p>
 * 使用volatile 将会强制所有线程区堆内存读取
 * 阅读文章升入理解
 * https://www.cnblogs.com/nexiyi/p/java_memory_model_and_thread.html
 * <p>
 * 并不能保证多个线程共同修改running变量时带来的不一致问题 也就是说volatile 不能代替synchronized
 * @params
 */
public class T001 {
    /*volatile*/ boolean running = true;//对比下 有无 volatile 的情况下 程序区别

    void m() {
        System.out.println("m start");
        while (running) {
        }
        System.out.println("m end");
    }

    public static void main(String[] args) {
        T001 t = new T001();
        new Thread(() -> t.m(), "t1").start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t.running = false;
        //使用volatile 一旦内容有改变 会通知其他线程 刷新
    }
}
