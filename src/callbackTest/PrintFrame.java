package callbackTest;

import javax.sound.midi.Soundbank;

/**
 * Created by caojiaqi on 2099/4/8.
 */
public class PrintFrame {
    public static void  dropFrame(MyFrame f){
        System.out.println("启动线程");
        System.out.println("增加循环");
        System.out.println("查看消息站");

        //画窗口
        f.paint();

        System.out.println("启动缓存，提高效率");
    }
}
