package nio.demo02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @ClassName: ServerSocket
 * @Description:
 * @Author
 * @Date 2022/6/28
 * @Version 1.0
 */
public class Server {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket  = new ServerSocket(9999);
            Socket socket = serverSocket.accept();
            InputStream inputStream = socket.getInputStream();
            String msg = null;
            BufferedReader bufferedReader  = new BufferedReader(new InputStreamReader(inputStream));
            if ((msg = bufferedReader.readLine()) != null){
                System.out.println("服务端接收到：" + msg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
