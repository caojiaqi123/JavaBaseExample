package CollectionSort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * binarySearch 二分查找 ：前提需要目标队列有序
* */
public class CollectionsTest {
    public static void main(String[] args) {
        List<Integer> lst =new ArrayList<>();
        lst.add(1);
        lst.add(2);
        lst.add(3);
        lst.add(5);

        System.out.println(lst);
        Collections.reverse(lst);
        System.out.println(lst);
        //shuffle 洗牌
        lst.clear();
        for (int i = 1; i < 55; i++) {
            lst.add(i);
        }

        Collections.shuffle(lst);

        System.out.println(lst);
    }
}
