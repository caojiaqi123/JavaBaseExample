package IODemo.Pattern;
/**
 * 装饰设计模式
 *
 * */
public class demo01 {
    public static void main(String[] args) {
        Voice voice = new Voice();
        voice.say();

        Amplifier am = new Amplifier(voice);
        am.say();
    }
}
