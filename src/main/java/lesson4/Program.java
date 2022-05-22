package lesson4;

public class Program {
    String name = "兰州大学信息学院";
    int no1 = 10;
    int no2 = 20;

    public Program() {
        try {
            System.out.println(name);
            System.out.println("相除结果为：" + no1 / no2);
        } catch (ArithmeticException e) {
            System.out.println("除数不能为0");
        } finally {
            name = null;
            System.out.println("Finally已执行");
        }
    }

    public static void main(String[] args) {
        new Program();
    }
}
