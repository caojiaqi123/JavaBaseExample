package SelefTestDemo.ThreadDemo;

import java.util.ArrayList;
import java.util.List;


public class Demo01 {
    private List names = new ArrayList();

    public static void main(String[] args) {
        final Demo01 sl = new Demo01();
        for (int i = 0; i < 2; i++) {
            new Thread("线程" + i) {
                public void run() {
                    sl.add("A");
                    sl.add("B");
                    sl.add("C");
                    sl.printAll();
                }
            }.start();
        }

    }

    public synchronized void add(String name) {
        names.add(name);
    }

    public synchronized void printAll() {
        for (int i = 0; i < names.size(); i++) {
            System.out.print(names.get(i) + "");
        }
    }
}

