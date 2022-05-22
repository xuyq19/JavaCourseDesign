package lesson8;

import java.net.*;
import java.io.*;

public class Server {
    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(4001);
        Socket s = ss.accept();
        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        String message = "";
        String temp;
        do {
            temp = br.readLine();
            if (temp == null) {
                break;
            }
            System.out.println("Received: " + temp);
            message = message + temp + "\n";
        } while (true);
        br.close();
        PrintStream ps = new PrintStream(new FileOutputStream("message.txt"));
        ps.println(message);
        ps.close();
        br.close();
        s.close();
        ss.close();
        System.out.println("Server is closed");
    }
}