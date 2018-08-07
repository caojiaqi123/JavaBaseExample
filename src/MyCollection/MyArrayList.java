package MyCollection;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by caojiaqi on 2099/4/15.
 */
public class MyArrayList {
    private Object[] value;

    private int size;


    public MyArrayList() {
        this(16);
    }

    public MyArrayList(int size) {
        value = new Object[size];
    }

    public void add(Object o) {
        value[size] = o;
        size++;
        if (size >= value.length) {
            int newCapacity = value.length * 2 + 2;
            Object[] newList = new Object[newCapacity];

            for (int i = 0; i < value.length; i++) {
                newList[i] = value[i];
            }
            value = newList;
        }
    }

    public Object get(int index) {
        if (index >= value.length || index < 0) {
            try {
                throw new Exception("out of index");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return value[index];
    }


    public int size(){
        return value.length;
    }


    public static void main(String[] args) {
        MyArrayList myArrayList = new MyArrayList();
        int i;
        for ( i = 0; i < 20; i++) {
            myArrayList.add(i);
        }

        System.out.println(myArrayList.get(0));
        System.out.println(myArrayList.size());

        int j=0;
        {
           j=j+1;
        }
        System.out.println(i);

    }
}
