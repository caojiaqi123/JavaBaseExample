package synread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Demo01 {
    public static void main(String[] args) {
        List<String> lst = new ArrayList<>();
        lst.add("a");
        lst.add("b");

        List<String> strings = Collections.synchronizedList(lst);
        System.out.println("同步");

    }
}
