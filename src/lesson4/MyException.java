package lesson4;

public class MyException extends Exception {
    String mymsg = "我的异常信息";
    MyException(){
        super("我自己定义的异常");
    }
    MyException(String msg){
        super(msg);
    }
    public void displayMe(){
        System.out.println(mymsg);
    }
}
class ExceptionTest{
    public static void main(String[] args) {
        try{
            if(args[0].charAt(0) == 'A'){
                MyException e = new MyException();
                throw e;
            }else {
                System.out.println(args[0]);
            }
        }catch (MyException e){
            System.out.println(e.getMessage());
            e.displayMe();
        }
    }
}

