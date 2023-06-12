package ua.holovchenko.hw4;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;

import static java.util.Arrays.stream;

public class Task1 {
    public static void main(String[] args) {
        int[] array = new int[400];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 10 + 1);
        }
        System.out.println(Arrays.toString(array));
        System.out.println("μ=" + averageAriph(array));
        System.out.println("s=" + averageSqr(array));
        System.out.println("g=" + averageGeom(array));

    }

    public static double averageAriph(int[] array) {
        return stream(array).average().getAsDouble();
    }

    public static double averageSqr(int[] array) {
        int[] sqArray = new int[array.length];
        for (int i = 0; i < sqArray.length; i++) {
            sqArray[i] = array[i] * array[i];
        }
        return Math.sqrt(stream(sqArray).sum() / (sqArray.length * 1.0));
    }

    public static double averageGeom(int[] array) {
        double product = 1;
        for (int num : array) {
            product *= num;
        }
        return round(Math.exp(Math.log(product) / array.length),5);
        //return round(Math.pow(product, 1.0/array.length),5);
    }
    private static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(Double.toString(value));
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
