package ua.holovchenko.practice2;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class Task1 {

    public static void main(String[] args) {
        int[] pricelist = createPricelist();
        System.out.println(Arrays.toString(pricelist));
        System.out.println("Sum of prices over 1000 uah " + sumOver1000(pricelist));
    }

    public static int[] createPricelist(){
        int[] pricelist = new int[12];
        for (int i = 0; i < pricelist.length; i++) {
            pricelist[i] = ThreadLocalRandom.current().nextInt(25, 175)*10;
        }
        return pricelist;

    }

    public static int sumOver1000(int[] pricelist){
        int sum = 0;
        for (int price:
             pricelist) {
            if (price > 1000) sum += price;
        }
        return sum;
    }
}
