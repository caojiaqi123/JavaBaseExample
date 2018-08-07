package IODemo.Util;

import java.io.Closeable;
import java.io.IOException;

/**
 * 关闭工具类
 */
public class FileUtil {
    /**
     * 可变参数 ...：只能放最后
     */
    public void close2(Closeable... io) throws IOException {
        for (Closeable closeable : io) {
            if (closeable != null) {
                closeable.close();
            }

        }
    }

    public <T extends Closeable> void close(T... io) {
        for (T t : io) {
            try {
                t.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
