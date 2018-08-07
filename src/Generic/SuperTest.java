package Generic;

import java.util.ArrayList;
import java.util.List;

/**
 * super : 范型的上限 即父类 或自身
 */
public class SuperTest {
    public static void main(String[] args) {
        test(new ArrayList<Apple>());
        test(new ArrayList<Fruit>());
    }

    static void test(List<? super Apple> t) {

    }
}
