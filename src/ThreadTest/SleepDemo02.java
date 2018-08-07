package ThreadTest;

public class SleepDemo02 {
    public static void main(String[] args) {
        //增加延时以后数据不准
        Web12306 web = new Web12306();

        Thread t1 = new Thread(web, "路人甲");
        Thread t2 = new Thread(web, "黄牛乙");
        Thread t3 = new Thread(web, "工程师");
        t1.start();
        t2.start();
        t3.start();
    }
}
