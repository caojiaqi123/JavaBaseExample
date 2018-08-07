package ThreadTest;

/**
 * 合并线程
 */
public class JoinDemo01 extends Thread {
    public static void main(String[] args) throws InterruptedException {

        JoinDemo01 j = new JoinDemo01();
        Thread t = new Thread(j);//新生
        t.start();//就绪
        //cpu 调度


        for (int i = 0; i < 500; i++) {
            if (i == 100) {
                t.join();// main方法阻塞
            }
            System.out.println("main ..." + i);

        }
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("join ..." + i);

        }
    }
}
