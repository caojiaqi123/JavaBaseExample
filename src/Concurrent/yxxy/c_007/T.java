package Concurrent.yxxy.c_007;

import java.util.ArrayList;
import java.util.List;

/**
 * @description volatile并部保证多个线程共同修改running变量时所带来的不一致问题，也就是说volite
 * 不能代替synchronized
 *
 * @params
 */
public class T {
    volatile int count = 0;

    void m() {
        for (int i = 0; i < 10000; i++) {
            count++;
        }
    }

    public static void main(String[] args) {
        T t = new T();
        List<Thread> threadList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            threadList.add(new Thread(t::m, "thread-" + i));
        }
        threadList.forEach((o) -> o.start());
        threadList.forEach((o) -> {
            try {
                o.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println(t.count);
        //正常情况应该时10w 说明保证可见性 并不能代替 同步
    }
}
