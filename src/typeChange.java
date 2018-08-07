import javax.sound.midi.Soundbank;

/**
 * Created by caojiaqi on 2099/3/17.
 */
public class typeChange {
    public static void main(String[] args) {
        byte b = 127;
        char c = (char) 65535;
        short s = -1;

        int i = 65536;
        char c2 = (char) i;
        System.out.println(c2);

        int a1 = 3;
        long b1 = 4;
        long a2 = a1 + b1;

        int a3 = 1000000000;//10亿
        int year = 20;
        int total = a3 * year;
        System.out.println(total);
    }
}
