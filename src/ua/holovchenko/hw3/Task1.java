package ua.holovchenko.hw3;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the line");
        String string = scanner.nextLine();
        String unSpacedString = unSpacer(string);
        System.out.println(unSpacedString);
        System.out.println("isPalindrome =" + isPalindrome(unSpacedString).toString());
    }

    public static String unSpacer(String string) {
        StringBuilder stringBuilder = new StringBuilder(string);
        for (int i = 0; i < stringBuilder.length(); i++) {
            if (stringBuilder.charAt(i) == 32) {
                stringBuilder.deleteCharAt(i);
                i--;
            }
        }
        return stringBuilder.toString();
    }

    public static Boolean isPalindrome(String string) {
        boolean isPalindrome = true;
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) != string.charAt(string.length() - (i + 1))) {
                isPalindrome = false;
                break;
            }

        }
        return isPalindrome;
    }
}