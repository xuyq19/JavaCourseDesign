package lesson8.ChatRoom;

import java.awt.Button;
import java.awt.Event;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

//客户端程序
public class ChatClient extends Frame {
    private static final long serialVersionUID = 1L;
    // 聊天室ID
    private String groupID;
    // 客户端用户名
    private String clientName;
    // 客户端消息发送服务套接字
    private DatagramSocket msg_send;
    // 服务端口
    private final int PORT = 10000;
    // 服务器IP地址
    private InetAddress ip;

    // 客户端控件
    TextField tf = new TextField(20);
    TextArea ta = new TextArea();
    Button send = new Button("send");

    // 客户端构造器
    public ChatClient(String groupID, String clientName) {

        super("聊天室:" + groupID + "/" + clientName);
        this.clientName = clientName;
        this.groupID = groupID;
        // 设置客户端界面样式
        add("North", tf);
        add("Center", ta);
        add("South", send);
        setSize(250, 250);
        show();
        // 聊天相关服务器初始化
        init();

        // 监视器
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                // 关闭消息发送服务
                msg_send.close();
                // 关闭客户端程序
                dispose();
                System.exit(0);
            }
        });

    }

    // 聊天相关服务器初始化
    private void init() {
        // 注册当前用户及所在聊天室信息注册到服务器
        ChatServer.logInGroup(groupID, this);
        try {
            // 初始化消息发送套接字对象
            msg_send = new DatagramSocket();
            // 指定消息服务器
            try {
                ip = InetAddress.getByName("127.0.0.1");
            } catch (UnknownHostException e) {
                System.out.println("未知的主机异常..");
            }
        } catch (SocketException e) {
            System.out.println("套接字连接异常..");
        }
    }

    // 消息发送按钮时间监听
    public boolean action(Event evt, Object arg) {
        if (evt.target.equals(send)) {
            try {
                // 获取输入内容
                String content = tf.getText();
                // 发送消息
                send_message(content);
                // 清空聊天框
                tf.setText(null);
            } catch (Exception ioe) {
                System.out.print(ioe.getMessage());
            }
        }
        return true;
    }

    // 消息发送
    private void send_message(String content) {
        // 消息格式化(json格式)
        String message = messageFormat(content);
        // 将消息封装成UDP数据包
        byte[] buf = message.getBytes();
        DatagramPacket packet = new DatagramPacket(buf, buf.length, ip, PORT);

        try {
            // 通过UDP协议发送消息
            msg_send.send(packet);
        } catch (IOException e) {
            System.out.println("IO异常..");
        }
    }

    // 消息格式化
    private String messageFormat(String content) {
        StringBuffer buffer = new StringBuffer();
        buffer.append("{\"groupId\":").append("\"").append(groupID).append(
                "\",");
        buffer.append("\"userName\":\"").append(clientName).append("\",");
        buffer.append("\"text\":\"").append(content).append("\"}");

        return buffer.toString();

    }

    // 从服务器获取当前聊天室最新消息(回调..)
    public void pushBackMessage(MessageEntity me) {
        ta.append(me.getUserName() + ":" + me.getText());
        ta.append("\n");

    }
}
