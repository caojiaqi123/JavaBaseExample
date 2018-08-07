package ThreadTest;

public class ProgramApp {
    public static void main(String[] args) {
        Programer p = new Programer();
        Thread th = new Thread(p);
        th.start();

        for (int i = 0; i < 100; i++) {
            System.out.println("聊QQ"+i);

        }
    }
}
