package MyCollection;

import java.util.HashMap;
import java.util.Map;

/*
 * 思路：map是不重复的，所以每次都要校验。
 * 另外获取某个key对应的value的时候需要遍历
 * 而数组可以直接使用索引来获取当前对象
 * 所以是否可以将map查找对时候也按索引进行查找 避免避免遍历
 *
 * 提示：对entrty的hashcode取余（一致性hash算法）得出的结果放入对应的
 * 数组索引位置即可
 *
 * */
public class MapTest {

    private MyLinkList[] arr = new MyLinkList[999];
    private int size;

    public void put(Object key, Object value) {
        Entrty e = new Entrty(key, value);
        int index = key.hashCode() % arr.length;

        if (arr[index] == null) {
            MyLinkList temp = new MyLinkList();
            temp.add(e);
            arr[index] = temp;
        } else {
            MyLinkList list = arr[index];
            for (int i = 0; i < list.size(); i++) {
                Entrty e2 = (Entrty) list.get(i);
                if (e.key.equals(key)) {
                     e2.value = e.value;
                     return;
                }
            }
            arr[index].add(e);
        }
        size++;
    }

    public Object get(Object key) {
        int index = key.hashCode() % arr.length;
        if (arr[index] != null) {
            MyLinkList list = arr[index];
            for (int i = 0; i < list.size(); i++) {
                Entrty e = (Entrty) list.get(i);
                if (e.key.equals(key)) {
                    return e.value;
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
//        HashMap map = new HashMap<Integer, String>();
//        map.put(new Integer(1), 2);
//
//        System.out.println(map.get(1));

        MapTest tmap = new MapTest();
        tmap.put(1, 2);
        tmap.put(1000, 2);
        int s = (int) tmap.get(1000);
        System.out.println(s);
    }
}

class Entrty {
    Object key;
    Object value;

    public Entrty(Object key, Object value) {
        this.key = key;
        this.value = value;
    }
}