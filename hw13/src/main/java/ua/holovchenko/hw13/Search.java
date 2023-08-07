package ua.holovchenko.hw13;

import org.jetbrains.annotations.NotNull;

public class Search {
    public static int linearSearch(int@NotNull[] array, int x) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == x) return i;
        }
        return -1;
    }
    public static int binarySearch(int@NotNull[] array, int floor, int ceiling, int x)
    {
        if (ceiling >= floor) {
            int mid = floor + (ceiling - floor) / 2;
            if (array[mid] == x)
                return mid;
            if (array[mid] > x)
                return binarySearch(array, floor, mid - 1, x);
            return binarySearch(array, mid + 1, ceiling, x);
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = new int[1000];
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }
        long startTime = System.nanoTime();
        linearSearch(array,array[array.length-1]);
        long endTime = System.nanoTime();
        System.out.println("Linear search worst case:" + (endTime-startTime));
        startTime = System.nanoTime();
        binarySearch(array, 0, array.length-1, array[array.length-1]);
        endTime = System.nanoTime();
        System.out.println("Binary search worst case:" + (endTime-startTime));

    }
}
