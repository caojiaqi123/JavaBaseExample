package Generic;

import java.util.ArrayList;
import java.util.List;

public class ExtendsTest {
    public static void main(String[] args) {
        Test<Fruit> t = new Test<>();
        Test<FuJiApple> t2 = new Test<FuJiApple>();
        List<Apple> t3 = new ArrayList<>();
        t3.add(new FuJiApple());

        List<? extends Fruit> lst = new ArrayList<Apple>();

        test(lst);
        test(new ArrayList<FuJiApple>());
       // test(new ArrayList<Object>());编译错误

        List<? extends Apple> lst1= new ArrayList<FuJiApple>();
        test(lst1);

        //? --> 编译错误 ? 等同于 ? extends object
        List<?> lst2 = new ArrayList<Fruit>();
        //test(lst2);
    }

    static class Test<T extends Fruit> {
    }

    static void test(List<? extends Fruit> lst) {
        //思考下 为啥添加的时候回报错
        //因为这之规定类型上限 若输入参数为类型的子类，则将子类加入父类报错
        //所以都不允许添加 出了null

        /* lst.add(new Fruit());
        lst.add(new Pear());
        lst.add(new FuJiApple());
        lst.add(new Object());
        */
        lst.add(null);

    }
}

class Fruit {
}

class Apple extends Fruit {
}

class Pear extends Fruit {
}

class FuJiApple extends Apple {
}