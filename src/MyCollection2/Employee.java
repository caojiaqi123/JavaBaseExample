package MyCollection2;

import java.time.LocalDate;

public class Employee {
    private int id;
    private String name;
    private String dept;
    private int salary;
    private LocalDate hireDate;

    //region 属性
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }
    //endregion

    public Employee(int id, String name, String dept, int salary, LocalDate hireDate) {
        this.id = id;
        this.name = name;
        this.dept = dept;
        this.salary = salary;
        this.hireDate = hireDate;
    }
}
