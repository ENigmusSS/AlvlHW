package ua.holovchenko.hw4;

import java.util.Arrays;

public class Task4 {
    public static void main(String[] args) {
        int[] array = new int[2000];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) ((Math.random() * 100) + 1);
        }
        int[] unEvened = evenToZero(array);
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(unEvened));
    }

    public static int[] evenToZero(int[] array) {
        int[] unEvened = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            unEvened[i] = array[i] % 2 == 0 ? 0 : array[i];
        }
        return unEvened;
    }
}
