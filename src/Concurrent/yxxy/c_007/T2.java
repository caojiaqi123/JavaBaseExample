package Concurrent.yxxy.c_007;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @description java里面提供了一些原子类 AtomXXX类
 * 这种类本身方法都是原子性都 但不保证连续调用是原子性的
 * @params
 */
public class T2 {
    AtomicInteger count = new AtomicInteger(0);

    /* synchronized  */ void m() {
        for (int i = 0; i < 10000; i++) {
            count.incrementAndGet();//不用在加synchronized 用的是系统底层实现
            //用来替代count++ count++不具备原子性
        }
    }

    public static void main(String[] args) {
        T2 t = new T2();
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            threads.add(new Thread(t::m, "thread-" + i));

        }
        threads.forEach((o) -> o.start());
        threads.forEach((o) -> {
            try {
                o.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println(t.count);
    }
}
