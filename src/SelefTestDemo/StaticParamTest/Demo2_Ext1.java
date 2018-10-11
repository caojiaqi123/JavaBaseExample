package SelefTestDemo.StaticParamTest;

/**
 * 类变量(static修饰) 成员变量(实例变量) 静态代码块 代码块 的初始化相关问题
 * 扩展2
 */
public class Demo2_Ext1 {
    static Demo2_Ext1 d2 = new Demo2_Ext1();

    static {
        System.out.println("静态代码块");
    }

    {
        System.out.println("代码块");
    }

    public Demo2_Ext1() {
        System.out.println("构造函数");
    }


    public static void main(String[] args) {
        new Demo2_Ext1();
    }
}
/**
 * 打印顺序应该是？
 * 代码块 -》构造函数——》静态代码块-》代码块-》构造函数
 */