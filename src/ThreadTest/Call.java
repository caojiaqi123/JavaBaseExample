package ThreadTest;

import java.util.concurrent.*;

/**
 * 使用callabl创建线程
 */
public class Call {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //创建线程
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Race tor = new Race();
        Future<Integer> result = executorService.submit(tor);
        Integer speed = result.get();

        System.out.println(speed);

        executorService.shutdownNow();
    }
}

class Race implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        return 100;
    }
}
