package ua.holovchenko.hw5;

import java.util.Arrays;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        int[][] array = fill(create());
        for (int[] ints : array) {
            System.out.println(Arrays.toString(ints));
        }
    }

    public static int[][] create() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter matrix` sizes");
        return new int[scanner.nextInt()][scanner.nextInt()];
    }

    public static int[][] fill(int[][] array) {
        int index = -1;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = i % 2 == 0 ? Math.abs(index--) : index--;
            }
        }
        return array;
    }
}
