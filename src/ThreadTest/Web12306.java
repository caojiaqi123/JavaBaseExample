package ThreadTest;

public class Web12306 implements Runnable {
    private int num = 50;

    @Override
    public void run() {
        while (true) {
            if (num <= 0) {
                break;
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "抢到第" + num-- + "张");
        }
    }

    public static void main(String[] args) {

        Web12306 web = new Web12306();

        Thread t1 = new Thread(web, "路人甲");
        Thread t2 = new Thread(web, "黄牛乙");
        Thread t3 = new Thread(web, "工程师");
        t1.start();
        t2.start();
        t3.start();
    }
}
