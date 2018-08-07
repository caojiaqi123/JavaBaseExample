package MyCollection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class CollectionTest {
    public static void main(String[] args) {
        ArrayList a = new ArrayList();
        a.add(123);
        List list2 = new ArrayList();
        list2.add(456);
        list2.add(789);

        a.add(list2);
        a.remove(new Integer(1));
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.get(1);
    }
}
