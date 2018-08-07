package MyCollection2;

import java.time.LocalDate;
import java.util.ArrayList;

public class Test01 {
    public static void main(String[] args) {

        Employee e = new Employee(0301, "曹嘉琦", "开发", 30000,
                LocalDate.of(2018, 1, 1));
        ArrayList<Employee> list = new ArrayList<>();

        list.add(e);

        for (int i = 0; i < list.size(); i++) {
            Employee employee = list.get(i);
            System.out.println(employee.getName());
        }

    }
}
