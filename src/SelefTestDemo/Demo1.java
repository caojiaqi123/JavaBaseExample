package SelefTestDemo;

/**
 * 构造函数调用:
 * 当实例化子类的时候 会默认调用父类构造函数
 * 如果父类有构造函数，但是没有无参构造 则必须使用super指明构造函数
 * 否则报错
 */
public class Demo1 {
    public static void main(String[] args) {
        new Child();
    }
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
