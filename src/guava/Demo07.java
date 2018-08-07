package guava;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

/**
 * hashmap 键唯一，值可以重复
 * BiMap:减值都不可重复
 * */
public class Demo07 {
    public static void main(String[] args) {
        HashBiMap<String, String> map = HashBiMap.create();
        map.put("1","22222");
        map.put("2","3333");

        String s = map.inverse().get("22222");
        System.out.println(s);
    }
}
