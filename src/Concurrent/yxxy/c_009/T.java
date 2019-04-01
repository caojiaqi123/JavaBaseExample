package Concurrent.yxxy.c_009;

/**
 * @description 不要以字符串常量作为锁定对象
 * 锁都是加在对象上的 字符串常量指向的对象是同一个 所以看上去是两把锁 其实是同一把锁
 * 容易造成死锁
 * @params
 */
public class T {
    String s1 = "hello";
    String s2 = "hello";

    void m1() {
        synchronized (s1) {
        }
    }

    void m2() {
        synchronized (s2) {
        }
    }
}
