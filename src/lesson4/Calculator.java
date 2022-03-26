package lesson4;
class NonZeroException extends Exception {

}
public class Calculator {
    public static void main(String[] args){
        try{
            int a = Integer.parseInt(args[0]);
            char op = args[1].charAt(0);
            int b = Integer.parseInt(args[2]);
            int result = 0;
            switch (op){
                case '+':
                    result = a + b;
                    System.out.println("a + b = " + result);
                    break;
                case '-':
                    result = a - b;
                    System.out.println("a - b = " + result);
                    break;
                case '*':
                    result = a * b;
                    System.out.println("a * b = " + result);
                    break;
                case '/':
                    try{
                        result = a / b;
                    }catch (ArithmeticException e){

                    }
                    System.out.println("a / b = " + result);
                    break;
                default:
            }
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("ArrayIndexOutOfBoundsException");
        }catch (NumberFormatException e){
            System.out.println("NumberFormatException");
        }catch(ArithmeticException e){
            System.out.println("ArithmeticException");
        }
        finally {
            System.out.println("Finally");
        }
    }

}
