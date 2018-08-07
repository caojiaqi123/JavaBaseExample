package CollectionSort;

import java.util.Comparator;

public class Utils {
    public static void Sort(Object[] list) {
        boolean isSorted = true;
        for (int i = 0; i < list.length; i++) {
            isSorted = true;
            for (int j = 0; j < list.length - i - 1; j++) {
                Object tem = list[j];
                if (((Comparable) list[j]).compareTo(list[j + 1]) > 0) {
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

    /**
     * 使用自定义比较器比较
     */
    public static <T> void Sort(T[] list, Comparator<T> com) {
        boolean isSorted = true;
        for (int i = 0; i < list.length; i++) {
            isSorted = true;
            for (int j = 0; j < list.length - i - 1; j++) {
                T tem = list[j];
                if (com.compare(list[j], list[j + 1]) > 0) {
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

    public static <T extends Comparable<T>> void Sort(T[] list) {
        boolean isSorted = true;
        for (int i = 0; i < list.length; i++) {
            isSorted = true;
            for (int j = 0; j < list.length - i - 1; j++) {
                T tem = list[j];
                if (list[j].compareTo(list[j + 1]) > 0) {
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
