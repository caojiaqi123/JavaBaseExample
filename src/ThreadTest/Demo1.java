package ThreadTest;

public class Demo1 {
    public static void main(String[] args) {
        Rabit rabit = new Rabit();
        Thread raTh = new Thread(rabit);
        Thread tor = new Thread(new Tortoise());

        raTh.start();
        tor.start();
    }
}
