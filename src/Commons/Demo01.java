package Commons;


import org.apache.commons.collections.Predicate;
import org.apache.commons.collections.PredicateUtils;
import org.apache.commons.collections.functors.EqualPredicate;
import org.apache.commons.collections.functors.NotNullPredicate;
import org.apache.commons.collections.functors.UniquePredicate;
import org.apache.commons.collections.list.PredicatedList;

import java.util.ArrayList;
import java.util.List;

/**
 * predicate
 */
public class Demo01 {
    public static void main(String[] args) {
        equal();

        notNull();

        unique();


        new Predicate() {
            @Override
            public boolean evaluate(Object object) {

                return false;
            }
        };

    }

    private static void unique() {
        List<Long> lst = new ArrayList<>();
        Predicate instance = UniquePredicate.getInstance();
        List decorate = PredicatedList.decorate(lst, instance);

        decorate.add(1l);
        decorate.add(2l);
//        decorate.add(2l);
    }

    /**
     * 判断非空
     */
    private static void notNull() {
        Predicate instance = NotNullPredicate.INSTANCE;
        String str = null;
        System.out.println(instance.evaluate(str));
        //添加容器时判断是否为空
        List<Long> lst = new ArrayList<>();


        List decorate = PredicatedList.decorate(lst, instance);
        decorate.add(100l);
//        decorate.add(null);
    }

    /**
     *
     * */
    private static void equal() {
        System.out.println("-----相等的判断s------");
        EqualPredicate cjq = new EqualPredicate("cjq");
        boolean cjq1 = cjq.evaluate("cjq");
        System.out.println(cjq1);
    }
}
