package ua.holovchenko.hw5;

import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Task2 {
    public static void main(String[] args) {
        int[] numbers = createFilledArray(10);
        System.out.println(Arrays.toString(numbers));
        System.out.println(isNotRaising(numbers));
        int[] manual = manualInput();
        System.out.println(Arrays.toString(manual));
        System.out.println(isNotRaising(manual));

    }

    public static boolean isNotRaising(int[] array){
        boolean isNotRaising = true;
        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[i-1]) {
                isNotRaising = false;
                break;
            }
        }
        return isNotRaising;
    }

    public static int[] createFilledArray(int size){
        int[] numbers = new int[size];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = ThreadLocalRandom.current().nextInt( 1, 10);
        }
        return numbers;
    }

    public static int[] manualInput(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter array length");
        int[] array = new int[scanner.nextInt()];
        for (int i = 0; i < array.length; i++) {
            System.out.println("Enter the number");
            array[i] = scanner.nextInt();
        }
        return array;
    }

}
