package Generic;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapTest {
    public static void main(String[] args) {
        String str = "this is a test to count how many words appear a";
        String[] split = str.split(" ");

        Map<String, Integer> map = new HashMap<>();
        for (String s : split) {
            if (map.containsKey(s)) {
                map.put(s, map.get(s) + 1);
            } else {
                map.put(s, 1);
            }
        }

        Set<String> keys = map.keySet();
        Iterator<String> iterator = keys.iterator();

        while (iterator.hasNext()) {
            String key = iterator.next();
            System.out.println(key + " count: " + map.get(key));
        }
    }
}
