package ua.holovchenko.hw1;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        int num = getUserNum();
        int revNum = reverse(num);
        System.out.println(revNum);
    }
    public static int getUserNum() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number");
        return scanner.nextInt();
    }
    public static int reverse (int num) {
        String numSt = String.valueOf(num);
        StringBuilder numStB = new StringBuilder(numSt);
        String revSt = numStB.reverse().toString();
        return Integer.parseInt(revSt);
    }
}