package lesson4;

//define an exception class
class NoLowerLetter extends Exception {
    public NoLowerLetter(String message) {
        super(message);
    }
    public void print(){
        System.out.printf("#");
    }

}
class NoDigit extends Exception {
    public NoDigit(String message) {
        super(message);
    }

    public void print() {
        System.out.print("*");
    }
}
class Test{
    void printLetter(char c) throws NoLowerLetter{
        if(c<'a'||c>'z'){
            NoLowerLetter noLowerLetter = new NoLowerLetter("No lower letter");
            throw noLowerLetter;
        }else{
            System.out.print(c);
        }
    }
    void printDigit(char c) throws NoDigit{
        if(c<'0'||c>'9'){
            NoDigit noDigit = new NoDigit("No digit");
            throw noDigit;
        }else{
            System.out.print(c);
        }
    }
}
public class ExceptionExample {
    public static void main(String[] args) {
        Test t = new Test();
        for(int i=0;i<128;i++){
            try{
                t.printDigit((char)i);
            }catch (NoDigit e){
                e.print();
            }
        }
    }
}