package SelefTestDemo.StaticParamTest;

public class Demo5 {

    static int i = 1;
    static {
        i = 0;//给变量赋值可以正常编译通过
        System.out.print(i);//这句编译器会提示"非法向前引用"
    }

    public static void main(String[] args) {

    }
}
