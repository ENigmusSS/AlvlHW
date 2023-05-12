package ua.holovchenko.practice2;

import java.util.Arrays;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        int[] heights = input();
        System.out.println(Arrays.toString(heights));
        int[] averages = getAverage(heights);
        System.out.println("Boys` average height is " + Math.abs(averages[0]) + ", girls` - " + averages[1]);
    }

    public static int[] input() {
        int[] heights = new int[25];
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter student`s height (newline each) (negative for male, positive for female");
        for (int i = 0; i < heights.length; i++) {
            heights[i] = scanner.nextInt();
        }
        return heights;
    }

    public static int[] getAverage(int[] heights) {
        int sumMale = 0;
        int countMale = 0;
        int sumFemale = 0;
        int countFemale = 0;
        for (int height:
             heights) {
            if (height > 0) {
                countFemale++;
                sumFemale += height;
            }
            else {
                countMale++;
                sumMale += height;
            }
        }
        return new int[]{sumMale/countMale, sumFemale/countFemale};
    }
}
