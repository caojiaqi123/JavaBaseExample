package SelefTestDemo.TryCatchDemo;

/**
 * 用于测试try catch finally中执行到具体哪个步骤
 * 其实在编译成.class文件以后 try catch中的return都被移除 只保留了 finally的return
 */
public class Demo01 {
    public static void main(String[] args) {
        test();
    }

    private static int test() {
        try {
            int x = 012;
            return retMsg();
        } catch (Exception ex) {
            return 2;
        } finally {
            System.out.println("this is finally");
            return 3;
        }

    }

    static int retMsg() {
        System.out.println("this is a test");
        return 3;
    }
}
