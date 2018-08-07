package guava;

import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.sun.org.apache.xerces.internal.xs.StringList;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 函数式编程
 */
public class Demo02 {
    public static void main(String[] args) {
        filter();
        //字符串转化
        transform();

        //函数组合
        funCompose();


    }

    private static void funCompose() {
        //确保容器中字符串长度不超过5 超过进行截取 且全部大写
        List<String> lst = Lists.newArrayList("cjq", "good", "I love you");
        //长度截取
        Function<String, String> f1 = input -> input.length() > 5 ? input.substring(0, 5) : input;
        //转化为大写
        Function<String, String> f2 = input -> input.toUpperCase();

        Function<String,String> f3 = Functions.compose(f1,f2);
        Collection<String> transform = Collections2.transform(lst, f3);
        System.out.println(transform.toString());
    }

    private static void transform() {
        HashSet<Long> timeSet = Sets.newHashSet();
        timeSet.add(10000000l);
        timeSet.add(200000000000000l);

        Collection<String> transform = Collections2.transform(timeSet, new Function<Long, String>() {
            @Override
            public String apply(Long input) {
                return new SimpleDateFormat("yyyy-MM-dd").format(input);
            }
        });

        System.out.println(transform.toString());
    }

    //过滤器
    private static void filter() {
        ArrayList<String> strings = Lists.newArrayList("moom", "son", "dad");

        //匿名内部类
        Collection<String> filter = Collections2.filter(strings, new Predicate<String>() {
            @Override
            public boolean apply(String input) {
                //业务逻辑
                return new StringBuilder(input).reverse().toString().equals(input);
            }
        });

        System.out.println(filter.toString());
    }
}
