package guava;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

import java.util.*;

/**
 * 分析查看教师 及器课程
 *
 * */
public class Demo06 {
    public static void main(String[] args) {
        HashMap<String, String> cours = new HashMap<>();
        cours.put("三个代表","将折磨");
        cours.put("改革开放","邓小平");
        cours.put("和谐社会","胡主席");
        cours.put("八荣八次","胡主席");
        Multimap<String,String> teachers = ArrayListMultimap.create();

        Iterator<Map.Entry<String, String>> iterator = cours.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String, String> next = iterator.next();
            String key = next.getKey();
            String value = next.getValue();
            teachers.put(value,key);
        }

        Set<String> keySet = teachers.keySet();
        for (String s : keySet) {
            Collection<String> strings = teachers.get(s);
            System.out.println(s+"-->"+strings);
        }
    }
}
