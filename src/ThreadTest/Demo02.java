package ThreadTest;

import MyCollection.Student;

public class Demo02 {
    public static void main(String[] args) {
        Study s = new Study();
        new Thread(s).start();

        for (int i = 0; i < 100; i++) {
            if (i == 50) {
                s.setFlag(false);
            }
            System.out.println("main" + i);
        }
    }
}

class Study implements Runnable {
    private boolean flag = true;

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        while (flag) {
            System.out.println("study thread....");
        }
    }
}
