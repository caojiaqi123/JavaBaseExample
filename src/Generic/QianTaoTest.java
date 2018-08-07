package Generic;
/**
 * 范型嵌套
 * */
public class QianTaoTest {
    public static void main(String[] args) {
        Student<Integer> student = new Student<>();
        student.setScore(123 );
        //范型嵌套
        Class<Student<Integer>> t2 = new Class<>();
        t2.setStu(student);
        System.out.println(t2.getStu().getScore());
    }
}
