package ua.holovchenko.hw16.task3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Task3 {
    public static ArrayList<Integer> createFillArrayList() {
        long startTime = System.nanoTime();
        ArrayList<Integer> arrayList = new ArrayList<>(1000000);
        for (int i = 0; i < 1000000; i++) {
            arrayList.add(i);
        }
        long endTime = System.nanoTime();
        System.out.println("1000000el ArrayList creation:" + (endTime-startTime));
        return arrayList;
    }
    public static LinkedList<Integer> createFillLinkedList() {
        long startTime = System.nanoTime();
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 1000000; i++) {
            linkedList.add(i);
        }
        long endTime = System.nanoTime();
        System.out.println("1000000el LinkedList creation:" + (endTime-startTime));
        return linkedList;
    }
    public static void rndChoose(List<Integer> list) {
        Random rnd = new Random();
        long startTime = System.nanoTime();
        for (int i = 0; i < 1000000; i++) {
            list.get(rnd.nextInt(0,list.size()));
        }
        long endTime = System.nanoTime();
        System.out.println("1 000 000 chooses time:" + (endTime-startTime));
    }

    public static void main(String[] args) {
        rndChoose(createFillArrayList());
        rndChoose(createFillLinkedList());
    }
}
