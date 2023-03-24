package ua.holovchenko.hw3;

import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = (int) (1000*Math.random());
        boolean hit = false;
        while (!hit) {
            int guess = userGuess(scanner);
            hit = compare(number, guess);
        }
    }
    public static int userGuess(Scanner scanner) {
        System.out.println("Guess the number from 0 to 999");
        return scanner.nextInt();
    }
    public static boolean compare(int num, int guess) {
        boolean hit = false ;
        if (guess > num) {
            System.out.println("Перелёт");
        } else if (guess < num) {
            System.out.println("Недолёт");
        }
        else {
            System.out.println("Попал");
            hit = true;
        }
        return hit;
    }

}
