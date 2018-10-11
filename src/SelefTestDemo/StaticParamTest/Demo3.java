package SelefTestDemo.StaticParamTest;

/**
 * 类变量(static修饰) 成员变量(实例变量) 静态代码块 代码块 的初始化相关问题3
 * 包含继承关系的初始化顺序:
 * 1.父类静态代码块 和 父类类变量
 * 2.子类静态代码块 和 子类类变量
 * 3.父类代码块
 * 4.父类构造函数
 * 5.子类代码块
 * 6.子类构造函数
 *
 * 如果父类中定义了一个类变量 类型为子类 则显示顺序是？
 */
public class Demo3 {
    public static void main(String[] args) {
        new child();
    }
}

class Base {
    static int basex = 123;
    static child s = new child();//如果在父类

    static {
        System.out.println("父类静态代码块");
    }

    {
        System.out.println("父类代码块");
    }

    public Base() {
        System.out.println("父类构造函数");
    }
}

class child extends Base {
    static int childx = 456;

    static {
        System.out.println("子类静态代码块");
    }

    {
        System.out.println("子类代码块");
    }

    public child() {
        System.out.println("子类构造函数");
    }

}