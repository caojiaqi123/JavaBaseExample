package ThreadTest.proConsumer;

/**
 * @description 生产者消费者模式
 * wait():等待 释放锁
 * @params
 */
public class Movie {
    private String pic;
    //flag-->true 生产者生产 消费者等待 生产完成后通知消费
    //flag-->flase 消费者消费 生产者等待 消费完成后通知生产
    private boolean flag = true;


    public synchronized void play(String pic) {
        if (!flag) {//生产者等待

            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //开始生产
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.pic = pic;
        System.out.println("正在生产" + this.pic);
        //通知
        this.notify();
        //停止生产
        this.setFlag(false);
    }

    public synchronized void watch() {
        if (flag) {//消费者等待
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //开始消费
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("正在消费" + this.pic);
        //
        this.notify();
        //停止消费
        setFlag(true);
    }

//    public synchronized void play(String pic) {
//
//        this.pic = pic;
//        System.out.println("正在生产" + this.pic);
//
//    }
//
//    public synchronized void watch() {
//
//        System.out.println("正在消费" + this.pic);
//
//    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
