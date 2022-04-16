package lesson5;
/*文件的字符编码转换
运行此程序时，需要提前写一个test.txt文件放在当前目录；
程序主方法类中有一处错误的代码，需要修改编码方式；

此程序利用先从test.txt读取字符串，然后利用不同的编码方式复制文件
*/

import java.io.*;

public class FileConvert {
    public static void main(String[] args) throws IOException {
        FileConvert myapp = new FileConvert();
        myapp.readFile("src/lesson5/test.txt");
        myapp.copyFile("src/lesson5/test.txt", null, "src/lesson5/unicode.txt", "Unicode");
        myapp.copyFile("src/lesson5/test.txt", null, "src/lesson5/utf8.txt", "UTF-8");
        myapp.readFile("src/lesson5/unicode.txt");    //按照本地平台的编码读取字符，读取到错误的数据
        //myapp.readFile("src/lesson5/unicode.txt","Unicode");	//应该修改为此句话
        myapp.readFile("src/lesson5/utf8.txt", "UTF-8");
    }

    /**
     * 从一个文件中逐行读取字符串，使用本地字符编码
     */
    public void readFile(String fileName) throws IOException {        //声明此方法可能会产生异常
        readFile(fileName, null);        //使用本地字符编码读取文件
    }

    /**
     * 从一个文件中逐行读取字符串，参数charsetName用于指定文件的字符编码
     */
    public void readFile(String fileName, String charsetName) throws IOException {
        InputStream in = new FileInputStream(fileName);        //父类引用指向子类对象
        InputStreamReader reader;    //字节流转换成字符流

        if (charsetName == null)
            reader = new InputStreamReader(in);
        else
            reader = new InputStreamReader(in, charsetName);

        BufferedReader br = new BufferedReader(reader);    //缓冲字符流
        String data;
        while ((data = br.readLine()) != null)        //逐行读取数据
            System.out.println(data);
        br.close();
    }

    /**
     * 把一个文件中的字符内容复制到另一个文件中，并且进行了相关的字符编码转换
     */
    public void copyFile(String from, String charsetFrom, String to, String charsetTo) throws IOException {
        InputStream in = new FileInputStream(from);    //父类引用指向子类对象
        InputStreamReader reader;        //字节流转换成字符流
        if (charsetFrom == null)
            reader = new InputStreamReader(in);
        else
            reader = new InputStreamReader(in, charsetFrom);
        BufferedReader br = new BufferedReader(reader);    //缓冲字符流
        OutputStream out = new FileOutputStream(to);    //父类引用指向子类对象
        OutputStreamWriter writer = new OutputStreamWriter(out, charsetTo);    //字节流转换成字符流
        BufferedWriter bw = new BufferedWriter(writer);
        String data;
        while ((data = br.readLine()) != null)    //向目标文件逐行写数据
            bw.write(data + "\n");
        br.close();
        bw.close();
    }
}