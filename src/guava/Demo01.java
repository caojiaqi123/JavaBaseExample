package guava;

import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 只读设置
 */
public class Demo01 {
    public static void main(String[] args) {
        List<String> lst = new ArrayList<>();
        lst.add("a");

        //相当于原有lst的快照 但是不够安全 因为可以修改原集合
        List<String> readLst = Collections.unmodifiableList(lst);
        //readLst.add("b");

        List<String> llst = ImmutableList.of("a","b");
//        llst.add("2");
        System.out.println(llst.toString());
    }
}
