/**
 * Created by caojiaqi on 2099/3/17.
 */
public class charData {
    public static void main(String[] args) {
        char c1 = 'a';
        char c2 = '曹';
        System.out.println(c1);
        System.out.println(c2);

        char c3 = 'a';
        int i = 2 + c3;
        char c4 = (char) i;
        System.out.println((char) (c3 + i));
    }
}
