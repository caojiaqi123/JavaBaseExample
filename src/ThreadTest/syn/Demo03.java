package ThreadTest.syn;

/**
 * 单例创建的几种方式
 * 1。构造器私有化
 * 2。声明私有静态属性
 * 3。对外提供访问属性的方法
 */
public class Demo03 {
    public static void main(String[] args) {
        MyJVM2.test();
    }
}

/**
 * 懒汉模式
 */
class MyJVM {
    private static MyJVM instance = null;

    private MyJVM() {
    }

    public static MyJVM getInstance() {
        if (instance == null) {//提高效率
            synchronized (MyJVM.class) {
                if (instance == null) {//安全检测
                    instance = new MyJVM();
                }
            }
        }
        return instance;
    }
}

/**
 * 饿汉模式
 * 静态属性 在类加载的时候就已经初始化类 但是方法不会
 * 这边有个问题 可能为用不到这个类 不过 instance已经被初始化了
 */
class MyJVM2 {
    private static MyJVM2 instance = new MyJVM2();

    private int ins;

    private MyJVM2() {
    }

    public static MyJVM2 getInstance() {
        return instance;
    }

    public static void test() {
        System.out.println(1);
    }
}

/**
 * 静态属性
 * 静态属性在类加载的时候会被初始化 但是静态方法不会 只有在调用的时候才会加载
 * 延缓了加载时机
 */
class MyJVM3 {
    private static class JVMHolder {
        private static MyJVM3 instance = new MyJVM3();
        public JVMHolder(){
            System.out.println("初始化了内部类");
        }
    }

    public MyJVM3() {
    }

    public static MyJVM3 getInstance() {
        return JVMHolder.instance;
    }
    public static void test() {
        System.out.println(1);
    }
}