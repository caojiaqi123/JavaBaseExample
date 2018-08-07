package ThreadTest;

public class YieldDemo01 extends Thread {
    public static void main(String[] args) throws InterruptedException {

        YieldDemo01 j = new YieldDemo01();
        Thread t = new Thread(j);//新生
        t.start();//就绪
        //cpu 调度


        for (int i = 0; i < 1000; i++) {
            if (i % 20 == 0) {
               Thread.yield();//静态方法，写在那个线程体里 就暂停谁
            }
            System.out.println("main ..." + i);

        }
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("yield ..." + i);
        }
    }
}
