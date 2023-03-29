package ua.holovchenko.hw4;

import java.util.Arrays;

public class Task3 {
    public static void main(String[] args) {
        int[] array = new int[1000];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) ((Math.random() * 100) + 1);
        }
        System.out.println(Arrays.toString(array));
        System.out.println(compositeCount(array) + "composites");
    }

    public static int compositeCount(int[] array) {
        int count = 0;
        for (int num : array) {
            boolean isComposite = false;
            for (int i = 2; i < num; i++) {
                if (num % i == 0) {
                    isComposite = true;
                    break;
                }
            }
            if (isComposite) count++;
        }
        return count;
    }
}

