package IODemo.ByteIO;

import java.io.*;

/**/
public class Demo02 {
    public static void main(String[] args) {
        File file = new File("/Users/caojiaqi/Projects/JavaProjects/JavaData/test/2.txt");

        OutputStream os = null;
        try {
            os = new FileOutputStream(file,true);

            String outPutStr = "曹嘉琦";
            byte[] outByte = outPutStr.getBytes();
            os.write(outByte);
            os.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (os!=null){
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
