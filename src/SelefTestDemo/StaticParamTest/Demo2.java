package SelefTestDemo.StaticParamTest;

/**
 * 类变量(static修饰) 成员变量 静态代码块 代码块 的初始化相关问题
 * 顺序问题：1 类变量 和静态代码块是平级的 都是在类加载的时候初始化 只加载一次
 * 2.代码块 和 成员变量的级别一致的在构造函数之前 每次初始化的时候会调用一次
 * 3.
 */
public class Demo2 {

    static int x = 3;

    static {
        System.out.println("1");
    }

    public Demo2() {
        System.out.println("3");
    }

    int y = 4;

    {
        System.out.println(2);
    }

    public static void main(String[] args) {
        new Demo2();
    }
}
