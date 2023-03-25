package ua.holovchenko.hw3;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the line");
        String string = scanner.nextLine();
        string =spaceTrimmer(string);
        System.out.println(wordAmount(string) + " word(s)");

    }
    public static String spaceTrimmer(String string) {
        string = string.trim();
        while (string.contains("  ")) {
        string = string.replaceAll("  ", " ");}
        return string;
    }
    public static int wordAmount(String string) {
        StringBuilder stringBuilder = new StringBuilder(string);
        int wordAmount = 1;
        for (int i = 0; i < stringBuilder.length(); i++) {
            if (stringBuilder.charAt(i) == 32) {
                wordAmount++;
            }
        }
        return wordAmount;
    }
}
