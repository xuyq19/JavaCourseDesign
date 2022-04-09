package lesson4;
import java.util.Scanner;
public class Calculator {
    public static void main(String[] args){
        int a = Integer.parseInt(args[0]);
        char op = args[1].charAt(0);
        int b = Integer.parseInt(args[2]);
        int result = 0;
        try{
            switch (op){
                case '+':
                    result = a + b;
                    break;
                case '-':
                    result = a - b;
                    break;
                case '*':
                    result = a * b;//在命令行输入乘号的时候，要加上双引号，否则会认为是通配符
                    break;
                case '/':
                    if(b==0) {
                        throw new ArithmeticException("Division by zero");
                    }
                    result = a / b;
                    break;
                default:
                    System.out.println("Error operator");
            }
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("ArrayIndexOutOfBoundsException");
        }catch (NumberFormatException e){
            System.out.println("NumberFormatException");
        }catch(ArithmeticException e){
            System.out.println("Cannot divide by zero");
            System.out.println("Please enter a non-zero number");
            Scanner scanner = new Scanner(System.in);
            b = scanner.nextInt();
            result = a / b;

        }
        finally {
            System.out.println("The result is " + result);
            System.out.println("Finally");
        }
    }

}
