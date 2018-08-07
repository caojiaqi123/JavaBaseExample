package ThreadTest;

/**
 * 静态代理 设计模式
 * 1。真实角色
 * 2。代理角色 代理 持有真实角色的引用
 * 3。二者实现相同的接口
 */
public class StaticProxy {

    public static void main(String[] args) {
        Marry you = new You();
        Marry wedCom = new WeddingCompany(you);
        wedCom.marry();
    }
}

interface Marry {
    void marry();
}

class You implements Marry {

    @Override
    public void marry() {
        System.out.println("i and chang e wed");
    }
}

class WeddingCompany implements Marry {
    private Marry you;

    public WeddingCompany(Marry you) {
        this.you = you;
    }

    public WeddingCompany() {
    }

    private void before() {
        System.out.println("婚前准备");
    }

    private void atfer() {
        System.out.println("婚后收场");
    }

    @Override
    public void marry() {
        before();
        you.marry();
        atfer();
    }
}