package ua.holovchenko.hw17.task4;

import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class Task4 {
    public static Integer findMin(List<Integer> list) {
        return list.stream().reduce(Integer::min).get();
    }

    public static void main(String[] args) {
        Random random = new Random();
        System.out.println("Min is "
                + findMin(Stream.generate(random::nextInt)
                        .limit(10)
                        .peek(System.out::println)
                        .toList()));
    }
}
