package ua.holovchenko.hw16.task3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Task3 {

    public static List<Integer> fillList(List<Integer> list) {
        long startTime = System.nanoTime();
        for (int i = 0; i < 1000000; i++) {
            list.add(i);
        }
        long endTime = System.nanoTime();
        System.out.println("1000000el List creation:" + (endTime - startTime));
        return list;
    }

    public static void rndChoose(List<Integer> list) {
        Random rnd = new Random();
        long startTime = System.nanoTime();
        for (int i = 0; i < 1000000; i++) {
            list.get(rnd.nextInt(0, list.size()));
        }
        long endTime = System.nanoTime();
        System.out.println("1 000 000 chooses time:" + (endTime - startTime));
    }

    public static void main(String[] args) {
        System.out.println("ArrayList:");
        rndChoose(fillList(new ArrayList<>()));
        System.out.println("LinkedList:");
        rndChoose(fillList(new LinkedList<>()));
    }
}
