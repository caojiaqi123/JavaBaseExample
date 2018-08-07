public class Main {

    public static void main(String[] args) {
        int datetype = 10;
        int a2 = 010;//八进制
        int a3 = 0x10;//十六进制

        System.out.println(a2);
        System.out.println(a3);

        System.out.println("------进制转化------");
        //十进制转二进制
        System.out.println(Integer.toBinaryString(datetype));
        //转八进制
        System.out.println(Integer.toOctalString(8));
        System.out.println(Integer.toHexString(15));

        int a = 200;

        long longint = 222222222;// k
    }
}
