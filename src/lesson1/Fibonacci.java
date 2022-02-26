package lesson1;
public class Fibonacci {
    public static void main(String[] args){
        int a = 1;
        int b = 1;
        int c = 0;
        int i = 0;
        while(i < 20){
            System.out.println(a);
            c = a + b;
            a = b;
            b = c;
            i++;
        }
    }
}
