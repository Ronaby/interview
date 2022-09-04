package nio.demo02;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;

/**
 * @ClassName: Client
 * @Description:
 * @Author
 * @Date 2022/6/28
 * @Version 1.0
 */
public class Client {
    public static void main(String[] args) {

        try {
            Socket socket = new Socket("127.0.0.1",9999);
            OutputStream outputStream = socket.getOutputStream();
            PrintStream printStream = new PrintStream(outputStream);
            printStream.println("hello World! 服务端，你好");
            printStream.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
