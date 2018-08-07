package CollectionSort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;

public class SortTest {
    public static void main(String[] args) {
        String[] strArr = {"abc", "a", "bcde", "abcde"};

        Utils.Sort(strArr);
        System.out.println(Arrays.toString(strArr));

        Utils.Sort(strArr, new StringCompartor());
        System.out.println(Arrays.toString(strArr));

        Person p1 = new Person("我", 1000);
        Person p2 = new Person("刘德华", 100);
        Person p3 = new Person("梁朝伟", 90);
        Person p4 = new Person("测试", 300);
        Person p5 = new Person("丑", 10);

        TreeSet<Person> treeSet = new TreeSet<>(
                new Comparator<Person>() {
                    @Override
                    public int compare(Person o1, Person o2) {
                        return o1.getHandsome() - o2.getHandsome();
                    }
                }
        );
        treeSet.add(p1);
        treeSet.add(p2);
        treeSet.add(p3);
        treeSet.add(p4);
        treeSet.add(p5);

        System.out.println(treeSet);
        p4.setHandsome(-100);
        System.out.println(treeSet);
    }
}
