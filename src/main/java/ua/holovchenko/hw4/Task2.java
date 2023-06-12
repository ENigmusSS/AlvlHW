package ua.holovchenko.hw4;

import java.util.Arrays;

public class Task2 {
    public static void main(String[] args) {
        int[] array = new int[1000];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) ((Math.random() * 100)+1);
        }
        System.out.println(Arrays.toString(array));
        System.out.println(simpleCount(array) + "simples");


    }

    public static int simpleCount(int[] array) {
        int count = 0;
        for (int num : array) {
            boolean isSimple = num != 1;
            for (int i = 2; i < num; i++) {
                if (num % i == 0) {
                    isSimple = false;
                    break;
                }
            }
            if (isSimple) count++;
        }
        return count;
    }
}
