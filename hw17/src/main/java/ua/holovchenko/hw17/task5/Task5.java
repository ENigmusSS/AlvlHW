package ua.holovchenko.hw17.task5;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

public class Task5 {

    private static final Random random = new Random();
    private static List<Item> initItemList(int count) {
        ArrayList<Item> items = new ArrayList<>(count);
        String[] itemNames = {"Accordion", "Acoustic Guitar", "Bass Guitar", "Cello", "Clarinet", "Drums", "Electric Guitar", "Flute", "Ukulele", "Violin", "Saxophone", "Sitar", "Trumpet"};
        for (int i = 0; i < count; i++) {
            items.add(new Item(itemNames[random.nextInt(0, itemNames.length)], (random.nextInt(1, 100)*100)));
        }
        return items;
    }

    private static List<Box> initBoxList(int count) {
        ArrayList<Box> boxes = new ArrayList<>(count);
        int nextBoxSize;
        for (int i = 0; i < count; i++) {
            nextBoxSize = random.nextInt(1, 20);
            boxes.add(new Box(nextBoxSize, initItemList(nextBoxSize)));
        }
        return boxes;
    }

    public static void main(String[] args) {
        initBoxList(10)
                .stream()
                .filter(box -> box.isSuitable(10))
                .map(Box::getItemList)
                .flatMap(Collection::stream)
                .sorted()
                .forEach(System.out::println);
        //.peek(System.out::println).toList если отсортированная сводка нужна далее
    }
}
