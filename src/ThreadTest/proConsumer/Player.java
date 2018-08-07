package ThreadTest.proConsumer;

/**
 * @description 生产者
 * @params
 */
public class Player implements Runnable {
    private Movie movie;

    public Player(Movie movie) {
        this.movie = movie;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            if (i % 2 == 0) {
                movie.play("国产片" + i);
            } else {
                movie.play("外国片" + i);
            }

        }
    }
}
