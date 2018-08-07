package guava;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;

import java.util.Set;

/**
 *  统计单词次数
 *  Multiset :无序 不可重复
 * */
public class Demo05 {
    public static void main(String[] args) {
        String str ="this is a map and that is ssss";

        String[] strArry = str.split(" ");
        HashMultiset<String> set = HashMultiset.create();
        for (String s : strArry) {
            set.add(s);
        }

        //获取所有单词
        Set<String> letters = set.elementSet();
        for (String letter : letters) {
            System.out.println(letter+"-->"+set.count(letter));
        }
    }
}
