package ThreadTest.ThreadInfo;

/**
 * thread.currentthread()
 * 静态方法 在哪个线程调用就指哪个线程
 */
public class InfoDemo01 {
    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new MyThread();
        Thread proxy = new Thread(myThread, "T1");
        proxy.setName("t2");
        System.out.println(proxy.getName());
        System.out.println(Thread.currentThread().getName());//PS 这个里面调用的main线程的名称

        proxy.start();
        System.out.println("启动会状态" + proxy.isAlive());
        Thread.sleep(100);
//        System.out.println("休眠状态" + proxy.isAlive());
        myThread.stop();
        Thread.sleep(100);
        System.out.println("调用停止后状态" + proxy.isAlive());
    }
}
