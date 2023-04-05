package ua.holovchenko.hw5;

import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Task4 {
    public static void main(String[] args) {
        int[] array = createFilledArray(20);
        Scanner scanner = new Scanner(System.in);
        System.out.println(Arrays.toString(array));
        System.out.println("Enter element number to delete");
        int[] newArray = delElement(array, scanner.nextInt()-1);
        System.out.println(Arrays.toString(newArray));
    }

    public static int[] createFilledArray(int size){
        int[] numbers = new int[size];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = ThreadLocalRandom.current().nextInt( 1, 10);
        }
        return numbers;
    }
    public static int[] delElement(int[] array, int delIndex) {
        int[] newArray = new int[array.length-1];
        if (delIndex >= 0) System.arraycopy(array, 0, newArray, 0, delIndex);
        if (newArray.length - delIndex >= 0)
            System.arraycopy(array, delIndex + 1, newArray, delIndex, newArray.length - delIndex);
        return newArray;
    }

  /*  public static int[] delElement(int[] array, int delIndex) {
        int[] newArray = new int[array.length-1];
        for (int i = 0; i < delIndex; i++) {
            newArray[i] = array[i];
        }
        for (int i = delIndex; i < newArray.length; i++) {
            newArray[i] = array[i+1];
        }
        return newArray;
    } */
}
