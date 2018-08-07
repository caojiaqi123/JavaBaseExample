package ThreadTest.proConsumer;

/**
 * @description 消费者
 * @params
 */
public class Watcher implements Runnable {
    private Movie movie;

    public Watcher(Movie movie) {
        this.movie = movie;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            movie.watch();
        }
    }
}
