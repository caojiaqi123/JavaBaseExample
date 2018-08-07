package MyCollection;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SetTest {
    HashMap map;
    private static final Object PRESENT = new Object();

    public SetTest() {
        map = new HashMap();
    }

    public void add(Object o) {
        map.put(o, PRESENT);
    }

    public void remove(Object o){
        map.remove(o);
    }

    public static void main(String[] args) {
        HashSet set = new HashSet();
        set.add("aaa");
        set.add(new String("aaa"));

        Map map =new HashMap();
       
        System.out.println(set.size());
    }
}
