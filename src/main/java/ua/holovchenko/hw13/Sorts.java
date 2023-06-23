package ua.holovchenko.hw13;

import java.util.Arrays;
import java.util.Random;


public class Sorts {
    public static int[] bubbleSort(int[] array) {
        int[] sorted = array.clone();
        int n = sorted.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (sorted[j] > sorted[j + 1]) {
                    swap(sorted, j, j+1);
                }
            }
        }
        return sorted;
    }
    public static int[] quickSort(int[] array) {
        int[] sorted = array.clone();
        sort(sorted, 0, sorted.length - 1);
        return sorted;
    }

    private static void sort(int[] array, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(array, low, high);
            sort(array, low, pivotIndex - 1);
            sort(array, pivotIndex + 1, high);
        }
    }

    private static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, high);
        return i + 1;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    public static void main(String[] args) {
        Random random = new Random();
        int[] worst = new int[1_000];
        for (int i = 0; i < worst.length; i++) {
            worst[i] = worst.length-i;
        }
        int[] rnd = new int[1_000];
        for (int i = 0; i < rnd.length; i++) {
            rnd[i] = random.nextInt(0,1000);
        }
        System.out.println("BubbleSort");
        long startTime = System.nanoTime();
        int[] worstBubblesorted = bubbleSort(worst);
        long endTime = System.nanoTime();
        System.out.println("Worst case:" + (endTime-startTime));
        startTime = System.nanoTime();
        int[] rndBubbleSorted = bubbleSort(rnd);
        endTime = System.nanoTime();
        System.out.println("Random case " + (endTime-startTime));
        System.out.println("QuickSort");
        startTime = System.nanoTime();
        int[] worstQuickSorted = quickSort(worst);
        endTime = System.nanoTime();
        System.out.println("Worst case" + (endTime-startTime));
        startTime = System.nanoTime();
        int[] rndQuickSorted = quickSort(rnd);
        endTime = System.nanoTime();
        System.out.println("Random case " + (endTime-startTime));
        System.out.println("Random case sort check:" + Arrays.equals(rndBubbleSorted, rndQuickSorted));
    }
}
