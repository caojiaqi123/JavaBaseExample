package guava;

import com.google.common.collect.Sets;

import java.util.Set;

/**
 * 集合的操作:交集 并集 差集
 * */
public class Demo04 {
    public static void main(String[] args) {

        Set<Integer> s1 = Sets.newHashSet(1,2,3,4,5);
        Set<Integer> s2 = Sets.newHashSet(4,5,6,7,8);
        //交集
        Sets.SetView<Integer> intersection = Sets.intersection(s1, s2);
        System.out.println("交集");
        System.out.println(intersection);
        //差集
        Sets.SetView<Integer> difference = Sets.difference(s1, s2);
        System.out.println(difference);
        //并集
        Sets.SetView<Integer> union = Sets.union(s1, s2);
        System.out.println(union);
    }
}
