package NiuKeDemo;

public class Demo01 {
    private static Demo01 t1 = new Demo01();

    static {
        System.out.println("static block");
    }

    {
        System.out.println("member block");
    }

    public static void main(String[] args) {
        Demo01 t2 = new Demo01();
    }
}
