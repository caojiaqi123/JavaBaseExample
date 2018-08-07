package Generic;

import java.util.ArrayList;
import java.util.List;

/**
 * 范型通配符
 * ?---->表示类型不确定。只用于声明变量 和 型参上
 * 不能用在创建对象，创建类 和范型方法，接口上
 * <p>
 *
 * 单纯使用？作为通配范围太广
 * 一般会有范型约束 用关键词 extends
 */
public class GenericWildCards {
    public static void main(String[] args) {
        List<? extends Number> list = new ArrayList<Integer>();
        list = new ArrayList<Double>();

        test(list);
    }

    public static void test(List<?> list) {

    }
}
