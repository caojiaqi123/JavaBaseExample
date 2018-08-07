package CollectionSort;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BubleSort {
    public static void main(String[] args) {
        int[] list = new int[5];
//        list[0] = 7;
//        list[1] = 9;
//        list[2] = 11;
//        list[3] = 1;
//        list[4] = 3;
//        list[5] = 8;
//        list[6] = 11;
        list[0] = 9;
        list[1] = 2;
        list[2] = 3;
        list[3] = 1;
        list[4] = 5;
        // 冒泡排序
//        bubkeOne(list);


//        BubleTwo(list);
        BubleFinal(list);

        System.out.println(Arrays.toString(list));

    }

    private static void BubleTwo(int[] list) {
        for (int i = 0; i < list.length; i++) {
            for (int j = 0; j < list.length - 1 - i; j++) {
                int tem = list[j];
                if (list[j] > list[j + 1]) {
                    list[j] = list[j + 1];
                    list[j + 1] = tem;
                }
            }
        }
    }

    //冒泡排序第一种实现 ：缺点每次都要循环n次
    private static void bubkeOne(int[] list) {
        for (int i = 0; i < list.length - 1; i++) {
            for (int j = 0; j < list.length - 1; j++) {
                int tem = list[j];
                if (list[j] > list[j + 1]) {
                    list[j] = list[j + 1];
                    list[j + 1] = tem;
                }
            }
        }
    }

    //如果一次下来都没有交换过位置则认为已经完成排序
    private static void BubleFinal(int[] list) {

        boolean isSorted = true;
        for (int i = 0; i < list.length; i++) {
            isSorted = true;
            for (int j = 0; j < list.length - i - 1; j++) {
                int tem = list[j];
                if (list[j] > list[j + 1]) {
                    list[j] = list[j + 1];
                    list[j + 1] = tem;
                    isSorted = false;
                }
            }
            if (isSorted) {
                break;
            }
        }
    }
}
