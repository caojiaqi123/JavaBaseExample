package ThreadTest;
/**
 * 真实角色类
 * */
public class Programer implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("一遍写代码"+i);
            
        }
    }
}
