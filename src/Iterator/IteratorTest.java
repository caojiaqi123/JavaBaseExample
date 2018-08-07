package Iterator;

import java.util.*;

public class IteratorTest {
    public static void main(String[] args) {

        List<String> lst = new ArrayList<>();
        lst.add("123");
        lst.add("345");
        //通过索引遍历

        for (int i = 0; i < lst.size(); i++) {

            System.out.println(lst.get(i));
        }
        //通过迭代器遍历
        for (Iterator s = lst.iterator(); s.hasNext(); ) {
            String val = (String) s.next();
            System.out.println(val);
        }
    }
}
