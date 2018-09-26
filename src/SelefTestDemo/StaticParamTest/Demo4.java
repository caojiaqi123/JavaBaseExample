package SelefTestDemo.StaticParamTest;

/**
 * 类变量(static修饰) 成员变量(实例变量) 静态代码块 代码块 的初始化相关问题4
 * 如果父类中定义了一个类变量 类型为子类 则显示顺序是？
 */
public class Demo4 {
    public static void main(String[] args) {
        // new child4();
        Base4 t = new child4();
    }
}

class Base4 {

    static int basex = 123;
    static child4 s = new child4();//如果在父类

    static {
        System.out.println("父类静态代码块");
    }

    {
        System.out.println("父类代码块");
    }

    public Base4() {
        System.out.println("父类构造函数");
    }
}

class child4 extends Base4 {
    static int childx = 456;

    static {
        System.out.println("子类静态代码块");
    }

    {
        System.out.println("子类代码块");
    }

    public child4() {
        System.out.println("子类构造函数");
    }

}