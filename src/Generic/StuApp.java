package Generic;
/**
 * 范型的擦出，使用时没有指定参数类型
 *类似于object ,但不等同于object
 * */
public class StuApp {
    public static void main(String[] args) {
        Student myStu = new Student();
        myStu.setScore(1100);

        test(myStu);
    }


    public static void test(Student t){}
}
