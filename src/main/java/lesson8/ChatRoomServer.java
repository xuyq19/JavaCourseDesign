package lesson8;

import java.util.HashMap;
import java.net.DatagramSocket;
import java.util.ArrayList;

import com.google.code.gson.*;

/**
 * @author LucasXu
 */
public class ChatRoomServer extends Thread {
    private static final int PORT = 8086;
    private static DatagramSocket server = null;
    private static HashMap<String, ArrayList<ChatClient>> groups = new HashMap<String, ArrayList<ChatClient>>();
}
