package lesson1;

import java.util.*;

public class GuessNumber {
    public static void main(String[] args) {
        System.out.println("Guess the number between 1 and 100");
        Scanner sc = new Scanner(System.in);
        int number = (int) (Math.random() * 100) + 1;
        int myGuess = 0;
        int guessCount = 1;
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter your guess: ");
        myGuess = reader.nextInt();
        while (myGuess != number) {
            if (myGuess > number) {
                System.out.println("Your guess is too high");
                guessCount++;
                myGuess = reader.nextInt();
            } else if (myGuess < number) {
                System.out.println("Your guess is too low");
                guessCount++;
                myGuess = reader.nextInt();
            }
        }
        if (guessCount < 4) {
            System.out.println("You are a genius!");
        } else if (guessCount > 8) {
            System.out.println("You are a loser!");
        } else {
            System.out.println("You are a good guesser!");
        }
    }
}