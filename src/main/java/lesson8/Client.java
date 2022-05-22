package lesson8;

import java.net.*;
import java.io.*;

public class Client {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("127.0.0.1", 4001);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("传入信息到服务器：");
        String message = "";
        String temp;
        PrintStream ps = new PrintStream(socket.getOutputStream());
        while (!(temp = br.readLine()).equals("exit")) {
            message += temp;
        }
        ps.close();
        socket.close();

    }
}
