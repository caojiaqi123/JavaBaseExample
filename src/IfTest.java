/**
 * Created by caojiaqi on 2099/3/17.
 */
public class IfTest {
    public static void main(String[] args) {
        //骰子功能
        double ran = Math.random();
        int d = 1 + (int) (ran * 6);
        System.out.println(d);
        if (d > 3) {
            System.out.println("big data");
        }

        //计算 1 + （1+2）+（1+2+3）直到100
        int sum = 0;
        for (int j = 0; j <= 100; j++) {
            for (int i = 1; i <= j; i++) {
                sum += i;
            }
        }


        System.out.println(sum);
    }
}
