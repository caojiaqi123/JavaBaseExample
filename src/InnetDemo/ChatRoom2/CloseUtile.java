package InnetDemo.ChatRoom2;

import java.io.Closeable;
import java.io.IOException;

public class CloseUtile {
    public static void close(Closeable... closeableIo) {
        for (Closeable closeable : closeableIo) {
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (IOException e) {
                    //e.printStackTrace();
                }
            }
        }
    }
}
