package ua.holovchenko.hw4;

import java.util.Arrays;

import static java.util.Arrays.stream;

public class Task1 {
    public static void main(String[] args) {
        int[] array = new int[400];
        for (int i = 0; i < array.length ; i++) {
            array[i] = (int) (Math.random()*10+1);
        }
        System.out.println(Arrays.toString(array));
        System.out.println("μ=" + m(array));
        System.out.println("s=" + s(array));

    }
    public static double m(int[] array){
        return stream(array).average().getAsDouble();
    }
    public static double s(int[] array){
        int[] sqArray = new int[array.length];
        for (int i = 0; i < sqArray.length ; i++) {
            sqArray[i] = array[i]*array[i];
        }
        return Math.sqrt(stream(sqArray).sum()/ (sqArray.length*1.0));
    }
}
