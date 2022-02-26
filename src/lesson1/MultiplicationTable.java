package lesson1;

public class MultiplicationTable {
    public static void main(String[] args) {
        int number=9;
        while(number>=1){
            int multiplier=1;
            while(multiplier<=number){
                System.out.print(number+"*"+multiplier+"="+number*multiplier+" ");
                multiplier++;
            }
            System.out.println();
            number--;
        }
    }
}
