package ua.holovchenko.hw17.task1;

import java.util.ArrayList;
import java.util.List;

public class Task1 {
    public static void printSorted(List<String> list) {
        list.stream().sorted().forEach(System.out::println);
    }

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Aether");
        list.add("Chaos");
        list.add("Nyx");
        list.add("Nemesis");
        list.add("Gaia");
        list.add("Aion");
        list.add("Eros");
        list.add("Hypnos");
        printSorted(list);
    }
}
