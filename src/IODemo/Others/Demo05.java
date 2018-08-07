package IODemo.Others;

import java.io.*;
import java.util.Arrays;

/**
 * Serializable空接口 标示可序列化
 */
public class Demo05 {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String path = "/Users/caojiaqi/Projects/JavaProjects/JavaData/test/other_demo05.txt";
        serize(path);

        Employee deserize = deserize(path);
        System.out.println(deserize.getName());
        System.out.println(deserize.getSalary());
    }

    static void serize(String path) throws IOException {
        Employee cjq = new Employee("cjq", 1000000);

        int[] arr = {1, 2, 3, 4};
        File file = new File(path);
        ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)));

        oos.writeObject(cjq);
        oos.writeObject(arr);
        oos.flush();
        oos.close();
    }

    static Employee deserize(String path) throws IOException, ClassNotFoundException {
        Employee employee = null;
        File file = new File(path);
        ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));
        employee = (Employee) ois.readObject();

        int[] arr = (int[]) ois.readObject();
        System.out.println(Arrays.toString(arr));
        ois.close();
        return employee;
    }
}
