package lesson5;

import java.io.*;

public class RandomTest {
    public static void main(String args[]) {
        File f = new File("RandomTest.java");
        try {
            RandomAccessFile random = new RandomAccessFile(f, "r");
            //创建了指向文件f的对象random，只读方式打开
            //在生成一个随机文件对象时，除了要指明文件对象之外，还需要指明访问文件的模式。
            long l = random.length();//取此文件的长度
            char ch;
            for (long i = l - 1; i >= 0; i--) {
                random.seek(i);    //seek方法可以将指针定位到i处
                ch = (char) random.read();    //转化为字符型
                System.out.print(ch);
            }
            random.close();
        } catch (Exception e) {
            System.out.println("IOException！");
        }
    }
}