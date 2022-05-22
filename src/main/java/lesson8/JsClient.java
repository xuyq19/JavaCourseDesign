package lesson8;

import java.net.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class JsClient extends JFrame implements Runnable, ActionListener {
    JButton connection, jsbutton;
    JTextField inputA, inputB, inputC;
    JTextArea showResult;
    Socket socket;
    DataInputStream in = null;
    DataOutputStream out = null;
    Thread thread;

    public JsClient() {
        socket = new Socket();
        connection = new JButton("连接服务器");
        jsbutton = new JButton("求三角形面积");
        inputA = new JTextField("0", 12);
        inputB = new JTextField("0", 12);
        inputC = new JTextField("0", 12);
        Box boxV1 = Box.createVerticalBox();
        boxV1.add(new JLabel("输入边A"));
        boxV1.add(new JLabel("输入边B"));
        boxV1.add(new JLabel("输入边C"));
        Box boxV2 = Box.createVerticalBox();
        boxV2.add(inputA);
        boxV2.add(inputB);
        boxV2.add(inputC);
        Box baseBox = Box.createHorizontalBox();
        baseBox.add(boxV1);
        baseBox.add(boxV2);
        Container con = getContentPane();
        con.setLayout(new FlowLayout());
        showResult = new JTextArea(8, 18);
        con.add(connection);
        con.add(baseBox);
        con.add(jsbutton);
        con.add(new JScrollPane(showResult));
        jsbutton.addActionListener(this);
        connection.addActionListener(this);
        thread = new Thread(this);
        setBounds(100, 100, 360, 310);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void run() {
        while (true) {
            try {
                double area = in.readDouble();
                showResult.append("\n三角形的面积：\n" + area);
                showResult.setCaretPosition((showResult.getText()).length());
            } catch (IOException e) {
                showResult.setText("与服务器已断开");
                jsbutton.setEnabled(false);
                break;
            }
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == connection) {
            try {
                if (socket.isConnected()) {
                } else {
                    InetAddress address = InetAddress.getByName("127.0.0.1");
                    InetSocketAddress socketAddress = new InetSocketAddress(InetAddress.getLocalHost(), 4444);
                    socket.connect(socketAddress);
                    in = new DataInputStream(socket.getInputStream());
                    out = new DataOutputStream(socket.getOutputStream());
                    jsbutton.setEnabled(true);
                    thread.start();
                }
            } catch (IOException ee) {
            }
        }
        if (e.getSource() == jsbutton) {
            try {
                double a = Double.parseDouble(inputA.getText()),
                        b = Double.parseDouble(inputB.getText()),
                        c = Double.parseDouble(inputC.getText());
                if (a + b > c && a + c > b && b + c > a) {
                    out.writeDouble(a);
                    out.writeDouble(b);
                    out.writeDouble(c);
                } else {
                    inputA.setText("你输入的三个数不构成三角形");
                }
            } catch (Exception ee) {
                inputA.setText("请输入数字字符");
            }
        }
    }

    public static void main(String args[]) {
        JsClient win = new JsClient();
    }
}
