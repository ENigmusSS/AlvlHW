package ua.holovchenko.practice2;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class Practice2 {
    public static void main(String[] args) {
        int[] numbers = createFilledArray(10);
        System.out.println(Arrays.toString(numbers));
        System.out.println(isUnique(numbers));
        int[] check = {1, 2, 4, 9, 5,6};
        System.out.println(isUnique(check));
    }

    public static boolean isUnique(int[] numbers){
        int[] sorted = Arrays.copyOf(numbers ,numbers.length);
        Arrays.sort(sorted);
        System.out.println(Arrays.toString(sorted));
        boolean isUnicue = true;
        for (int i = 0; i < sorted.length-1; i++) {
            if (sorted[i] == sorted[i+1]) {
                isUnicue = false;
                break;
            }
        }
        return isUnicue;

    }

    public static int[] createFilledArray(int size){
        int[] numbers = new int[size];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = ThreadLocalRandom.current().nextInt( 1, 10);
        }
        return numbers;
    }
}
