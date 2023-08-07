package ua.holovchenko.hw17.task2;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class Task2 {
    public static IntSummaryStatistics nonNegativeFilter(List<Integer> list) {
        return list.stream()
                .filter(x -> x >= 0)
                .collect(IntSummaryStatistics::new,
                    IntSummaryStatistics::accept,
                    IntSummaryStatistics::combine);
    }

    public static void main(String[] args) {
        Random random = new Random();
        System.out.println(nonNegativeFilter(
                Stream.generate(random::nextInt)
                .limit(20)
                .peek(System.out::println)
                .toList()));
    }
}
