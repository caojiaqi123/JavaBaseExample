import javax.sound.midi.Soundbank;

/**
 * Created by caojiaqi on 2099/3/17.
 * 二进制定义
 */
public class BinaryNum {

    public static void main(String[] args) {
        //二进制表示
        int a = 0b0000000000000000000000000000011;
        int b = 0b0000_0000_0000_0000_0000_0000_0000_0011;
        System.out.println(a);
        System.out.println(b);
        int c = 123_456;
        System.out.println(c);

        int d = 4, e = 4;
        int f = 0;
        System.out.println(f);
        BinaryNum s = new BinaryNum();

        double ss = 10.0 % 3.0;
        System.out.println(ss);

        boolean s3 = 1 > 2;
        boolean s2 = s3 && 3 > (1 % 0);
        System.out.println(s2);
    }
}
