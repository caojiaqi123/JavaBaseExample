package ThreadTest.syn;

/**
 * 单例设计模式：外部使用时一个类只有一个对象
 */
public class Demo02 {
    public static void main(String[] args) {

        JvmThread j1 = new JvmThread(100);
        JvmThread j2 = new JvmThread(400);
        j1.start();
        j2.start();
    }
}

/**
 *
 * */
class JvmThread extends Thread {
    private int time;

    public JvmThread() {
    }

    public JvmThread(int time) {
        this.time = time;
    }

    @Override
    public void run() {
        //模拟多线程时 单例模式 错误的情况
        //打印多线程 懒汉模式地址不一致
        System.out.println(Jvm.getInstance3(time));
    }
}

/**
 * 单例模式：
 * 1。构造器私有化
 * 2。声明一个私有的静态变量
 * 3。创建一个对外的静态公共方法，如果变量没有对象 则创建对象
 * 这种懒汉模式线程不安全
 */
class Jvm {

    //构造器私有化
    private Jvm() {
    }

    private static Jvm instance = null;

    /**
     * 这种懒汉模式有问题，多线程下地址不一致
     */
    public static Jvm getInstance(long time) {
        if (null == instance) {
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            instance = new Jvm();
        }
        return instance;
    }

    /**
     * 最简单的方式加synchronized
     */
    public synchronized static Jvm getInstance1(long time) {
        if (null == instance) {
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            instance = new Jvm();
        }
        return instance;
    }

    /**
     * */
    public static Jvm getInstance2(long time) {
        // 线程 a b 到此处 都需要等待 -->每次都需要等待 哪怕时已经创建过对象了 效率比较低
        //获取字节码信息的锁
        synchronized (Jvm.class) {
            if (null == instance) {
                try {
                    Thread.sleep(time);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                instance = new Jvm();
            }
        }
        return instance;
    }

    /**
     * 优化 先判断是否有对象 如果有对象 直接返回
     * 没有对象才进行锁定
     * 双重锁检测
     */
    public static Jvm getInstance3(long time) {
        if (null == instance) {
            synchronized (Jvm.class) {
                if (null == instance) {
                    try {
                        Thread.sleep(time);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    instance = new Jvm();
                }
            }
        }
        return instance;
    }
}