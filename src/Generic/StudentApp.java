package Generic;

import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;

public class StudentApp {
    //范型方法
    public static <T> T getStudentScore(T t) {

        return t;
    }

    public static <T extends Closeable> void closeTest(T... lst) {
        for (T tem : lst) {
            try {
                tem.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Student<Integer> st = new Student();
        st.setScore(123);

        Student<Double> stFlo = new Student<>();
        stFlo.setScore(1.12);

        int intScore = getStudentScore(st.getScore());
        double douScore = getStudentScore(stFlo.getScore());

        System.out.println(intScore);
    }
}
