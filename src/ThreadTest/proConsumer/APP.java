package ThreadTest.proConsumer;

/**
 * @description 生产者消费者模式
 * 信号灯法
 * @params
 */
public class APP {
    public static void main(String[] args) {
        Movie m = new Movie();

        Player p = new Player(m);
        Watcher w = new Watcher(m);
        new Thread(p).start();
        new Thread(w).start();

    }
}
