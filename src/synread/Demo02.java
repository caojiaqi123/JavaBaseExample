package synread;

import java.util.*;

/**
 * emptyList 空 数组
 * <p>
 * singletonList 只含有一个元素
 * <p>
 * unmodifiableMap 不可修改
 */
public class Demo02 {
    public static void main(String[] args) {
        HashMap<String, String> stringStringHashMap = new HashMap<>();

        stringStringHashMap.put("测试", "测试不可修改");

        Map<String, String> stringStringMap = Collections.unmodifiableMap(stringStringHashMap);

//        stringStringMap.put("修改","正在修改");

        System.out.println(stringStringMap.get("测试"));


        //只有一个元素的容器

        List<String> lists = Collections.singletonList(new String());
//       lists.add("1");
//        lists.add("2");
        System.out.println(lists.toString());

       

    }
}
