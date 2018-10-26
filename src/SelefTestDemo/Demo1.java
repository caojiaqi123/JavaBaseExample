package SelefTestDemo;

interface test {
    void t();
}

class Base {
    public Base() {
        System.out.println("Base");
    }
}

class Child extends Base {
    public Child() {
        System.out.println("child");
    }
}

/**
 * 构造函数调用:
 * 当实例化子类的时候 会默认调用父类构造函数
 * 如果父类有构造函数，但是没有无参构造 则必须使用super指明构造函数
 * 否则报错
 */
public class Demo1 {
    public static void main(String[] args) {
        new Child();
        Integer i01 = 59;
        int i02 = 59;
        Integer i03 = Integer.valueOf(59);
        Integer i04 = new Integer(59);
        System.out.println(i03 == i04);
        System.out.println(i02==i04);

    }
}