package ua.holovchenko.hw5;

import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Task3 {
    public static void main(String[] args) {
        int[][] source = createArray();
        System.out.println("Source matrix");
        for (int[] ints : source) {
            System.out.println(Arrays.toString(ints));
        }
        int[][] reverse = transposeMatrix(source);
        System.out.println("Reversed matrix");
        for (int[] ints : reverse) {
            System.out.println(Arrays.toString(ints));
        }
    }

    public static int[][] createArray() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter matrix size");
        int size = scanner.nextInt();
        int[][] array = new int[size][size];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = ThreadLocalRandom.current().nextInt(0, 9);
            }
        }
        return array;
    }

    public static int[][] transposeMatrix(int[][] source) {
        int[][] transposed = new int[source.length][source[0].length];
        for (int i = 0; i < transposed.length; i++) {
            for (int j = 0; j < transposed[i].length; j++) {
                transposed[i][j] = source[j][i];
            }
        }
        return transposed;
    }
}
