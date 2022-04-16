package lesson5;
/*对象流
程序先创建三个实例，然后依次写出，另一端依次读取。
其中三个实例的类，分别是string，date和自己写的student（需要实现序列化）。
之后比较两端对象的内存地址是否一致，又重写了equals方法、tostring方法。
*/

import java.io.*;
import java.util.Date;

public class ObjectSaver {
    public static void main(String[] args) throws Exception {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("objectFile.obj"));
        //对象输出流
        String obj1 = "hello";    //创建string对象
        Date obj2 = new Date();        //创建date对象
        Student obj3 = new Student("张三", 20);    //创建student对象
        out.writeObject(obj1);    //依次输出三个对象
        out.writeObject(obj2);
        out.writeObject(obj3);
        out.close();

        ObjectInputStream in = new ObjectInputStream(new FileInputStream("objectFile.obj"));
        //System.out.println("字符串对象");
        String obj11 = (String) in.readObject();    //按照输出对象的次序，依次读取对象
        System.out.println("obj11:" + obj11);    //输出hello
        System.out.println("obj11==obj1:" + (obj1 == obj11));    //对比内存地址是否相等，结果是false
        System.out.println("obj11.equals(obj1):" + obj11.equals(obj1));    //利用重写的equals对比，true

        //System.out.println("\nDate对象");
        Date obj22 = (Date) in.readObject();
        System.out.println("obj22:" + obj22);
        System.out.println("obj22==obj2:" + (obj22 == obj2));
        System.out.println("obj22.equals(obj2):" + (obj22.equals(obj2)));

        //System.out.println("\nStudent对象");
        Student obj33 = (Student) in.readObject();
        System.out.println("obj33:" + obj33);
        System.out.println("obj33==obj3:" + (obj33 == obj3));
        System.out.println("obj33.equals(obj3):" + (obj33.equals(obj3)));
        in.close();
    }
}

class Student implements Serializable {    //实现序列化、串行化
    private final String Name;
    private final int Age;

    public Student(String name, int age) {
        Name = name;
        Age = age;
        System.out.println("带两个参数的构造方法!");
    }

    //重写eauals
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Student)) {  //测试是否属于student类
            return false;
        }
        final Student other = (Student) o;
        return this.Name.equals(other.Name) && (this.Age == other.Age);
    }

    //重写tostring
    public String toString() {
        return "Name=" + Name + ",Age = " + Age;
    }
}
