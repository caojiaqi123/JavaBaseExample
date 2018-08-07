package ThreadTest;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 倒计时10个数
 */
public class SleepDemo {
    public static void main(String[] args) throws InterruptedException {
        Date endDate = new Date(System.currentTimeMillis() + 10 * 1000);
        long end = endDate.getTime();
        while (true) {
            System.out.println(new SimpleDateFormat("mm:ss").format(endDate));
            endDate = new Date(endDate.getTime() - 1000);
            Thread.sleep(1000);
            if (end - 10000 > endDate.getTime()) {
                break;
            }
        }
    }
}
